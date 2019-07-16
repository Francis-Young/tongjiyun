import java.sql.*;
 

public class mysqlconnection {
	public static void main(String[] args) throws SQLException {
		String driverName="com.mysql.jdbc.Driver";
		String dbURL="jdbc:mysql://rm-uf6oup3g7989vj77l0o.mysql.rds.aliyuncs.com:3306/tongjiyun";
		String userName="root";
		String userPwd="Cheng1230";
		Connection dbConn=null;
		try {
			Class.forName(driverName);
			dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		}
		catch (ClassNotFoundException nfe) {
			nfe.printStackTrace();
			} 
		catch(SQLException sqle) {
			sqle.printStackTrace();
			}
		if (dbConn!=null) {
			try {
				System.out.println("插入成功");
				String sql=""+ "insert into tag" +" (tagid,csid,text,time) "+"values(?,?,?,?)";
				PreparedStatement psmt = dbConn.prepareStatement(sql);
				psmt.setInt(1, 1);
				psmt.setInt(2, 1);
				psmt.setString(3, "我爱你");
				psmt.setTime(4,null);
				psmt.execute();
			}catch(SQLException e) {
	            e.printStackTrace();
	        }finally {
	        	dbConn.close();
	        }
		}
		else {
			System.out.println("插入失败");
		}
			
	}
}
