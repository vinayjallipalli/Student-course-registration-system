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
public class Mayregister extends HttpServlet {

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
      
        String b ="";
        int val=0;
        for (int i=1;i<6;i++)
        {
         b =request.getParameter(String.valueOf(i)+"b2");
        if(b!=null)
        {
            val=i;
            break;
        }
        }
        String x="c"+val;
       int no_of_seats= getCourseSeats(x);
       if(no_of_seats!=0)
       {
           bookseat(x,no_of_seats);
           try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
         
            out.println("<body>");
            out.println("<h1>Course Registered!</h1>");
          
            out.println("</body>");
            out.println("</html>");
            
            
        }
       }
       else
       {
           try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
         
            out.println("<body>");
            out.println("<h1>No seats avaialble!</h1>");
          
            out.println("</body>");
            out.println("</html>");
        }
           
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

    private int getCourseSeats(String val) {
    int seats_available;
    
        ApplicationContext applicationContext=
               new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        
        CourseJDBCTemplate cJDBCTemplate= (CourseJDBCTemplate) applicationContext.getBean("CourseJDBCTemplate");        
    
        //get seats
        Course cx=cJDBCTemplate.getCourse(val);
        seats_available=cx.getSeat();
            
        return seats_available;
    }

    private void bookseat(String val,int no_of_seats) {
        
        int book_seat= no_of_seats-1;
        
         ApplicationContext applicationContext=
               new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        
        CourseJDBCTemplate courseJDBCTemplate= (CourseJDBCTemplate) applicationContext.getBean("CourseJDBCTemplate");        
    
        //put decreased seats;
        courseJDBCTemplate.update(val, book_seat);
//        
//         ApplicationContext applicationContexttwo=
//               new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        
        CoursesTakenJDBCTemplate coursetakenJDBCTemplate= (CoursesTakenJDBCTemplate) applicationContext.getBean("CoursesTakenJDBCTemplate");
        coursetakenJDBCTemplate.insert(ShowMenuServlet.username,val);
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
