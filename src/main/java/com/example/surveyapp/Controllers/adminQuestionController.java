package com.example.surveyapp.Controllers;

import com.example.surveyapp.Models.Question;
import com.example.surveyapp.Models.QuestionType;
import com.example.surveyapp.Models.Survey;
import com.example.surveyapp.service.questionService;
import com.example.surveyapp.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class adminQuestionController {

    @Autowired
    questionService questionService;

    @GetMapping("admin/edit/{survey_id}/createQuestion")
    public String createQuestion(@PathVariable("survey_id") Survey survey,
                                 @RequestParam(value = "message",required = false) String message,
                                 Model model){
        model.addAttribute("message",message);
        model.addAttribute("questionTypes", QuestionType.values());
        return "createQuestion";
    }

    @GetMapping("admin/edit/{survey_id}/editQuestion")
    public String editSurvey(@PathVariable("survey_id") Long survey_id,
                             @RequestParam(value = "question") Question question,
                             @RequestParam(value = "message",required = false) String message,
                             Model model){
        model.addAttribute("message",message);
        model.addAttribute("text", question.getText());
        model.addAttribute("question_type", question.getType());
        model.addAttribute("answerOptions", question.getAnswerOptions());
        model.addAttribute("rightAnswers", question.getRightAnswers());
        model.addAttribute("questionTypes", QuestionType.values());
        model.addAttribute("survey", survey_id);
        return "editQuestion";
    }

    @PostMapping("admin/edit/{survey_id}/editQuestion")
    public String editSurveyPost(@PathVariable("survey_id") Long id,
                                 @ModelAttribute("question") @Valid Question question,
                                 BindingResult bindingResult,
                                 Model model,
                                 @RequestParam Map<String,String> form){
        String s = "";
        System.out.println(s);
        if (bindingResult.hasErrors()){
            Map<String,String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            String message = "please fill required fields!";
            return String.format("redirect:editQuestion?question=%d&message=%s", question.getId(),message);
        }
        questionService.updateQuestion(question, form);
        return "redirect:/admin";
    }

    @PostMapping("admin/edit/{survey_id}/createQuestion")
    public String createQuestionPost(@PathVariable("survey_id") Survey survey,
                                     @RequestParam("text") String text,
                                     @RequestParam("question_type") String question_type,
                                     @RequestParam("answer_options") String answer_options,
                                     @RequestParam("right_answers") String right_answers,
                                     @ModelAttribute @Valid Question question,
                                     BindingResult bindingResult1, Model model){
        question.setSurvey(survey);
        question.setText(text);
        question.setRightAnswers(right_answers);
        question.setAnswerOptions(answer_options);
        question.setType(QuestionType.valueOf(question_type));
        if (bindingResult1.hasErrors()){
            Map<String,String> errors = ControllerUtils.getErrors(bindingResult1);
            model.mergeAttributes(errors);
            String message = "please fill required fields!";
            return String.format("redirect:createQuestion?message=%s", message);
        }
        questionService.createQuestion(question);
        return "redirect:/admin";
    }
}
