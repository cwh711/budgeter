/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chayes.budgeter.api;

import java.sql.Timestamp;

/**
 *
 * @author Chris
 */
public class User {
    private Integer id;
    private String email;
    private String firstname;
    private String lastname;
    private Boolean emailVerified;
    private final Timestamp emailVerifiedTimestamp;
    private final Timestamp lastUpdated;
    private final Timestamp created;
    
    public User(Integer userId, String userEmail, String userFirstname, String userLastname, Boolean userEmailVerified,
            Timestamp userEmailVerifiedTimestamp, Timestamp userLastUpdated, Timestamp userCreated) {
        id = userId;
        email = userEmail;
        firstname = userFirstname;
        lastname = userLastname;
        emailVerified = userEmailVerified;
        emailVerifiedTimestamp = userEmailVerifiedTimestamp;
        lastUpdated = userLastUpdated;
        created = userCreated;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer userId) {
        id = userId;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String userEmail) {
        email = userEmail;
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public void setFirstname(String userFirstname){
        firstname = userFirstname;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public void setLastname(String userLastname) {
        lastname = userLastname;
    }
    
    public String getFullname() {
        return firstname + " " + lastname;
    }
    
    public Boolean getEmailVerified() {
        return emailVerified;
    }
    
    public void setEmailVerified(Boolean userEmailVerified) {
        emailVerified = userEmailVerified;
    }
    
    /*Timestamp fields don't have setters, because DB implementation handles
      setting timestamps.*/
    
    public Timestamp getEmailVerifiedTimestamp() {
        return emailVerifiedTimestamp;
    }
    
    public Timestamp getLastUpdated() {
        return lastUpdated;
    }
    
    public Timestamp getCreated() {
        return created;
    }
    
    public boolean isValid() {
        //TODO add validation
        return true;
    }
}
