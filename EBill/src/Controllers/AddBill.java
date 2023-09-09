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
 * Servlet implementation class AddBill
 */
@WebServlet("/AddBill")
public class AddBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBill() {
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
		int c=0;
		String username=request.getParameter("username");
		String f1=request.getParameter("energyconsumption");
		PrintWriter pw=response.getWriter();
		int energy=0;
		for(int i=0;i<f1.length();i++)
		{
			energy=(energy*10)+(f1.charAt(i)-'0');
		}
		String f2=request.getParameter("bill");
		int bill=0;
		for(int i=0;i<f2.length();i++)
		{
			bill=(bill*10)+(f2.charAt(i)-'0');
		}
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
			ResultSet s1=ps1.executeQuery();
			while(s1.next())
			{
				c+=1;
			}
			PreparedStatement ps2=conn.prepareStatement("insert into bills values(?,?,?,?,?)");
			ps2.setInt(1, c);
			ps2.setString(2,username);
			ps2.setInt(3, energy);
			ps2.setInt(4, bill);
			ps2.setString(5,"Not Paid");
			ps2.executeUpdate();
			pw.println("Bill Assigned Sucessfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
