/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

/**
 *
 * @author Vinay
 */
public class Course {
    
    
    String courseid;
    String coursename;
    String deptid;    
    int credits; 
    int sem;
    int seat_left;

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String tname) {
        this.courseid = tname;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String source) {
        this.coursename = source;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String b) {
        this.deptid = b;
    }

  
    public int getCredits() {
        return credits;
    }

    public void setCredits(int a) {
        this.credits = a;
    }
    
    
     public int getPrereq() {
        return sem;
    }

    public void setPrereq(int a) {
        this.sem = a;
    }
    
    
       public int getSeat() {
        return seat_left;
    }

    public void setSeat(int a) {
        this.seat_left = a;
    }
                           
}
