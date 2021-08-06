import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class LoginServlet extends HttpServlet
{
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
		  PrintWriter out = res.getWriter();
		res.setContentType("<html><body>");
		String name=req.getParameter("name");
		  String id=req.getParameter("id");
		try
		{
					out.print("<html><body bgcolor='Lavender' background='images/book2.jpg' width='70%' height='80%'>");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
				Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","jyoti");
				Statement s = c.createStatement();
				String  s1="select * from student_result  where   stdname='"+name+"' and stdid='"+id+"'";
				//out.println(s1);
				ResultSet rs=s.executeQuery(s1);//query execute in database
				if(rs.next())
				{
					out.print("<br><div align='center'>");
					out.print("<h1 align='center'><i><font face='palatino' color='purple'<u>"+name+" marksheet.. </u></i></font></h1>");
						out.println("<h2 align='center'><i>Keep your dreams alive. </i></h2>");//motivation quote
	out.println("<h2 align='center'><i>Understand to achieve anything requires faith and belief in yourself, vision, hard work, determination, and dedication. </i></h2>");
						out.println("<h2 align='center'><i>Remember all things are possible for those who believe. </i></h2>");

							out.print("<table border='5' width='50%' bgcolor='white' cellpadding='5' cellspacing='3'>");//table of result
							out.println("<tr><th>subject</th><th>marks</th></tr>");
						  out.println("<tr><td>computer </td><td>"+rs.getInt(3)+"</td></tr>");
							out.println("<br>");
						  out.println("<tr><td>math</td><td>"+rs.getInt(4)+"</td></tr>");
						  out.println("<br>");
						  out.println("<tr><td>hindi</td><td>"+rs.getInt(5)+"</td></tr>");
						  out.println("<br>");
						  out.println("<tr><td>English</td><td>"+rs.getInt(6)+"</td></tr>");
						  out.println("<br>");
						  out.println("<tr><td>science</td><td>"+rs.getInt(7)+"</td></tr>");
						 	out.println("</table>");
						  int total=rs.getInt(3)+rs.getInt(4)+rs.getInt(5)+rs.getInt(6)+rs.getInt(7);
						  out.println("<h2>Overall Marks Scored   = "+total+"/500</h2>");
						//out.print(total);
						if(total<=500 && total>=450)
							out.println("<h2> well done!! you got <b>A</b> grade</h2>");
						else if(total<450 && total >=400)
							out.println("<h2>  good job!! you got <b>B</b> grade</h2>");
						else if(total<400 && total >=350)
							out.println("<h2>  Can do better!! you got <b>C</b> grade</h2>");
						else if(total<350 && total >=300)
							out.println("<h2>  can do more better!! you got <b>D</b> grade</h2>");
						else
							out.println("<h2> Need to improve!! you got <b> F</b> grade</h2>");
				}
				else if(name== "" || id ==null )
				{
					out.println("<h2 align='center'><strong>please login First</h2></strong>");
					RequestDispatcher rd=req.getRequestDispatcher("/login.html");
					rd.include(req,res);
					}
				else
				{
					out.println("<br>");
				out.println("User InValid..please fill your correct details");
				RequestDispatcher d=req.getRequestDispatcher("/login.html");
				d.include(req,res);
				}
		}catch(Exception e)
		{
			out.println(e);
		}     
		out.println("<h1><font face='arial' color='purple' Thank you!</font></h1></div> ");
		out.println("</body></html>");
					
}

}






