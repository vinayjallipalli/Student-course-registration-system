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
class BTMapper implements RowMapper<CoursesTaken> {

    public BTMapper() {
    }

    @Override
    public CoursesTaken mapRow(ResultSet rs, int i) throws SQLException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   CoursesTaken ct= new CoursesTaken();
       
       ct.setUsername(rs.getString("username"));
       ct.setCourseid(rs.getString("courseid"));
      
       
       return ct;   
    
    
    
    
    }
    
}
