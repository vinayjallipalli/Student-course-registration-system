/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Vinay
 */
public class DeregisterCourseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          
        
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>De registration</title>");            
            out.println("</head>");
            out.println("<body bgcolor=#ecf0f1>");
            
            out.println("<h1 align=center >Courses Registered</h1>");
             ApplicationContext applicationContext=
               new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        
        CoursesTakenJDBCTemplate crJDBCTemplate= (CoursesTakenJDBCTemplate) applicationContext.getBean("CoursesTakenJDBCTemplate");
        
        
        
        List <CoursesTaken> sw= crJDBCTemplate.listBT();
        
        CourseJDBCTemplate courseJDBCTemplate= (CourseJDBCTemplate) applicationContext.getBean("CourseJDBCTemplate");
        List<Course>courses=courseJDBCTemplate.listCourses();
        out.print("<table border =1px align=center> <tr><th> Username</th>"
                 + "<th>courseid </th>");
        
        for(Course t : courses)
        {
            for(CoursesTaken bt: sw)
            {
            
                if(t.getCourseid()==bt.getCourseid())
                {
                    out.print("<tr> <td>"+t.getCourseid()+ "</td><td>"+"<td> <form method=post action=MayDeregisterServlet><input type=submit name="+t.getCourseid()+"b2 value=De-register></input> </form></td></tr>");
                    
                }                                                            
            }            
        }
         
         int courseid=1;
        for (Course t:courses)
        {
            
           
        courseid++;
            
        
        }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
