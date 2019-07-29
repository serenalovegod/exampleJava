package cn.cdutetc.example11;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Connection conn;
		ResultSet rs;
		String insertSql="insert into student values(1,\"zhang\",20)";
		String insertSql1="insert into student values(1,\"li\",19)";
        String insertSql2="insert into student values(1,\"wang\",18)";
		StudentManage stManage=new StudentManage();
		conn=stManage.getConn();
	    stManage.addData(conn, insertSql);
	    stManage.addData(conn, insertSql1);
	    stManage.addData(conn, insertSql2);
		//stManage.deleteData(conn, "delete from student where name=\"zhang\"");
		rs=stManage.getResult(conn, "select * from student");
		  try {
			while(rs.next())
			  { 
				  System.out.println(rs.getString("name")+"½ñÄê"+rs.getInt("age")+"Ëê");
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

}
