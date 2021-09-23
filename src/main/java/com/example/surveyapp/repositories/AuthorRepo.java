package com.example.surveyapp.repositories;

import com.example.surveyapp.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {

}
