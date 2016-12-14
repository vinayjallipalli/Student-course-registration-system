/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Vinay
 */
public class UserJDBCTemplate {

    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void create(String username, String password,String deptid,int gpa,int sem, String email_id, int contact_number, String city) {

        String SQL = "insert into users (username, password,deptid,gpa,sem,email_id,contact_number,city) values (?,?,?,?,?,?,?,?)";
      
      jdbcTemplate.update( SQL, username, password,deptid,gpa,sem,email_id,contact_number,city);
      System.out.println("Created Record Name = " + username + " password = " + password);
      return;


    }


    public User getUser(String username, String password) {
        
        String SQL ="select * from users (username,password,deptid,gpa,sem,email_id,contact_number,city) where username =? and password=?";
        
       // jdbcTemplate.update(SQL,username,password);
        User user= jdbcTemplate.queryForObject(SQL, new Object[]{username,password},new UserMapper());
        return user;    
    }

   
    public List<User> listUsers() {
        String SQL ="select * from users";
        List<User> users= jdbcTemplate.query(SQL,new UserMapper());
        
        return users;    }

//    @Override
//    public void delete(String username, String password) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
    public void update(String username, String password,String deptid,int gpa,int sem,String email_id,int contact_number, String city) {

         String SQL = "update users set password=?,deptid=?,gpa=?,sem=?,email_id=?,contact_number=?,city=? where username = ?";
      jdbcTemplate.update(SQL, password,deptid,gpa,sem,email_id,contact_number,city,username);
      System.out.println("Updated Record with username = " + username );


    }
    
}
