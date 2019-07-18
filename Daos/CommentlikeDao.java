package daos;
import beans.Commentlike;
import java.sql.*;
import util.DataBaseUtil;

public class CommentlikeDao {
	//�����۲���һ������
	public void addCommentlike (Commentlike colike) {
		Connection conn=DataBaseUtil.getConnection();
		try {
			String sql=""+ "insert into commentlike" +" (colikeid,commentid,sid) "+"values(default,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//psmt.setInt(1, colike.getColikeid());
			psmt.setInt(1, colike.getCommentid());
			psmt.setInt(2, colike.getSid());
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }	
	}
	//����ĳһ���ۣ��������ۺţ��ĵ�������
	public int countCommentlike (int comid) {
		Connection conn=DataBaseUtil.getConnection();
		int count=0;
		try {
			String sql=""+"select count(colikeid) from commentlike where commentid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, comid);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				count=rs.getInt(1);
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }	
		return count;
	}

	
}
