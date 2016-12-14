/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Vinay
 */
public class CourseJDBCTemplate {
private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void update( String courseid,int seats_left ) {

        String SQL = "update course set seats_left=? where courseid=?";
      
      jdbcTemplate.update( SQL,seats_left, courseid);
    //  System.out.println("Created Record Name = " + tno + " password = " + p);
      return;


    }


    public Course getCourse(String e) {
        
        String SQL ="select * from course where courseid =? ";
        
//        jdbcTemplate.update(SQL,tno);
        Course c1= jdbcTemplate.queryForObject(SQL, new Object[]{e},new CourseMapper());
        return c1;    
    }

   
    public List<Course> listCourses() {
        String SQL ="select * from course";
        List<Course> courses= jdbcTemplate.query(SQL,new CourseMapper());
        
        return courses;   
    }


}
