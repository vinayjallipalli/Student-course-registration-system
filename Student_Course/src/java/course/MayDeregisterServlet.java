/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import java.io.IOException;
import java.io.PrintWriter;
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
public class MayDeregisterServlet extends HttpServlet {

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
        String b =1+"b2";
        int train_no=0;
        for (int i=1;i<6;i++)
        {
         b =request.getParameter(String.valueOf(i)+"b2");
        if(b!=null)
        {
            train_no=i;
            break;
        }
        }
        String x="c"+train_no;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MayderegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            updateTrainTickets(x);
            updateUserTickets(x);
            out.println("<h1>Tickets canceled</h1>");
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

    private void updateTrainTickets(String x) {
        
        ApplicationContext applicationContext=
               new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        
        CourseJDBCTemplate courseJDBCTemplate= (CourseJDBCTemplate) applicationContext.getBean("TrainJDBCTemplate");
        
        Course cwe = courseJDBCTemplate.getCourse(x);
        
        int number= cwe.getSeat()+1;
        
        courseJDBCTemplate.update(x, number);
        
        
        
        
    }

    private void updateUserTickets(String q1) {
        
        ApplicationContext applicationContext=
               new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        
        CoursesTakenJDBCTemplate rJDBCTemplate = 
                (CoursesTakenJDBCTemplate) applicationContext.getBean("CoursesTakenJDBCTemplate");
        
        rJDBCTemplate.delete(ShowMenuServlet.username, q1);
        
        
        
    }

}
