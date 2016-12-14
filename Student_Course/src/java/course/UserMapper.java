/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Vinay
 */
class UserMapper implements RowMapper<User> {

    public UserMapper() {
    }

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
       User mUser= new User();
       
       mUser.setUsername(rs.getString("username"));
       mUser.setPassword(rs.getString("password"));
       mUser.setDeptid(rs.getString("deptid"));
       mUser.setgpa(rs.getInt("gpa"));
       mUser.setgpa(rs.getInt("sem"));
       mUser.setEmail_id(rs.getString("email_id"));
       mUser.setContact_number(rs.getInt("contact_number"));
       mUser.setCity(rs.getString("city"));
       
       return mUser;    }
    
}
