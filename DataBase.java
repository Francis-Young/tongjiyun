package bigHomework;
import java.sql.Connection;
import java.sql.DriverManager;

//实现数据库的驱动连接，需要导入jar驱动包，在项目的lib文件夹中。
//提供关闭的方法
public class DataBase {
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	//两种方式均可
	//private static final String URL= "jdbc:mysql://rm-bp14fgqt2783fvljh0o.mysql.rds.aliyuncs.com:3306/1753502?user=slw&password=ShiLeWei2019&autoReconnect=true&failOverReadOnly=false";
	private static final String URL="jdbc:mysql://rm-bp14fgqt2783fvljh0o.mysql.rds.aliyuncs.com:3306/1753502";
	private static final String user="slw";
	private static final String pass="ShiLeWei2019";
	
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL,user,pass);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) 
	{
		if(conn != null) {
		  try {
		     conn.close();
		  }  catch(Exception e) 
		  {
		    e.printStackTrace();
		  }
		conn = null;
		}
	}
}
