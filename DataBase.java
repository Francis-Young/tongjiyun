package bigHomework;
import java.sql.Connection;
import java.sql.DriverManager;

//ʵ�����ݿ���������ӣ���Ҫ����jar������������Ŀ��lib�ļ����С�
//�ṩ�رյķ���
public class DataBase {
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	//���ַ�ʽ����
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
