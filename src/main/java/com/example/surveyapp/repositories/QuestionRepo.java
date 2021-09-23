package com.example.surveyapp.repositories;

import com.example.surveyapp.Models.Question;
import com.example.surveyapp.dtoObjects.QuestionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question, Long> {

    @Query("select new com.example.surveyapp.dtoObjects.QuestionDTO(" +
            " q, " +
            " s.sname, s.description) " +
            " from Question as q left join Survey as s " +
            " on q.survey.id=s.id " +
            " where q.id in (select min(id) from Question group by survey.id) " +
            " order by q.id ")
    List<QuestionDTO> findFirstQuestionsFromSurveys();

    @Query("select new com.example.surveyapp.dtoObjects.QuestionDTO(" +
            " q, " +
            " s.sname, s.description) " +
            " from Question as q " +
            "left join Survey as s on q.survey.id=s.id where s.id=:survey_id and q.id=( " +
            " select min(id) from q where q.survey.id=:survey_id and id>:current_question) ")
    QuestionDTO findNextQuestion(@Param("survey_id") Long survey_id, @Param("current_question") Long question_id);

    @Query("select new com.example.surveyapp.dtoObjects.QuestionDTO( " +
            " q, " +
            " s.sname, s.description) " +
            " from Question as q left join Survey as s on q.survey.id=s.id where q.id=:questionId ")
    QuestionDTO foundById(@Param("questionId") Long questionId);

    @Query("select new com.example.surveyapp.dtoObjects.QuestionDTO(" +
            " q, " +
            " s.sname, s.description) " +
            " from Question as q left join Survey as s " +
            " on q.survey.id=s.id where s.id=:survey_id ")
    List<QuestionDTO> findSurveyForEdit(@Param("survey_id")Long survey_id);

}
