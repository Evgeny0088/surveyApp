package com.example.surveyapp.Models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "survey must have a name!")
    @Column(unique = true)
    private String sname;

    private String description;

    @OneToMany(mappedBy = "survey")
    private Set<Question> questions = new HashSet<>();

    public Survey(){}

    public Survey(String sname, String description) {
        this.sname = sname;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
