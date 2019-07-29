package cn.cdutetc.example11;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
public class StudentManage{
	Connection conn=null;
public static Connection getConn()
	{
		Connection conn=null;
		 try {
		  Class.forName("com.mysql.jdbc.Driver");	
	//	  System.out.println("successful");
		  conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testData?characterEncoding=UTF-8","root", "root");
		 }catch(ClassNotFoundException e)
		 {
		   conn=null;
	     } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return conn;
		 
	}
public static ResultSet getResult(Connection conn,String sql)
{
    Statement st;
    ResultSet rs=null;
	try {
		st = conn.createStatement();
		rs = st.executeQuery(sql);
	} catch (SQLException e) {
		
	}
	return rs; 
}
public void addData(Connection conn,String sql)
{
	Statement st;
	try {
		st = conn.createStatement();
	    st.execute(sql);
	} catch (SQLException e) {	
	}
}
public void deleteData(Connection conn,String sql)
{
	Statement st;
	try {
		st = conn.createStatement();
	    st.execute(sql);
	} catch (SQLException e) {	
	}
}
}
