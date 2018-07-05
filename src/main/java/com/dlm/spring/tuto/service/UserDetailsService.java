package com.dlm.spring.tuto.service;

import java.util.List;

import com.dlm.spring.tuto.model.UserDetails;

public interface UserDetailsService {

    public UserDetails getuserDetails(int id);

    public List<UserDetails> getAllUserDetails();
    
    public void addUser(UserDetails userDetails);
    
    public void deleteUser(UserDetails userDetails);
    
    public void updateUser(UserDetails userDetails);
    

}
