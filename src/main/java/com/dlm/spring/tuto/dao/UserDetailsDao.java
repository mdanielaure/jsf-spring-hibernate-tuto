package com.dlm.spring.tuto.dao;

import java.util.List;

import com.dlm.spring.tuto.model.UserDetails;

public interface UserDetailsDao {
	
	public UserDetails getuserDetails(int id);

    public List<UserDetails> getAllUserDetails();
    
    public void addUser(UserDetails userDetails);
    
    public void deleteUser(UserDetails userDetails);

}
