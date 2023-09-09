package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateComplaint
 */
@WebServlet("/UpdateComplaint")
public class UpdateComplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateComplaint() {
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
		String [] g=request.getParameter("submit").split(" ");
		PrintWriter pw=response.getWriter();
		String h=g[1];
		int complaintid=0;
		for(int i=0;i<h.length();i++)
		{
			complaintid=(complaintid*10)+(h.charAt(i)-'0');
		}
		String respond=request.getParameter("response");
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection conn=DriverManager.getConnection("jdbc:derby:D:\\Users\\2440223\\MyDB;create=true");
			PreparedStatement ps1=conn.prepareStatement("update complaints set response=? where complaintid=?");
			ps1.setInt(2, complaintid);
			ps1.setString(1, respond);
			ps1.executeUpdate();
			pw.println("Response Updated!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
