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
 * Servlet implementation class Complaintstatus
 */
@WebServlet("/Complaintstatus")
public class Complaintstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Complaintstatus() {
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
		Connection conn=null;
		PrintWriter pw=response.getWriter();
		String [] g=request.getParameter("submit").split(" ");
		String username=g[1];
//		for(int i=0;i<g.length;i++)
//			pw.println(g[i]+" "+i);
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn=DriverManager.getConnection("jdbc:derby:D:\\Users\\2440223\\MyDB;create=true");
			PreparedStatement ps1=conn.prepareStatement("select * from complaints");
			ResultSet r=ps1.executeQuery();
			pw.println("<!DOCTYPE html>");
			pw.println("<html lang='en'>");
			pw.println("<head>");
			    pw.println("<meta charset='UTF-8'>");
			    pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
			    pw.println("<title>Dashboard");pw.println("</title>");
			    pw.println("<link href='paybill.css' rel='stylesheet'/>");

			pw.println("</head>");
			pw.println("<body>");
			 pw.println("<nav>");
		        pw.println("<img src='solara.gif' class='solaraLogo'>");
		        pw.println("<h4>Welcome, "+username); pw.println("</h4>");
		    pw.println("</nav>");
			pw.println("<table><thead><th>Complaint</th><th>Response</th></thead>");
			while(r.next())
			{
				if(r.getString(2).equals(username))
				{
					pw.println("<tr><td>"+r.getString(3)+"</td><td>"+r.getString(4)+"</td></tr>");
				}
			}
			pw.println("</table>");
			pw.println("</body>");
			pw.println("</html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
