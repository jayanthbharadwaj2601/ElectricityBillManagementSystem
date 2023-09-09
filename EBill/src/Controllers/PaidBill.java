package Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaidBill
 */
@WebServlet("/PaidBill")
public class PaidBill extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaidBill() {
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
		String[] g=request.getParameter("submit").split(" ");
		String billId=g[1];
		int billid=0;
		for(int i=0;i<billId.length();i++)
		{
			billid=(billid*10)+(billId.charAt(i)-'0');
		}
		PrintWriter pw=response.getWriter();
//		pw.println("<h1>Hello</h1>");
//		pw.println("<form action='Paid' method='POST'>");
//		pw.println("<input type='text' name='Cardno' placeholder='card number'>");
//		pw.println("<input type='password' name='pin' placeholder='pin'>");
//		pw.println("<input type='submit' name='submit' value='pay "+billid+"'>");
//		pw.println("</form>");
//		Actual html
		pw.println("<!DOCTYPE html>");
		pw.println("<html lang='en'>");
		pw.println("<head>");
		    pw.println("<meta charset='UTF-8'>");
		    pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		    pw.println("<title>Payment Screen");pw.println("</title>");
		    pw.println("<link href='paybill.css' rel='stylesheet'/>");
		pw.println("</head>");
		pw.println("<body>");
		    pw.println("<nav>");
		        pw.println("<img src='solara.gif' class='solaraLogo'>");
//		        pw.println("<h4>Welcome, "+);pw.println("</h4>");
		    pw.println("</nav>");
		    	pw.println("<form action='Paid' method='POST'>");
		            pw.println("<div id='cardScreen'>");
		                pw.println("<h3>Enter Card Details");pw.println("</h3>");
		                pw.println("<input type='text' placeholder='Card Number' class='inp1'>");
		                pw.println("<input type='text' placeholder='Name on Card' class='inp1'>");
		                pw.println("<div>");

		                    pw.println("<input type='text' placeholder='CVV' class='inp2'>");
		                    pw.println("<b>Expiry"); pw.println("</b>");pw.println("<input type='month' class='inp2'>");
		                pw.println("</div>");
		                pw.println("<div class='proceedBtn'>");
		                pw.println("<input type='submit' name='submit' value='pay "+billid+"'>");
		                pw.println("</div>");

		            pw.println("</div>");
		        pw.println("</form>");

		    
		pw.println("</body>");
		pw.println("</html>");
	}

}
