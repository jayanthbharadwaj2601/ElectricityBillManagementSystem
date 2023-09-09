package Controllers;
import Models.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("UserName");
		String password=request.getParameter("Password");
		Connection conn=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn=DriverManager.getConnection("jdbc:derby:D:\\Users\\2440223\\MyDB;create=true");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String h="select * from customer";
		PrintWriter pw=response.getWriter();
		int c=0;
		try {
			PreparedStatement r=conn.prepareStatement(h);
			ResultSet s1=r.executeQuery();
			while(s1.next())
			{
//				pw.println(s1.getString(1)+" "+s1.getString(2)+" "+s1.getString(3)+" "+s1.getString(4)+" "+s1.getString(5)+" "+username+" "+password);
				if(s1.getString(4).equals(username) && s1.getString(5).equals(password))
				{
					c+=1;
					break;
				}
			}
			
			if(c==0)
			{
				pw.println("<h1> Invalid username/Password!</h1>");
			}
			else
			{
//				pw.println("<div class='main'>");
//				pw.println("<form action='PayBill' method='POST'>");
//				pw.println("<input type='submit' name='submit' value='PayBill  "+username+"'>");
//				pw.println("</form>");
//				pw.println("<form action='AddComplaint' method='POST'>");
//				pw.println("<input type='submit' name='submit' value='AddComplaint "+username+"'>");
//				pw.println("</form>");
//				pw.println("<form action='Complaintstatus' method='POST'>");
//				pw.println("<input type='submit' name='submit' value='ComplaintStatus "+username+"'>");
//				pw.println("</form>");
//				pw.println("</div>");
//				Actual html
				pw.println("<!DOCTYPE html>");
				pw.println("<html lang='en'>");
				pw.println("<head>");
				    pw.println("<meta charset='UTF-8'>");
				    pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
				    pw.println("<title>Dashboard");pw.println("</title>");
				    pw.println("<link href='dashboard.css' rel='stylesheet'/>");

				pw.println("</head>");
				pw.println("<body>");
				    pw.println("<nav>");
				        pw.println("<img src='solara.gif' class='solaraLogo'>");

				        pw.println("<h4>Welcome, "+username); pw.println("</h4>");
				    pw.println("</nav>");
				    pw.println("<div class='main'>");
				        pw.println("<form action='PayBill' method='POST'>");
				            pw.println("<div class='option'>");
				                pw.println("<img src='bill.png'>");
				                pw.println("<input type='submit' name='submit' class='button' value='PayBill  "+username+"'>");
				            pw.println("</div>");  
				        pw.println("</form>");
				        pw.println("<form action='AddComplaint' method='POST'>");
				            pw.println("<div class='option'>");
				                pw.println("<img src='complaint.png'>");
				                pw.println("<input type='submit' name='submit' class='button2' value='AddComplaint "+username+"'>");
				            pw.println("</div>");  
				        pw.println("</form>");
				        pw.println("<form action='Complaintstatus' method='POST'>");
				            pw.println("<div class='option'>");
				                pw.println("<img src='compStatus.png'>");
				                pw.println("<input type='submit' name='submit' class='button3' value='ComplaintStatus "+username+"'>");
				            pw.println("</div>");  
				        pw.println("</form>");

				    pw.println("</div>");
				    
				pw.println("</body>");
				pw.println("</html>");
//				!Actual html
				PreparedStatement ps1=conn.prepareStatement("select * from bills");
				ResultSet bills=ps1.executeQuery();
				pw.println("<table class='table1'>");
				pw.println("<thead class='thead1'><th class='th1'>Energy in kilowatts</th><th class='th1'>Bill</th><th class='th1'>Status</th></thead>");
				while(bills.next())
				{
					if(bills.getString(2).equals(username))
					pw.println("<tr><td class='td1'>"+bills.getInt(3)+"</td><td class='td1'>"+bills.getInt(4)+"</td><td class='td1'>"+bills.getString(5)+"</td></tr>");
				}
				pw.println("</table>");
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
