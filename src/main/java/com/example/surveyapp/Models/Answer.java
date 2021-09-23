package com.example.surveyapp.Models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @EmbeddedId
    private Author_Question_key authorQuestionKey;

    @NotBlank(message = "please answer the question!")
    private String answer;

    public Answer(){}

    public Answer(Author_Question_key key, String answer) {
        this.authorQuestionKey = key;
        this.answer = answer;
    }

    public Author_Question_key getAuthorQuestionKey() {
        return authorQuestionKey;
    }

    public void setAuthorQuestionKey(Author_Question_key authorQuestionKey) {
        this.authorQuestionKey = authorQuestionKey;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
