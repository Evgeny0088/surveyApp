package com.example.surveyapp.repositories;

import com.example.surveyapp.Models.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SurveyRepo extends JpaRepository<Survey, Long> {

    Optional<Survey> findById(Long survey_id);

    @Query(value = "select * from surveys left join author_passed_surveys aps on surveys.id = aps.survey_id where aps.author_id=:author", nativeQuery = true)
    List<Survey> findSurveyByAuthor(Long author);

}
