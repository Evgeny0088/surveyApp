package com.example.surveyapp.Controllers;

import com.example.surveyapp.Models.Admin;
import com.example.surveyapp.Models.Survey;
import com.example.surveyapp.service.adminService;
import com.example.surveyapp.service.questionService;
import com.example.surveyapp.service.surveysService;
import com.example.surveyapp.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Map;

@Controller
public class adminController {

    @Autowired
    adminService adminService;

    @Autowired
    surveysService surveyService;

    @Autowired
    questionService questionService;

    @GetMapping("admin")
    public String adminPage(Model model){
        List<Survey> surveys = surveyService.surveys();
        model.addAttribute("surveys",surveys);
        return "adminPage";
    }

    @GetMapping("login")
    public String getLogin(@Valid Admin admin,
                           BindingResult bindingResult,
                           Model model) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (bindingResult.hasErrors()){
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            model.addAttribute("admin", admin);
            return "login";
        }
        if (admin.equals(adminService.verifiedAdmin(admin.getUsername(),admin.getPassword()))){
            return "redirect:/surveyApp/admin";
        }else {
            model.addAttribute("message","bad credentials");
        }
        return "login";
    }

    @GetMapping("admin/createSurvey")
    public String createSurvey(){
        return "createSurvey";
    }

    @PostMapping("admin/createSurvey")
    public String createSurveyPost(@Valid Survey survey, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            Map<String,String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "createSurvey";
        }else {
            if (surveyService.CheckIfSurveyIsExistsWithSameName(survey)){
                model.addAttribute("message","survey with this name already exists!");
                return "createSurvey";
            }
            surveyService.saveSurvey(survey);
            return "redirect:/admin";
        }
    }

    @GetMapping("admin/edit/{survey_id}")
    public String editSurvey(@PathVariable("survey_id") Survey survey,
                             Model model){
        model.addAttribute("surveyName", survey.getSname());
        model.addAttribute("surveyDescription", survey.getDescription());
        model.addAttribute("survey_id", survey.getId());
        model.addAttribute("questions", survey.getQuestions());
        if (survey.getQuestions().isEmpty()){
            model.addAttribute("message", "survey is empty now!");
        }
        return "editSurvey";
    }

    @PostMapping("admin/edit/{survey_id}")
    public String editSurveyPost(@PathVariable("survey_id") Long id,
                                 @Valid Survey survey,
                                 BindingResult bindingResult,
                                 Model model){
        if (bindingResult.hasErrors()){
            Map<String,String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "editSurvey";
        }else {
            survey.setId(id);
            surveyService.saveSurvey(survey);
            return "redirect:/admin";
        }
    }
}
