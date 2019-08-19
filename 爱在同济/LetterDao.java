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
			
			String sql=""+ "insert into letter" +" (letterid,senderid,receiverid,senddate,sendtime,text) "+"values(default,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//�趨��������Ӻŵ�ֵ
			psmt.setInt(1, le.getSenderid());
			psmt.setInt(2, le.getReceiverid());
			psmt.setDate(3, le.getSenddate());
			psmt.setTime(4, le.getSendtime());
			psmt.setString(5, le.getText());
		
			
			//ִ�в������
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//����senderid��receiverid��ѯվ���ŵ�����
	public List<Letter> findLettersByTalkersid (int senderid,int receiverid) {
		List<Letter> letters=new ArrayList<Letter>();
	
		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();
		try {
			//��ѯ��䣬����ѧ�Ų�ѯ
			String sql=""+"select * from letter where senderid = ? and receiverid = ? order by time";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, senderid);
			psmt.setInt(2, receiverid);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//��score�����趨id���û���������ֵ
				Letter le = new Letter();
				le.setLetterid(rs.getInt("letterid"));
				le.setReceiverid(receiverid);
				le.setSenderid(senderid);
				le.setSenddate(rs.getDate("senddate"));
				le.setSendtime(rs.getTime("sendtime"));
				le.setTime(rs.getTimestamp("time"));
				le.setText(rs.getString("text"));
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
