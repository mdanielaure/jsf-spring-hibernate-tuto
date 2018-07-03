package com.dlm.spring.tuto.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dlm.spring.tuto.dao.UserDetailsDao;
import com.dlm.spring.tuto.model.UserDetails;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public UserDetails getuserDetails(int id) {
        UserDetails userDetails = (UserDetails) sessionFactory.getCurrentSession().get(UserDetails.class, id);
        return userDetails;
    }

    @Transactional
    @Override
    public List<UserDetails> getAllUserDetails() {

        @SuppressWarnings("unchecked")
        List<UserDetails> userDetails = (List<UserDetails>) sessionFactory.getCurrentSession()
                .createCriteria(UserDetails.class).list();
        
        //or below query
        
        /*
         * @SuppressWarnings("unchecked") List<UserDetails> userDetails =
         * (List<UserDetails>)sessionFactory.getCurrentSession().createQuery(
         * "from UserDetails").list();
         */
        
        return userDetails;
    }
    
    @Transactional
    @Override
    public void addUser(UserDetails userDetails) {
        getSessionFactory().getCurrentSession().save(userDetails);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    @Transactional
	@Override
	public void deleteUser(UserDetails userDetails) {
		
		getSessionFactory().getCurrentSession().delete(userDetails);
	}

}
