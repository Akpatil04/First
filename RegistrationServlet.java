package com.nit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
@WebServlet("/RegistrationServlet")
 
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	 String uid = request.getParameter("userid");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        	System.out.println(fullname);
        	System.out.println(email);
        	System.out.println(phone);
        	System.out.println(password);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl",
                "system",
                "Java2565"
            );

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO registration_details(id,fullname,email,phone,password) VALUES(?,?,?,?,?)"
            );
            ps.setInt(1, Integer.parseInt(uid));
            ps.setString(2, fullname);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, password);

            int executeUpdate = ps.executeUpdate();
            System.out.println("Rows inserted = " + executeUpdate);
            if(executeUpdate>0)
            {
            RequestDispatcher rd=request.getRequestDispatcher("Login.html");
            	rd.forward(request,response);
            }
            else
            {
            	System.err.println("registration failed");
            }	

            con.close();

        } 
         catch (Exception e) {
            e.printStackTrace();
        }
    }
}

