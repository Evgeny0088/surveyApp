package com.example.surveyapp.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authorname;

    @ManyToMany
    @JoinTable(name = "AuthorPassedSurveys", joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "survey_id",referencedColumnName = "id"))
    Set<Survey> surveys = new HashSet<>();

    public Author() {}

    public Author(String authorname) {
        this.authorname = authorname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname==null || authorname.isEmpty()? "default user" : authorname;
    }

    public Set<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(Set<Survey> surveys) {
        this.surveys = surveys;
    }
}
