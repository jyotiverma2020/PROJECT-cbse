import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

 public class Admin extends HttpServlet
{

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
		  PrintWriter out = res.getWriter();
			res.setContentType("<html><body bgcolor='lavender'>");
		String name=req.getParameter("name1");
		  String id=req.getParameter("id1");
		  
		  String name1="admin";
		  String pass1="admin1";
		try
		{
		out.print("<html><body bgcolor='Lavender' background='images/cbsesymbol.png' width='70%' height='80%'>");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
				Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","jyoti");
				Statement s = c.createStatement();
				if (name1.equalsIgnoreCase(name) && pass1.equalsIgnoreCase(id))
				{
					String  s1="select * from student_result ";
					//out.println(s1);
					ResultSet rs=s.executeQuery(s1);
						out.println("<h2 align='center'><u><b>Welcome to admin login page.</b></u></h2>");
						out.println("Student name   Id  Computer  Math  Hindi   English   Science   ");
					while(rs.next())
					{
						out.print(rs.getString(1));
							out.println("<br>");
							out.print(rs.getString(2));
							out.println("<br>");
							out.print(+rs.getInt(3));
							out.println("<br>");
						  out.print(rs.getInt(4));
						  out.println("<br>");
						  out.print(rs.getInt(5));
						  out.println("<br>");
						  out.print(rs.getInt(6));
						  out.println("<br>");
						  out.print(rs.getInt(7));
					}
				}
				else if(name=="" | id=="" )
				{
					out.println("please fill the correct details.");
				}
				else
				{
					out.println("<br>");
				out.println("<h2 align='center'><b>User InValid..please fill your correct details</h2>");
				RequestDispatcher r=req.getRequestDispatcher("/adminlogin.html");
				r.include(req,res);
				}
		}catch(Exception e)
		{
			out.println(e);
		}     
		out.println("</body></html>");
					


}




}