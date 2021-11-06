package com.example.surveyapp.securityAdmin;

import com.example.surveyapp.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("adminSecurityUser")
public class AdminDetailsService implements UserDetailsService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminDetailsService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            return AdminSecurityUser.fromUser(adminRepo.findByUsername(username));
        }catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("admis is not found!");
        }
    }
}
