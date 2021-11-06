package com.example.surveyapp.Controllers;

import com.example.surveyapp.Models.Question;
import com.example.surveyapp.Models.Survey;
import com.example.surveyapp.exceptions.NotFoundException;
import com.example.surveyapp.repositories.QuestionRepo;
import com.example.surveyapp.repositories.SurveyRepo;
import com.example.surveyapp.service.questionService;
import com.example.surveyapp.service.surveysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class deleteController {

    @Autowired
    surveysService surveyService;

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    questionService questionService;

    @Autowired
    SurveyRepo surveyRepo;

    @RequestMapping(method = RequestMethod.GET, value = "/survey/delete/{id}")
    public String deleteSurvey(@PathVariable("id") Long id, Model model) throws NotFoundException{
        Optional<Survey> survey = surveyRepo.findById(id);
        if (survey.isEmpty()) {
            throw new NotFoundException(id,"survey");
        }
        surveyService.deleteSurvey(id);
        model.addAttribute("survey_id", id);
        return "delete_survey";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/question/delete/{id}")
    public String deleteQuestion(@PathVariable("id") Long id, Model model)throws NotFoundException{
        Optional<Question> question = questionRepo.findById(id);
        if (question.isEmpty()) {
            throw new NotFoundException(id,"question");
        }
        questionService.deleteQuestion(id);
        model.addAttribute("question_id", id);
        return "delete_question";
    }
}
