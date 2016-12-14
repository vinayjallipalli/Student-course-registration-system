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

/**
 *
 * @author Vinay
 */
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Registration Page</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<TABLE align=center border=1>");
            out.println("<caption>REGISTRATION</caption>");
            out.println("<form action=UserRegisteredServlet method=post>");                                    
            out.println("<tr><td>Username:</td> <td><input type=\"text\" name=\"username\"></td>");
            out.println("<tr><td>Password: </td> <td><input type=\"password\" name=\"password\"></td>");
            out.println("<tr><td>deptid  : </td> <td><input type=\"text\" name=\"dept\"></td>");
            out.println("<tr><td>gpa     : </td> <td><input type=\"number\" name=\"gpa\"></td>");
            out.println("<tr><td>sem     : </td> <td><input type=\"number\" name=\"sem\"></td>");
            out.println("<tr><td>Email id: </td> <td><input type=email name=email_id></td>");
            out.println("<tr><td>Contact : </td> <td><input type=text name=contact_number></td>");
            out.println("<tr><td>City    : </td> <td><input type=text name=city></td>");
            out.println("<tr><td><input type=submit value=Register><td></tr>");
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
