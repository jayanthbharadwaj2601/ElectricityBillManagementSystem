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
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		String g=request.getParameter("username");
		String h=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		Connection conn=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn=DriverManager.getConnection("jdbc:derby:D:\\Users\\2440223\\MyDB;create=true");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(g.equals("Admin@123") && h.equals("HelloAdmin"))
		{
			PreparedStatement pst=null;
			try {
				pst=conn.prepareStatement("select * from customer");
				ResultSet r1=pst.executeQuery();
//				pw.println("<h1>assign bills</h1>");
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

				        pw.println("<h4>Welcome, Admin"); pw.println("</h4>");
				    pw.println("</nav>");
				pw.println("<form action='AddBill' method='POST'>");
				pw.println("<select name='username'><option value='#'>Select Customer</option>");
				while(r1.next())
				{
					pw.println("<option>"+r1.getString(4)+"</option>");
				}
				pw.println("</select>");
				pw.println("<input type='number' name='energyconsumption' placeholder='Energy in kilowatt'>");
				pw.println("<input type='number' name='bill' placeholder='Amount'>");
				pw.println("<input type='submit' class='button2' name='submit' value='AssignBill'>");
				pw.println("</form>");
				pw.println("<form action='ViewComplaints' method='POST'>");
				pw.println("<input type='submit' name='submit' class='button3' value='viewcomplaints'>");
				pw.println("</form>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				PreparedStatement ps10=conn.prepareStatement("select * from bills");
				ResultSet r10=ps10.executeQuery();
				pw.println("<table class='table1'><thead class='thead1'><th class='th1'>Customer</th><th class='th1'>Energy</th><th class='th1'>Bill</th><th class='th1'>Status</th></thead>");
				while(r10.next())
				{
					pw.println("<tr><td class='td1'>"+r10.getString(2)+"</td><td class='td1'>"+r10.getInt(3)+"</td><td class='td1'>"+r10.getInt(4)+"</td><td class='td1'>"+r10.getString(5)+"</td></tr>");
				}
				pw.println("</table>");
				pw.println("</body>");
				pw.println("</html>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			pw.println("Invalid Credentials!");
		}
	}

}
