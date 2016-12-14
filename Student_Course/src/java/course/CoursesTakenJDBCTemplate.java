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
public class CoursesTakenJDBCTemplate {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
     public void select( String username ,int a ) {

        String SQL = "select * from course_taken(username,courseid) values (?,?)";
      
      jdbcTemplate.update( SQL,username, a);
      //System.out.println("Created Record Name = " + username + " tno = " + tno);
      return;


    }
     
     public void insert(String username , String a)
     {
         String SQL = "insert into courses_taken(username,courseid) values (?,?)";
         jdbcTemplate.update(SQL,username,a);
          //System.out.println("Created Record Name = " + username + " tno = " + a);
         return;
         
     }
    
    
//    public void update( int tno,int ntickets ) {
//
//        String SQL = "update trains set ntickets=? where tno=?";
//      
//      jdbcTemplate.update( SQL,ntickets, tno);
//    //  System.out.println("Created Record Name = " + tno + " password = " + p);
//      return;
//
//
//    }


    public CoursesTaken getBookedTickets(String username) {
        
        String SQL ="select * from course_taken where username =? ";
        
//        jdbcTemplate.update(SQL,tno);
        CoursesTaken ct= jdbcTemplate.queryForObject(SQL, new Object[]{username},new BTMapper());
        return ct;    
    }

   
    public List<CoursesTaken> listBT() {
        String SQL ="select * from course_taken";
        List<CoursesTaken> courses= jdbcTemplate.query(SQL,new BTMapper());
        
        return courses;   
    }
     public void delete(String username, String a) {

     
     String SQL = "delete from course_taken where username = ? and courseid=?";
      jdbcTemplate.update(SQL,username,a);
      System.out.println("Deleted Record with username= " + username+" tno ="+a );
      return;
     
     
     }
}
