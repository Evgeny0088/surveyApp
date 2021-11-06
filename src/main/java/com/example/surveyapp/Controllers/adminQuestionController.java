package com.example.surveyapp.Controllers;

import com.example.surveyapp.Models.Question;
import com.example.surveyapp.Models.QuestionType;
import com.example.surveyapp.Models.Survey;
import com.example.surveyapp.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class adminQuestionController {

    @Autowired
    questionService questionService;

    @GetMapping("/edit/{survey_id}/createQuestion")
    public String createQuestion(@PathVariable("survey_id") Survey survey,
                                 @RequestParam(value = "message",required = false) String message,
                                 Model model){
        model.addAttribute("message",message);
        model.addAttribute("questionTypes", QuestionType.values());
        return "createQuestion";
    }

    @PostMapping("/edit/{survey_id}/createQuestion")
    public String createQuestionPost(@PathVariable("survey_id") Survey survey,
                                     @RequestParam Map<String,String> form){
        if (form.get("text").isEmpty() || form.get("right_answers").isEmpty()){
            String message = "please fill required fields!";
            return String.format("redirect:/admin/edit/%s/createQuestion?message=%s", survey.getId(), message);
        }else {
            Question question = new Question();
            question.setSurvey(survey);
            questionService.updateQuestion(question, form);
            return "redirect:/admin";
        }
    }

    @GetMapping("/edit/{survey_id}/editQuestion/{question_id}")
    public String editSurvey(@PathVariable("survey_id") Long survey_id,
                             @PathVariable("question_id") Question question,
                             @RequestParam(value = "message",required = false) String message,
                             Model model){
        model.addAttribute("message", message);
        model.addAttribute("question", question);
        model.addAttribute("questionTypes", QuestionType.values());
        model.addAttribute("survey", survey_id);
        return "editQuestion";
    }

    @PostMapping("/edit/{survey_id}/editQuestion/{question_id}")
    public String editSurveyPost(@PathVariable("survey_id") Survey survey,
                                 @PathVariable("question_id") Question question,
                                 @RequestParam Map<String,String> form){
        if (form.get("text").isEmpty() || form.get("right_answers").isEmpty()){
            String message = "please fill required fields!";
            return String.format("redirect:/admin/edit/%s/editQuestion/%s?message=%s", survey.getId(), question.getId(), message);
        }else {
            question.setSurvey(survey);
            questionService.updateQuestion(question, form);
            return "redirect:/admin";
        }
    }
}
