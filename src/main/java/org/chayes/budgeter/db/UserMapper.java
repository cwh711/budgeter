/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chayes.budgeter.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.chayes.budgeter.api.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Chris
 */
public class UserMapper implements ResultSetMapper<User> {
    
    @Override
    public User map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new User(r.getInt("user_id"),
                        r.getString("user_email"),
                        r.getString("user_firstname"),
                        r.getString("user_lastname"),
                        r.getBoolean("user_email_verified"),
                        r.getTimestamp("user_email_verified_timestamp"),
                        r.getTimestamp("user_last_updated"),
                        r.getTimestamp("user_created"));
    }
    
}
