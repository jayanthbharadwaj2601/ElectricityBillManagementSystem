package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Signup() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a=request.getParameter("Name");
		String b=request.getParameter("Email");
		String c=request.getParameter("Mobile");
		String d=request.getParameter("UserName");
		String e=request.getParameter("Password");
		PrintWriter pw=response.getWriter();
//		pw.println(a+b+c+d+e);
		Connection e1=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			e1=DriverManager.getConnection("jdbc:derby:D:\\Users\\2440223\\MyDB;create=true");
			
		} catch (SQLException | ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.out.println("A");
		}
		String g="insert into customer values(?,?,?,?,?)";
		PreparedStatement h=null;
		try {
			h = e1.prepareStatement(g);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.out.println("L");
		}
			try {
				h.setString(1, a);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				h.setString(2, b);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				h.setString(3, c);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				h.setString(4, d);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				h.setString(5, e);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				h.executeUpdate();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			pw.print("<h1>User Added</h1>");
	}

}
