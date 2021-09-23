package com.example.surveyapp.Controllers;

import com.example.surveyapp.Models.*;
import com.example.surveyapp.dtoObjects.AuthorAnswersDTO;
import com.example.surveyapp.dtoObjects.QuestionDTO;
import com.example.surveyapp.service.answerService;
import com.example.surveyapp.service.authorService;
import com.example.surveyapp.service.questionService;
import com.example.surveyapp.service.surveysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    private authorService authorService;

    @Autowired
    private questionService questionService;

    @Autowired
    private surveysService surveysService;

    @Autowired
    private answerService answerService;

    @GetMapping("/")
    public String mainPage(@RequestParam(value = "author_id",required = false) Long author_id,
                            Model model){
        List<Survey> passedSurveysByAuthor = surveysService.findAuthorPassedSurveys(author_id);
        model.addAttribute("author_id", author_id);
        model.addAttribute("passed_surveys", passedSurveysByAuthor);
        return "HelloPage";
    }

    @PostMapping("/")
    public String postAuthor(@RequestParam("authorname") String authorname){
        Author author = authorService.saveAuthor(authorname);
        return "redirect:/surveys/" + author.getId();
    }

    @GetMapping("/surveys/{author_id}")
    public String getSurveys(@PathVariable("author_id") Author author,
                             Model model){
        List<QuestionDTO> questions = questionService.findFirstQuestionsFromSurveys();
        model.addAttribute("questions",questions);
        model.addAttribute("author", author);
        return "surveys";
    }

    @GetMapping("/surveys/{author_id}/{survey_id}/{question_id}")
    public String question(@PathVariable("survey_id") Long survey,
                           @PathVariable("author_id") Author author,
                           @PathVariable("question_id") Long current_questionId,
                           Model model){
        QuestionDTO current_question = questionService.foundById(current_questionId);
        List<String> answer_options = questionService.answer_options(current_question.getAnswer_options());
        model.addAttribute("author",author);
        model.addAttribute("survey_id", current_question.getSurvey_id());
        model.addAttribute("current_question",current_question);
        model.addAttribute("answer_options",answer_options);
        return "question";
    }

    @PostMapping("/surveys/{author_id}/{survey_id}/{question_id}")
    public String questionAnswer(@PathVariable("survey_id") Long survey,
                                 @PathVariable("author_id") Author author,
                                 @PathVariable("question_id") Question question,
                                 @Valid Answer Author_answer,
                                 BindingResult bindingResult,
                                 Model model,
                                 @RequestParam(value = "question_text", required = false) String question_text,
                                 @RequestParam Map<String, String> form){
        Author_Question_key key = new Author_Question_key(author, question);
        Author_answer.setAuthorQuestionKey(key);
        if (question_text != null) {
            Author_answer.setAnswer(question_text);
            answerService.saveAnswer(Author_answer);
        }
        if (question.getType().name().equals(QuestionType.SINGLE.name())){
            if (form.get("questionSingle")!=null){
                Author_answer.setAnswer(form.get("questionSingle"));
                answerService.saveAnswer(Author_answer);
            }
        }
        if (question.getType().name().equals(QuestionType.MULTY.name())){
            if (form.get("questionMulti")!=null){
                String multi_answer = answerService.answerCombine(form);
                Author_answer.setAnswer(multi_answer);
                answerService.saveAnswer(Author_answer);
            }
        }
        QuestionDTO nextQuestion = questionService.nextQuestion(survey,question.getId());
        return nextQuestion!=null ? "redirect:/surveys/{author_id}/{survey_id}/" + nextQuestion.getQuestionId()
                                    : "redirect:/results/" + question.getSurvey().getId() + "/" + author.getId();
    }

    @GetMapping("/results/{survey_id}/{author_id}")
    public String results(@PathVariable("survey_id") Survey survey,
                          @PathVariable("author_id") Author author,
                          Model model){
        List<AuthorAnswersDTO> authorAnswers = answerService.getAuthorAnswers(author.getId(),survey.getId());
        model.addAttribute("authorAnswer", authorAnswers);
        model.addAttribute("author", author);
        model.addAttribute("survey", survey);
        return "results";
    }
}
