package com.example.surveyapp.repositories;

import com.example.surveyapp.Models.Answer;
import com.example.surveyapp.Models.Author_Question_key;
import com.example.surveyapp.dtoObjects.AuthorAnswersDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer, Author_Question_key> {

    @Query("select new com.example.surveyapp.dtoObjects.AuthorAnswersDTO( " +
            " q, a) " +
            " from Question as q left join Answer as a on q.id=a.authorQuestionKey.question.id " +
            " where a.authorQuestionKey.author.id=:author_id and q.survey.id=:survey_id ")
    List<AuthorAnswersDTO> getAnswerByAuthorAndSurvey(@Param("author_id") Long author_id,@Param("survey_id") Long survey_id);

}

