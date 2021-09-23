package com.example.surveyapp.repositories;

import com.example.surveyapp.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Long> {
    Admin findByUsernameAndAndPassword(String username ,String password);
}
