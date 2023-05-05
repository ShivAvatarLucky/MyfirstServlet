

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/signin2")
public class ValidateSignIn2 extends HttpServlet  {
//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//	System.out.println("i am http servlet");
//}	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("mail");
	String password=req.getParameter("pwd");
	String name=req.getParameter("name");
	String phone =req.getParameter("phone");
	PrintWriter pw = resp.getWriter();
//	for(int i=0;i<name.length();i++) {
//		//if(name.charAt(i))
//	}
	int count=0;
	for(int i=0;i<name.length();i++) {
		//if(name.charAt(i))
		if(!(name.charAt(i)>='A'&&name.charAt(i)<='Z'||name.charAt(i)>='a'&&name.charAt(i)<='z'||name.charAt(i)==' '))
		{
			//System.out.println("Invalid name");
			pw.write("<html>"
					+ "<body>"
					+ "<h1>INVALID NAME</h1>"
					+ "</body>"
					+ "</html>");
			
			count++;
			break;
		}	
	}
	if(!(phone.length()==10&&(phone.charAt(0)=='6'||phone.charAt(0)=='7'||phone.charAt(0)=='8'||phone.charAt(0)=='9'))) {
			//System.out.println("Invalid phone number");
			pw.write("<html>"
					+ "<body>"
					+ "<h1>INVALID PHONE NUMBER</h1>"
					+ "</body>"
					+ "</html>");
			count++;
	}
	if(count==0) {
		RequestDispatcher rd = req.getRequestDispatcher("success.html");
		rd.forward(req, resp);
	}
	else {
		
		pw.write("<html><body><h1>INVALID EMAIL/PASSWORD</h1></body></html>");
		RequestDispatcher rd = req.getRequestDispatcher("signin2.html");
		rd.include(req, resp);
		
//		RequestDispatcher rd = req.getRequestDispatcher("signin2.html");
//		rd.forward(req, resp);
//		pw.write("<html><body><h1>INVALID EMAIL/PASSWORD</h1></body></html>");
	}
	

	
	
}

}
