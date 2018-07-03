package com.dlm.spring.tuto.managerBean;

import java.util.HashMap;
import java.util.Map;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

import org.springframework.dao.DataAccessException;

import com.dlm.spring.tuto.model.UserDetails;
import com.dlm.spring.tuto.service.UserDetailsService;

@ManagedBean(name="userDetailsMBean")
@SessionScoped
public class UserDetailsMBean implements Serializable {

	private static final long serialVersionUID = 1L;

        //inject spring bean via DI
	@ManagedProperty(value="#{userDetailsService}")
	private UserDetailsService userDetailsService;

	private UserDetails userDetails;
	private List<UserDetails> userDetailsList;
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String dob;
	
	
	 public void editUser() {
	        Map<String,Object> options = new HashMap<String, Object>();
	        options.put("resizable", false);
	        options.put("draggable", false);
	        options.put("modal", true);
	        PrimeFaces.current().dialog.openDynamic("editUser", options, null);
    }
	
	public String deleteUser(int id){
		UserDetails userDetails = (UserDetails) userDetailsService.getuserDetails(id);
		getUserDetailsService().deleteUser(userDetails);
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();//invalidate session in order to refresh userDetailsList
		
		return null;
	}
	
	public String addUser(){
		try {
			UserDetails userDetails = new UserDetails();
			userDetails.setFirstName(getFirstName());
			userDetails.setLastName(getLastName());
			userDetails.setEmail(getEmail());
			userDetails.setDob(getDob());
            getUserDetailsService().addUser(userDetails);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("User " + firstName + " " + lastName + " saved"));
            return "listUsers";
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
		 return "listUsers";
	}
	
	public String showListUser(){
		return "listUsers";
	}
	
	public String showUser(){
		return "userDetails";
	}
	
	public UserDetails getUserDetails() {
		if (userDetails == null) {
//			int id = 7;// should come from UI
			userDetails = userDetailsService.getuserDetails(id);
		}
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public List<UserDetails> getUserDetailsList() {
		if (userDetailsList == null) {
			userDetailsList = userDetailsService.getAllUserDetails();
		}
		return userDetailsList;
	}

	public void setUserDetailsList(List<UserDetails> userDetailsList) {
		this.userDetailsList = userDetailsList;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }
	
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

}
