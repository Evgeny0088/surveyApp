package com.example.surveyapp.service;

import com.example.surveyapp.Models.Answer;
import com.example.surveyapp.dtoObjects.AuthorAnswersDTO;
import com.example.surveyapp.repositories.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class answerService {

    @Autowired
    AnswerRepo answerRepo;

    public void saveAnswer(Answer answer){
        answerRepo.save(answer);
    }

    public String answerCombine(Map<String, String> form){
        return form.keySet().toArray().length==1 ? form.entrySet().iterator().next().getValue() :
                String.join("::", form.values());
    }

    public List<AuthorAnswersDTO> getAuthorAnswers(Long author_id, Long survey_id){
        return answerRepo.getAnswerByAuthorAndSurvey(author_id,survey_id);
    }
}
