package com.example.surveyapp.dtoObjects;

import com.example.surveyapp.Models.Answer;
import com.example.surveyapp.Models.Question;

public class AuthorAnswersDTO {
    private Long surveyId;
    private Long authorId;
    private Long questionId;
    private String right_answer;
    private String author_answer;

    public AuthorAnswersDTO(Question question, Answer answer){
        this.surveyId = question.getSurvey().getId();
        this.authorId = answer.getAuthorQuestionKey().getAuthor().getId();
        this.questionId = question.getId();
        this.right_answer = question.getRightAnswers();
        this.author_answer = answer.getAnswer();
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getRight_answer() {
        return right_answer;
    }

    public String getAuthor_answer() {
        return author_answer;
    }

    public boolean isChecked() {
        return right_answer.equals(author_answer);
    }

    @Override
    public String toString() {
        return "AuthorAnswersDTO{" +
                "surveyId=" + surveyId +
                ", authorId=" + authorId +
                ", questionId=" + questionId +
                ", right_answer='" + right_answer + '\'' +
                ", author_answer='" + author_answer + '\'' +
                '}';
    }
}
