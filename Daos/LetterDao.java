package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Letter;
import beans.Message;
import beans.Score;
import beans.Tag;
import util.DataBaseUtil;

public class LetterDao {
	//����һ������Ͳ
	public void addLetter(Letter le) {
		//���������ݿ������
		Connection conn=DataBaseUtil.getConnection();
		try {
			
			String sql=""+ "insert into letter" +" (letterid,senderid,receiverid,senddate,sendtime,text,sendertype,receivertype) "+"values(default,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//�趨��������Ӻŵ�ֵ
			psmt.setInt(1, le.getSenderid());
			psmt.setInt(2, le.getReceiverid());
			psmt.setDate(3, le.getSenddate());
			psmt.setTime(4, le.getSendtime());
			psmt.setString(5, le.getText());
			psmt.setInt(6, le.getSendertype());
			psmt.setInt(7, le.getReceivertype());
			
			//ִ�в������
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//����senderid��receiverid��ѯվ���ŵ�����
	public List<Letter> findLettersByTalkersid (int talker1id,int talker2id, int talker1type ,int talker2type) {
		List<Letter> letters=new ArrayList<Letter>();
	
		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();
		try {
			//��ѯ��䣬����ѧ�Ų�ѯ
			String sql=""+"select * from letter where (senderid = ? and receiverid = ? and sendertype = ? and receivertype =?) or (senderid = ? and receiverid = ? and sendertype = ? and receivertype =?) order by time";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, talker1id);
			psmt.setInt(2, talker2id);
			psmt.setInt(3, talker1type);
			psmt.setInt(4, talker2type);
			psmt.setInt(5, talker2id);
			psmt.setInt(6, talker1id);
			psmt.setInt(7, talker2type);
			psmt.setInt(8, talker1type);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//��score�����趨id���û���������ֵ
				Letter le = new Letter();
				le.setLetterid(rs.getInt("letterid"));
				le.setReceiverid(rs.getInt("receiverid"));
				le.setSenderid(rs.getInt("senderid"));
				le.setSenddate(rs.getDate("senddate"));
				le.setSendtime(rs.getTime("sendtime"));
				le.setTime(rs.getTimestamp("time"));
				le.setText(rs.getString("text"));
				le.setSendertype(rs.getInt("sendertype"));
				le.setReceivertype(rs.getInt("receivertype"));
				letters.add(le);
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		
		return letters;
	}
}