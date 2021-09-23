package com.example.surveyapp.service;

import com.example.surveyapp.Models.Question;
import com.example.surveyapp.Models.Survey;
import com.example.surveyapp.dtoObjects.QuestionDTO;
import com.example.surveyapp.exceptions.NotFoundException;
import com.example.surveyapp.repositories.QuestionRepo;
import com.example.surveyapp.repositories.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class surveysService {

    @Autowired
    SurveyRepo surveyRepo;

    @Autowired
    QuestionRepo questionRepo;

    public List<Survey> surveys(){
        return surveyRepo.findAll();
    }

    public List<Survey> findAuthorPassedSurveys(Long authorId){
        return surveyRepo.findSurveyByAuthor(authorId);
    }

    public List<QuestionDTO> findSurveyForEdit(Long survey_Id){
        return questionRepo.findSurveyForEdit(survey_Id);
    }

    public void saveSurvey(Survey survey){
        surveyRepo.save(survey);
    }

    public void deleteSurvey(Long id){
        surveyRepo.deleteById(id);
    }

}
