package com.example.surveyapp.Models;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class Author_Question_key implements Serializable {

    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "question_id",referencedColumnName = "id")
    private Question question;

    public Author_Question_key(){}

    public Author_Question_key(Author author, Question question) {
        this.author = author;
        this.question = question;
    }

    public Author getAuthor() {
        return author;
    }

    public Question getQuestion() {
        return question;
    }
}
