package daos;
import beans.Score;
import util.DataBaseUtil;
import java.sql.*;

public class ScoreDao {
	//����һ����ѧ��
	public void addScore(Score sc) {
		//���������ݿ������
		Connection conn=DataBaseUtil.getConnection();
		try {
			//������䣬����csidΪ����������ֻ��дdefault
			String sql=""+ "insert into score" +" (scoreid,csid,resid,score) "+"values(default,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//�趨������û�����ֵ������
			psmt.setInt(1, sc.getCsid());
			psmt.setInt(2, sc.getResid());
			psmt.setInt(3, sc.getScore());

			//ִ�в������
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//�����û�id:csid�ͷ���id:resid��ѯ����
	public Score findScoreByCsidAndResid(int csid,int resid) {
		//����һ��score����
		Score sc=new Score();
		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();
		try {
			//��ѯ��䣬����ѧ�Ų�ѯ
			String sql=""+"select * from score where csid = ? and resid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, csid);
			psmt.setInt(2, resid);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//��score�����趨id���û���������ֵ
				sc.setScoreid(rs.getInt("scoreid"));
				sc.setCsid(rs.getInt("csid"));
				sc.setResid(rs.getInt("resid"));
				sc.setScore(rs.getInt("score"));

				
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//����score����
		return sc;
	}
	//���ݷ���id:resid��ѯ����ƽ����
	public int findAvscoreByResid(int resid) {

		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();
		int avgScore=0;
		try {
			//��ѯ��䣬����ѧ�Ų�ѯ
			String sql=""+"select avg(score) from score whereresid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, resid);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			avgScore=rs.getInt(1);
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//����score����
		return avgScore;
	}
	
	
	
}