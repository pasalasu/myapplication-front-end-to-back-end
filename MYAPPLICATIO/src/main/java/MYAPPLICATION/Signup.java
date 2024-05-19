package MYAPPLICATION;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String s1=request.getParameter("First name");
			String s2=request.getParameter("Surname");
			String s3=request.getParameter("Mobile number or email address");
			String s4=request.getParameter("password");
			String s5=request.getParameter("Month");
			String s6=request.getParameter("mnumber");
			String s7=request.getParameter("year");
			String s8=request.getParameter("sex");
			String s9=request.getParameter("uname");
			PreparedStatement pstmt=con.prepareStatement("insert into myapplication values(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			pstmt.setString(3, s3);
			pstmt.setString(4, s4);
			pstmt.setString(5, s5);
			pstmt.setString(6, s6);
			pstmt.setString(7, s7);
			pstmt.setString(8, s8);
			pstmt.setString(9, s9);
			pstmt.executeUpdate();
			PrintWriter pw=response.getWriter();
			pw.println("<html><body class=\"d-flex justify-content-center align-items-center bg-danger-subtle rounded\" style=\"height:700px;\">\r\n"
					+ "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css\">\r\n"
					+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\r\n"
					+ " <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script><center  class=\"bg-dark border border-3 border-primary p-4 m-3 w-25 rounded \">");
			pw.println("<h3 class=\"text-primary \">you have Register Successfully</h3>");
			pw.println("<a href=login.html class=\"btn btn-success w-50\"><span class=\"bi bi-person-fill\"></span>login</a>");
			pw.println("</center></body><html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	}


