package com.example.surveyapp.dtoObjects;

import com.example.surveyapp.Models.Question;

public class QuestionDTO {
    private Long survey_id;
    private String surveyname;
    private String surveyDescription;
    private Long questionId;
    private String text;
    private String question_type;
    private String answer_options;

    public QuestionDTO(Question question, String surveyname, String surveyDescription){
        this.survey_id = question.getSurvey().getId();
        this.surveyname = surveyname;
        this.surveyDescription = surveyDescription;
        this.questionId = question.getId();
        this.text = question.getText();
        this.question_type = question.getType().name();
        this.answer_options = question.getAnswerOptions();
    }

    public Long getSurvey_id() {
        return survey_id;
    }

    public String getSurveyname() {
        return surveyname;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getText() {
        return text;
    }

    public String getQuestion_type() {
        return question_type;
    }

    public String getAnswer_options() {
        return answer_options;
    }

    public String getSurveyDescription() {
        return surveyDescription;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "survey_id=" + survey_id +
                ", surveyname='" + surveyname + '\'' +
                ", surveyDescription='" + surveyDescription + '\'' +
                ", questionId=" + questionId +
                ", text='" + text + '\'' +
                ", question_type='" + question_type + '\'' +
                ", answer_options='" + answer_options + '\'' +
                '}';
    }
}
