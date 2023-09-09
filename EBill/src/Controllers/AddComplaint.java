package Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddComplaint
 */
@WebServlet("/AddComplaint")
public class AddComplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComplaint() {
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
//		doGet(request, response);
		String [] g=request.getParameter("submit").split(" ");
		String h=g[1];
		PrintWriter pw=response.getWriter();
//		for(int i=0;i<g.length;i++)
//			pw.println(g[i]+" "+i);
//		pw.println("<h1> Hello</h1>");
//		pw.println("<form action ='AddedComplaint' method='POST'>");
//		pw.println("<textarea name='complaint'></textarea>");
//		pw.println("<input type='submit' name='submit' value='AddComplaint "+h+"'>");
//		pw.println("</form>");
//		Actual Html
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		  pw.println("<head>");
		    pw.println("<title>Register Complaint");pw.println("</title>");
		    pw.println("<link href='complaints.css' rel='stylesheet' />");

		  pw.println("</head>");
		  pw.println("<body>");
		    pw.println("<nav>");
		      pw.println("<img src='solara.gif' class='solaraLogo'>");
		      pw.println("<h4>Welcome, "+h); pw.println("</h4>");
		  pw.println("</nav>");
		    pw.println("<form action='AddedComplaint' method='POST'>");
		    pw.println("<div id='complaint-form'>");
		      pw.println("<div>");


		        pw.println("<label for='problem-description'>Problem Description");pw.println("<span style='color: red'>*");pw.println("</span>:");pw.println("</label>");pw.println("<br />");
		        pw.println("<br/>");

		        pw.println("<textarea id='problem-description' name='complaint' rows='4' cols='50' required>");
		        pw.println("</textarea>");pw.println("<br/>");
		        pw.println("<br/>");
		        pw.println("<br>");
		        pw.println("<input type='submit' name='submit' class='submitBtn' value='AddComplaint "+h+"'>");
		        pw.println("<br />");pw.println("<br />");
		        pw.println("<input type='reset' value='Cancel' class='submitBtn'/>");
		        pw.println("<br />");pw.println("<br />");
		      pw.println("</div>");
		    pw.println("</div>");
		    pw.println("</form>");
		  pw.println("</body>");
		pw.println("</html>");
		
	}

}
