/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chayes.budgeter.resources;

import com.codahale.metrics.annotation.Timed;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Consumes;
import javax.ws.rs.Encoded;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.chayes.budgeter.api.User;
import org.chayes.budgeter.db.UserDao;

/**
 *
 * @author Chris
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {
    private final UserDao userDao;
    
    public UsersResource(UserDao dao) {
        userDao = dao;
    }
    
    @GET
    @Path("/{id}")
    @Timed
    public User getUserById(@PathParam("id") Integer id) {
        User u = userDao.getUserById(id);
        if (u != null) {
            return u;
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
    
    @GET
    @Timed
    public User getUserByEmail(@PathParam("email") @Encoded String email) {
        User u = userDao.getUserByEmail(email);
        if (u != null) {
            return u;
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
    
    @GET
    @Timed
    public List<User> getAll() {
        return userDao.getAll();
    }
    
    @GET
    @Path("/unverified")
    @Timed
    public List<User> getUnverifiedUsers() {
        return userDao.getUnverifiedUsers();
    }
    
    @POST
    @Timed
    public void save(User user) {
        if (user != null && user.isValid()) {
            if (user.getId() != null) {
                userDao.update(user);
            } else {
                userDao.insert(user);
            }
        }
    }
    
    @DELETE
    @Path("/{id}")
    @Timed
    public void deleteUser(@PathParam("id") Integer id) {
        if (userDao.getUserById(id) != null) {
            userDao.deleteById(id);
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
}
