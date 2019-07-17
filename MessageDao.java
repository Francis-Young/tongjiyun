package daos;
import beans.Message;
import util.DataBaseUtil;
import java.sql.*;


public class MessageDao {
	//����һ������
	public void addMessage(Message ms) {
		//���������ݿ������
		Connection conn=DataBaseUtil.getConnection();
		try {
			//������䣬����messageidΪ����������ֻ��дdefault
			String sql=""+ "insert into message" +" (messageid,sendid,recieveid,text) "+"values(default,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//�趨��������Ӻŵ�ֵ
			psmt.setInt(1, ms.getSendid());
			psmt.setInt(2, ms.getRecieveid());
			psmt.setString(3, ms.getText());
			//ִ�в������
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//��������id��ѯ����

	public Message findmessageByMessageid(int messageid) {
		//����һ��Message����
		Message ms=new Message();
		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();

		try {
			//��ѯ��䣬����ѧ�Ų�ѯ
			String sql=""+"select * from message where messageid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, messageid);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//��comment�����趨id������ֵ
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
		//����Message����
		return ms;
	}
}