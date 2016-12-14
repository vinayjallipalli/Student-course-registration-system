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
class CourseMapper implements RowMapper<Course> {

    public CourseMapper() {
    }

    @Override
    public Course mapRow(ResultSet rs, int i) throws SQLException {
        Course ks= new Course();
              
       ks.setCourseid(rs.getString("courseid"));
       ks.setCoursename(rs.getString("coursename"));
       ks.setDeptid(rs.getString("deptid"));       
       ks.setCredits(rs.getInt("credits"));
       ks.setPrereq(rs.getInt("pre_req"));
       ks.setSeat(rs.getInt("seats_left"));
  
       return ks;    
    }
    
}
