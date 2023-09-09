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
 * Servlet implementation class ViewComplaints
 */
@WebServlet("/ViewComplaints")
public class ViewComplaints extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewComplaints() {
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
		Connection conn=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn=DriverManager.getConnection("jdbc:derby:D:\\Users\\2440223\\MyDB;create=true");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement ps1=conn.prepareStatement("select * from complaints");
			ResultSet r=ps1.executeQuery();
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
			        pw.println("<h4>Welcome,Admin "); pw.println("</h4>");
			    pw.println("</nav>");
			pw.println("<table><tr><th>user</th><th>Complaint</th></tr>");
			while(r.next())
			{
				pw.println("<tr><td>"+r.getString(2)+"</td><td>"+r.getString(3)+"</td>");
				pw.println("<td>");
				pw.println("<form action='UpdateComplaint' method='POST'>");
				pw.println("<textarea name='response'></textarea>");
				pw.println("<input type='submit' class='button2' name='submit' value='Respond "+r.getInt(1)+"'>");
				pw.println("</form>");
				pw.println("</td></tr>");
			}
			pw.println("</table>");
			pw.println("</body>");
			pw.println("</html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
