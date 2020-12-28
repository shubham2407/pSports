package com.project.Register;

import javax.servlet.ServletException;
import javax.servlet.http.*;  
import javax.servlet.*;  
import java.sql.*;
import java.io.*;  
public class Register extends HttpServlet
{  
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");                 // setting the content type
        PrintWriter pw = res.getWriter();                // get the stream to write the data
        try
        {
            pw.println(req.getParameter("name"));
            pw.println(req.getParameter("email"));
            pw.println(req.getParameter("numb"));
            pw.println(req.getParameter("password"));
            //Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?serverTimezone=UTC", "root", "");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","");

            PreparedStatement st = cn.prepareStatement("insert into register values(?, ?, ?, ?)");
            st.setString(1, req.getParameter("name"));
            st.setString(2, req.getParameter("email"));
            st.setLong(3, Long.valueOf(req.getParameter("numb")));
            st.setString(4, req.getParameter("password"));
		
            st.executeUpdate();
            pw.println("<script>alert('Registration Successfull!');</script>");                                                            
        } 
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}  