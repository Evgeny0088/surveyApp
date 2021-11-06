package com.example.surveyapp.service;

import com.example.surveyapp.Models.Question;
import com.example.surveyapp.Models.QuestionType;
import com.example.surveyapp.dtoObjects.QuestionDTO;
import com.example.surveyapp.exceptions.NotFoundException;
import com.example.surveyapp.repositories.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class questionService {

    @Autowired
    QuestionRepo questionRepo;

    public void updateQuestion(Question question, Map<String, String> form){
        String type = form.get("question_type") == null ? QuestionType.SINGLE.name() : form.get("question_type");
        question.setType(QuestionType.valueOf(type));
        question.setText(form.get("text"));
        question.setAnswerOptions(form.get("answer_options"));
        question.setRightAnswers(form.get("right_answers"));
        questionRepo.save(question);
    }

    public void deleteQuestion(Long id){
        questionRepo.deleteById(id);
    }

    public List<QuestionDTO> findFirstQuestionsFromSurveys(){

        return questionRepo.findFirstQuestionsFromSurveys();
    }

    public QuestionDTO nextQuestion(Long survey_id, Long question_id){
        return questionRepo.findNextQuestion(survey_id, question_id);
    }

    public QuestionDTO foundById(Long id){
        return questionRepo.foundById(id);
    }

    public List<String> answer_options(String NotParcedString){
        return Arrays.stream(NotParcedString.split("::")).collect(Collectors.toList());
    }
}
