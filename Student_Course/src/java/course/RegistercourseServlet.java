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
import static course.ShowMenuServlet.password;
import static course.ShowMenuServlet.username;

/**
 *
 * @author Vinay
 */
public class RegistercourseServlet extends HttpServlet {

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
            
          
        
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration!</title>");            
            out.println("</head>");
            out.println("<body bgcolor=#ecf0f1>");
            
            out.println("<h1 align=center>COURSES AVAILABLE  </h1><br>");
             ApplicationContext applicationContext=
               new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        
        CourseJDBCTemplate courseJDBCTemplate= (CourseJDBCTemplate) applicationContext.getBean("CourseJDBCTemplate");
        
        
        
        List <Course> Courses= courseJDBCTemplate.listCourses();
         out.print("<table border =1px  align=center> <tr><th> Courseid </th>"
                 + "<th>Course Name </th>"
                 + "<th>Dept id</th>"
                 + "<th>Credits </th>"
                 + "<th>Pre-requisites</th>"
                 + "<th>Seats left </th>");
         
        int Course_no=1;
        for (Course t:Courses)
        {
            out.print("<tr> <td>"+t.getCourseid()+ "</td><td>"+t.getCoursename()+"</td><td> "+ t.getDeptid()+"</td>"
                    + "<td> "+ t.getCredits()+"</td><td> "+ t.getPrereq()+"</td><td> "+ t.getSeat()+"</td>"                    
                    + "<td> <form method=post action=Mayregister>  " +
"        <input type=submit name="+Course_no+"b2 value=Register></input>" +
"        </form></td></tr>");
           
        Course_no++;
            
        
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
        //processRequest(request, response);
        
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowMenu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Username " + ShowMenuServlet.username+"passowrd"+ ShowMenuServlet.password+ "</h1>");
            out.println("</body>");
            out.println("</html>");
    
    
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
