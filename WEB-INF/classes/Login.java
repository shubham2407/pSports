package com.project.Login;

import javax.servlet.ServletException;
import javax.servlet.http.*;  
import javax.servlet.*;
import java.sql.*;  
import java.io.*;  
public class Login extends HttpServlet
{  
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");                 // setting the content type
        PrintWriter pw = res.getWriter();                // get the stream to write the data
        try
        {
            boolean st =false;
            //Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?serverTimezone=UTC", "root", "");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","");
            
            PreparedStatement ps = cn.prepareStatement("select email, password from register where email=? and password=?");
            ps.setString(1, req.getParameter("email"));
            ps.setString(2, req.getParameter("password"));
            ResultSet rs = ps.executeQuery();
            st = rs.next();
            if(st == true)
            {
                pw.println("<script>alert('Login successful!');</script>");
                RequestDispatcher rs1 = req.getRequestDispatcher("brands.html");
                rs1.forward(req, res);
            }
            else
            {
                pw.println("<script>alert('Incorrect email or password!');</script>");
                RequestDispatcher rs1 = req.getRequestDispatcher("registernlogin.html");
                rs1.include(req, res);
            }
        } 
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}  