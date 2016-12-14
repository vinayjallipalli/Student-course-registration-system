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
public interface UserDAO {
    
    
    public void setJDBCTemplate( JdbcTemplate jdbcTemplate);
    public void create(String username, String password,String deptid,int gpa,int sem, String email_id, int contact_number,String city);
    public User getUser(String username,String password);
    public List<User> listUsers();
   // public void delete(String username, String password);
   // public void update(String username,String password,String email_id, int contact_number,String city);
    
}
