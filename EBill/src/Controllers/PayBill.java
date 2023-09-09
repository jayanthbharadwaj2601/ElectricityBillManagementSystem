package Controllers;

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
 * Servlet implementation class PayBill
 */
@WebServlet("/PayBill")
public class PayBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayBill() {
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
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String[] g=request.getParameter("submit").split(" ");
		String username=g[2];
//		pw.println(g[1]);
//		for(int i=0;i<g.length;i++)
//		{
//			pw.println(g[i]+" "+i);
//		}
		Connection conn=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn=DriverManager.getConnection("jdbc:derby:D:\\Users\\2440223\\MyDB;create=true");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement ps1=conn.prepareStatement("select * from bills");
			ResultSet bills=ps1.executeQuery();
//			pw.println("<table>");
//			pw.println("<tr><th>Energy in kilowatts</th><th>Bill</th><th>Status</th></tr>");
//			pw.println(username);
//			while(bills.next())
//			{
////				pw.println(username+bills.getString(2).equals(username)+bills.getString(2));
//				if(bills.getString(2).equals(username) && bills.getString(5).equals("Not Paid"))
//				{
////					pw.println(username+bills.getString(2).equals(username)+bills.getString(2));
//					pw.println("<tr><td>"+bills.getInt(3)+"</td><td>"+bills.getInt(4)+"</td><td>"+bills.getString(5)+"</td>");
//				pw.println("<td>");
//				pw.println("<form action='PaidBill' method='POST'>");
//				pw.println("<input type='submit' name='submit' value='pay "+bills.getInt(1)+"'>");
//				pw.println("</form>");
//				pw.println("</td></tr>");
//				}
//			}
//			pw.println("</table>");
//			
			pw.println("<!DOCTYPE html>");
			pw.println("<html lang='en'>");
			pw.println("<head>");
			    pw.println("<metform charset='UTF-8'>");
			    pw.println("<metform name='viewport' content='width=device-width, initial-scale=1.0'>");
			    pw.println("<title>Dashboard");pw.println("</title>");
			    pw.println("<link href='paybill.css' rel='stylesheet'/>");

			pw.println("</head>");
			pw.println("<body>");
			    pw.println("<nav>");
			        pw.println("<img src='solara.gif' class='solaraLogo'>");
//			        pw.println("<!-- pw.println("<div class='tags'>");
//			            pw.println("<form action='dashboard.html'>");pw.println("<h4>");Dashboardpw.println("</h3>"); pw.println("</form>");
//			            pw.println("<form action='complaint.html'>");pw.println("<h4>");Raise Complaintpw.println("</h3>"); pw.println("</form>");
//			            pw.println("<form action='complaintStatus.html'>");pw.println("<h4>");Complaint Statuspw.println("</h4>");pw.println("</form>");
//			        pw.println("</div>"); -->");
			        pw.println("<h4>Welcome, "+username); pw.println("</h4>");
			    pw.println("</nav>");
			    pw.println("<div class='main'>");
			        pw.println("<h2>Your Bills");pw.println("</h2>");
			        pw.println("<table>");
					pw.println("<thead><th>Energy in kilowatts</th><th>Bill</th><th>Status</th></thead>");
					pw.println(username);
					while(bills.next())
					{
//						pw.println(username+bills.getString(2).equals(username)+bills.getString(2));
						if(bills.getString(2).equals(username) && bills.getString(5).equals("Not Paid"))
						{
//							pw.println(username+bills.getString(2).equals(username)+bills.getString(2));
							pw.println("<tr><td>"+bills.getInt(3)+"</td><td>"+bills.getInt(4)+"</td><td>"+bills.getString(5)+"</td>");
						pw.println("<td>");
						pw.println("<form action='PaidBill' method='POST'>");
						pw.println("<input type='submit' name='submit' class='button' value='pay "+bills.getInt(1)+"'>");
						pw.println("</form>");
						pw.println("</td></tr>");
						}
					}
					pw.println("</table>");


			        pw.println("</table>");
//			        pw.println("<form action='paymentscreen.html' class='rightFloater'>");
//			            pw.println("<input type='submit' name='submit' value='paybill'>");
//			        pw.println("</form>");

			    pw.println("</div>");
			    
			pw.println("</body>");
			pw.println("</html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
