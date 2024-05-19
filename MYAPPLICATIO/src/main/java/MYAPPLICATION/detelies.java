package MYAPPLICATION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class detelies {
	MYAPPLICATIO my;
	MYAPPLICATIO getMYAPPLICATIO (String Firstname,String SURNAME, String Mobilenumberoremailaddress, String PASSWORD, String MONT,int MNUMBER,int YEAR ,String sex,String uname)
	{ 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:ORCL","system","tiger1");
			PreparedStatement pstmt=con.prepareStatement("insert into myapplication values(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, Firstname);
			pstmt.setString(2, SURNAME);
			pstmt.setString(3, Mobilenumberoremailaddress);
			pstmt.setString(4, PASSWORD);
			pstmt.setString(5, MONT);
			pstmt.setInt(6, MNUMBER);
			pstmt.setInt(7, YEAR);
			pstmt.setString(8, sex);
			pstmt.setString(9, uname);
			ResultSet rs=pstmt.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return my;
		}
}
