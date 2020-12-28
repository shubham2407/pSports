package com.project.Contact;

import javax.servlet.ServletException;
import javax.servlet.http.*;  
import javax.servlet.*;  
import java.sql.*;
import java.io.*;  
public class Contact extends HttpServlet
{  
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");                 // setting the content type
        PrintWriter pw = res.getWriter();                // get the stream to write the data
        try
        {
            //Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?serverTimezone=UTC", "root", "");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","");

            PreparedStatement ps = cn.prepareStatement("insert into contact values(?, ?, ?)");
            ps.setString(1, req.getParameter("name"));
            ps.setString(2, req.getParameter("email"));
            ps.setString(3, req.getParameter("message"));
        
            ps.executeUpdate();
            pw.println("<script>alert('Your response has been submitted!');</script>");
        } 
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}  