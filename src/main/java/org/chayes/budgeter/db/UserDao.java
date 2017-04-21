/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chayes.budgeter.db;

import java.util.List;
import org.chayes.budgeter.api.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 *
 * @author Chris
 */
@RegisterMapper(UserMapper.class)
public interface UserDao {
    
    final String USER_TABLE = "budgeter_user";
    
    @SqlQuery("SELECT * FROM "+ USER_TABLE +" WHERE user_id = :id")
    User getUserById(@Bind("id") int id);
    
    @SqlQuery("SELECT user_email FROM "+ USER_TABLE +" WHERE NOT user_email_verified")
    List<String> getUnverifiedEmails();
    
    @SqlQuery("SELECT * FROM "+ USER_TABLE +" WHERE NOT user_email_verified")
    List<User> getUnverifiedUsers();
    
    @SqlQuery("SELECT * FROM "+ USER_TABLE +" WHERE user_email = :email")
    User getUserByEmail(@Bind("email") String email);
    
    @SqlQuery("SELECT * FROM "+ USER_TABLE)
    List<User> getAll();
    
    @SqlQuery("INSERT INTO "+ USER_TABLE +" (user_email, user_firstname, user_lastname) VALUES (:email, :firstname, :lastname)")
    User insert(@BindBean User user);
    
    @SqlQuery("UPDATE "+ USER_TABLE +" SET user_email=:p.email, user_firstname=:p.firstname, user_lastname=:p.lastname WHERE user_id=:p.id")
    User update(@BindBean("p") User user);
    
    @SqlQuery("DELETE FROM "+ USER_TABLE +" WHERE user_id=:id")
    void deleteById(@BindBean int id);
    
    @SqlQuery("DELETE FROM "+ USER_TABLE +" WHERE user_email=:email")
    void deleteByEmail(@BindBean String email);
}
