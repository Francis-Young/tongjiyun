package daos;

import beans.Postlike;
import util.DataBaseUtil;
import java.sql.*;



public class PostlikeDao {
	//����һ������
	public void addPostlike(Postlike pe) {
		//���������ݿ������
		Connection conn=DataBaseUtil.getConnection();
		try {
			//������䣬����polikeidΪ����������ֻ��дdefault
			String sql=""+ "insert into postlike" +" (polikeid,poid,sid) "+"values(default,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//�趨��������Ӻŵ�ֵ
			psmt.setInt(1, pe.getPoid());
			psmt.setInt(2, pe.getSid());
			//ִ�в������
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//���ݵ���id��ѯ����

	public Postlike findpostlikeByPostlikeid(int polikeid) {
		//����һ��postlike����
		Postlike pe=new Postlike();
		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();

		try {
			//��ѯ��䣬����ѧ�Ų�ѯ
			String sql=""+"select * from postlike where postlikeid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, polikeid);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//��comment�����趨id������ֵ
				pe.setPolikeid(rs.getInt("polikeid"));
				pe.setPoid(rs.getInt("poid"));
				pe.setSid(rs.getInt("sid"));
	
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//����Postlike����
		return pe;
	}

	public int countPostlikeByPoid(int poid) {//�������ӺŲ�ѯ��������

		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();
		int countPostlike=0;
		try {
			//��ѯ��䣬����ѧ�Ų�ѯ
			String sql=""+"select count(*)  from postlike where poid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, poid);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			countPostlike=rs.getInt(1);
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//����comment����
		return countPostlike;
	}
}