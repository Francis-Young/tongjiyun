package daos;
import beans.Comment;
import util.DataBaseUtil;
import java.sql.*;
import java.util.ArrayList;

public class CommentDao {
	//����һ������
	public void addComment(Comment ct) {
		//���������ݿ������
		Connection conn=DataBaseUtil.getConnection();
		try {
			//������䣬����commentidΪ����������ֻ��дdefault
			String sql=""+ "insert into comment" +" (commentid,poid,csid,preid,text,likenum,time,deleted) "+"values(default,?,?,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//�趨��������Ӻŵ�ֵ
			psmt.setInt(1, ct.getPoid());
			psmt.setInt(2, ct.getCsid());
			psmt.setInt(3, ct.getPreid());
			psmt.setString(4, ct.getText());
			psmt.setInt(5, ct.getLikenum());
			psmt.setTime(6, ct.getTime());
			psmt.setInt(7, ct.getDeleted());
			//ִ�в������
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//��������id��ѯ����

	public Comment findCommentByCommentid(int commentid) {
		//����һ��comment����
		Comment ct=new Comment();
		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();


		try {
			//��ѯ��䣬����ѧ�Ų�ѯ
			String sql=""+"select * from comment where commentid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, commentid);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//��comment�����趨id������ֵ
				ct.setCommentid(rs.getInt("commentid"));
				ct.setPoid(rs.getInt("poid"));
				ct.setCsid(rs.getInt("csid"));
				ct.setPreid(rs.getInt("preid"));
				ct.setDeleted(rs.getInt("deleted"));
				ct.setText(rs.getString("text"));
				ct.setLikenum(rs.getInt("likenum"));
				ct.setTime(rs.getTime("time"));
				
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//����comment����
		return ct;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList findCommentByPoid(int poid) {//�������ӺŲ�ѯ��������
		//����һ��comment����
		Comment ct=new Comment();
		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();
		ArrayList aList=new ArrayList<String>();//׼����
		try {
			//��ѯ��䣬����ѧ�Ų�ѯ
			String sql=""+"select * from comment where poid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, poid);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				//��comment�����趨id������ֵ
				ct.setCommentid(rs.getInt("commentid"));
				ct.setPoid(rs.getInt("poid"));
				ct.setCsid(rs.getInt("csid"));
				ct.setPreid(rs.getInt("preid"));
				ct.setDeleted(rs.getInt("deleted"));
				ct.setText(rs.getString("text"));
				ct.setLikenum(rs.getInt("likenum"));
				ct.setTime(rs.getTime("time"));
				aList.add(ct);
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//����comment����
		return aList;
	}
}