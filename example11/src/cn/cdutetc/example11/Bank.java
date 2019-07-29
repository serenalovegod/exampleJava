package cn.cdutetc.example11;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bank {
	
	private static void  updateBalance(Connection con, String name,float balance) {
		       
		try {
		             String sql = "update account set balance=balance+? WHERE name=?";
		             PreparedStatement pstmt = con.prepareStatement(sql);
		             pstmt.setFloat(1,balance);
		             pstmt.setString(2,name);
		             pstmt.executeUpdate();
		     }catch (Exception e) {
		            throw new RuntimeException(e);
		         }
		     }
	public void transferAccounts(String from,String to,float money) {
		      //对事务的操作
		        Connection con = null;
		      try{
		    	  
		            con = StudentManage.getConn();
		            con.setAutoCommit(false);
		            PreparedStatement ps=con.prepareStatement("select * from account where name=?");
		            ps.setString(1, from);
		            ResultSet rs=ps.executeQuery();
		            if(rs.next())
		            {
		               float balance=rs.getFloat(3);
		               if(balance>=money)
		               {
		            	   updateBalance(con,from,-money);//给from减去相应金额
				           updateBalance(con,to,money);
		               }
		               else
		               {
		            	   con.rollback();
		            	   System.out.println("转账失败....");
		               }   
		            }
		         } catch (Exception e) {
		                try {
		                	
							con.rollback();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            } 
		       try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		      
		        
		   
	public void Display()
	{
		Connection conn=StudentManage.getConn();
		ResultSet rs=StudentManage.getResult(conn, "select * from Account");
		try {
			while(rs.next())
			{
				try {
					System.out.println(rs.getString(2)+"账户余额"+rs.getFloat(3));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
