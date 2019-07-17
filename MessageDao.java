package daos;
import beans.Message;
import util.DataBaseUtil;
import java.sql.*;


public class MessageDao {
	//插入一个评论
	public void addMessage(Message ms) {
		//建立与数据库的连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//插入语句，其中messageid为自增，所以只用写default
			String sql=""+ "insert into message" +" (messageid,sendid,recieveid,text) "+"values(default,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//设定插入的帖子号等值
			psmt.setInt(1, ms.getSendid());
			psmt.setInt(2, ms.getRecieveid());
			psmt.setString(3, ms.getText());
			//执行插入语句
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//根据评论id查询评论

	public Message findmessageByMessageid(int messageid) {
		//建立一个Message对象
		Message ms=new Message();
		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();

		try {
			//查询语句，根据学号查询
			String sql=""+"select * from message where messageid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, messageid);
			//执行查询语句
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//给comment对象设定id等属性值
				ms.setMessageid(rs.getInt("messageid"));
				ms.setSendid(rs.getInt("sendid"));
				ms.setRecieveid(rs.getInt("recieveid"));
				ms.setText(rs.getString("text"));
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//返回Message对象
		return ms;
	}
}