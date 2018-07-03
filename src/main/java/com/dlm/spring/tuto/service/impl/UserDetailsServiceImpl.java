package com.dlm.spring.tuto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlm.spring.tuto.dao.UserDetailsDao;
import com.dlm.spring.tuto.model.UserDetails;
import com.dlm.spring.tuto.service.UserDetailsService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    public UserDetails getuserDetails(int id) {
        return userDetailsDao.getuserDetails(id);
    }

    @Override
    public List<UserDetails> getAllUserDetails() {
        return userDetailsDao.getAllUserDetails();
    }

    public UserDetailsDao getUserDetailsDao() {
        return userDetailsDao;
    }

	@Transactional(readOnly = false)
	@Override
	public void addUser(UserDetails userDetails) {
		
		getUserDetailsDao().addUser(userDetails);
		
	}

	@Transactional
	@Override
	public void deleteUser(UserDetails userDetails) {
		getUserDetailsDao().deleteUser(userDetails);
		
	}

}
