package com.example.school.management.system.security;

import com.example.school.management.system.model.Account;
import com.example.school.management.system.service.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomAccountDetailsService implements UserDetailsService {


    @Autowired
    private AccountRepo accountRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Account account = accountRepo.findByUsername(username);
       if (account !=null){
           return new AccountServiceDetails(account);
       }else {
           throw new UsernameNotFoundException("User "+ username + " not found in the database");
       }
    }
}
