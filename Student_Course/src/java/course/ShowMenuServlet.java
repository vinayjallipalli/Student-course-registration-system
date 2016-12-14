/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Aman
 */
public class ShowMenuServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    public static String username;
    public static String password; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowMenu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowMenu at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
    
    PrintWriter out= response.getWriter();
        String uname=request.getParameter("username");
        String pwd= request.getParameter("password");
        
        boolean isCredentialsValid=false;
        
        
        ApplicationContext applicationContext=
               new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        
        UserJDBCTemplate userJDBCTemplate= (UserJDBCTemplate) applicationContext.getBean("UserJDBCTemplate");
        
        
        
        List <User> users= userJDBCTemplate.listUsers();
        for (User info:users)
        {
            //just for testing
            System.out.println(" Username : "+info.getUsername() + " password : "+info.getPassword());
        
            if(uname.equals(info.getUsername())&&pwd.equals(info.getPassword()))
            {
                isCredentialsValid=true;
                username= info.getUsername();
                password=info.getPassword();
                break;
            }
        
            
        
        }
        if(isCredentialsValid)
        {
            String s[]=new String [10];            
            Connection conn=null; 
            try
            {            
                
            Class.forName("com.mysql.jdbc.Driver");    
            conn=DriverManager.getConnection("jdbc:mysql://localhost/student","root","2938");                       
            
            PreparedStatement pst=null;
            ResultSet rs=null;
            String Sql= "select * from news";            
            pst=conn.prepareStatement(Sql);                                    
            rs=pst.executeQuery(); 
            int i=1;
            s[0]="!.";
           while(rs.next())
           {
            s[i]=rs.getString(2); 
            i++;
           }
            }
            catch(ClassNotFoundException | SQLException e)
            {                
                System.out.println(e);
            }
            Cookie ck=new Cookie("w",s[0]+s[1]+s[2]+s[3]+s[4]+s[5]);//creating cookie object  
            response.addCookie(ck);//adding cookie in the response  
            
            
             //out.print("<h1> Hello," +s[0]+" ! </h1>");
             String contextPath = request.getContextPath();
             System.out.println("path "+ contextPath);             
             response.sendRedirect(contextPath+"/testjsp.htm");
             //showDetails(uname,out);             
           
        }
       else
        {
            out.print("<h1> Login Unsuccessful! </h1>");
        }
        
        //String contextPath = request.getContextPath();
        //System.out.println("path "+ contextPath);
       
        
        //response.sendRedirect(contextPath+"/testjsp.htm");
    
    
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
