package com.nit;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{

String username=request.getParameter("username");
String password=request.getParameter("password");

try{

Class.forName("oracle.jdbc.driver.OracleDriver");

Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:orcl",
"system",
"Java2565");

PreparedStatement ps=con.prepareStatement(
"select * from registration_details where fullname=? and password=?");

ps.setString(1,username);
ps.setString(2,password);

ResultSet rs=ps.executeQuery();

if(rs.next())
{

request.setAttribute("id",rs.getInt("id"));
request.setAttribute("name",rs.getString("fullname"));
request.setAttribute("email",rs.getString("email"));
request.setAttribute("phone",rs.getString("phone"));

RequestDispatcher rd=request.getRequestDispatcher("User_Info.jsp");
rd.forward(request,response);

}
else
{
response.sendRedirect("Login.html?error=1");
}

}
catch(Exception e)
{
e.printStackTrace();
}

}
}
