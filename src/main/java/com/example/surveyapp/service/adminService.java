package com.example.surveyapp.service;

import com.example.surveyapp.Models.Admin;
import com.example.surveyapp.repositories.AdminRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class adminService implements UserDetailsService {

    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;
    public adminService(AdminRepo adminRepo, PasswordEncoder passwordEncoder){
        this.adminRepo = adminRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin verifiedAdmin(String username,String password){
        return adminRepo.findByUsernameAndAndPassword(username,passwordEncoder.encode(password));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return adminRepo.findByUsername(s);
    }
}
