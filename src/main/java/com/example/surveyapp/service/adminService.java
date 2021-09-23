package com.example.surveyapp.service;

import com.example.surveyapp.Models.Admin;
import com.example.surveyapp.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Service
public class adminService {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    passEncode passEncode;

    public Admin getAdmin(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String hashedPassword = passEncode.hashedPassword(password);
        return adminRepo.findByUsernameAndAndPassword(username, hashedPassword);
    }
}
