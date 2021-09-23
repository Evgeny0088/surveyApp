package com.example.surveyapp.Models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "question text should not be empty")
    private String text;

    @Enumerated(EnumType.STRING)
    private QuestionType question_type;

    private String answer_options;

    @NotBlank(message = "right answer must be provided")
    private String right_answers;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id")
    private Survey survey;

    public Question() {}

    public Question(Long id, String text, QuestionType questionType, String AnswerOptions, String rightAnswers, Survey survey) {
        this.id = id;
        this.text = text;
        this.question_type = questionType;
        this.answer_options = AnswerOptions;
        this.right_answers = rightAnswers;
        this.survey = survey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuestionType getType() {
        return question_type;
    }

    public void setType(QuestionType type) {
        this.question_type = type;
    }

    public String getAnswerOptions() {
        return answer_options;
    }

    public void setAnswerOptions(String answerOptions) {
        this.answer_options = answerOptions;
    }

    public String getRightAnswers() {
        return right_answers;
    }

    public void setRightAnswers(String rightAnswers) {
        this.right_answers = rightAnswers;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
}
