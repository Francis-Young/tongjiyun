package daos;
import beans.Highschoolstudent;
import util.DataBaseUtil;
import java.sql.*;


public class HighschoolstudentDao {
	//����һ������
	public void addHighschoolstudent(Highschoolstudent hs) {
		//���������ݿ������
		Connection conn=DataBaseUtil.getConnection();
		try {
			//������䣬����hsidΪ����������ֻ��дdefault
			String sql=""+ "insert into highschoolstudent" +" (hsid,hspassword,hsname,hsphone,hssex,hsregion,hsgaokao_year,hschoice) "+"values(default,?,?,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//�趨��������Ӻŵ�ֵ
			psmt.setString(1, hs.getHspassword());
			psmt.setString(2, hs.getHsname());
			psmt.setString(3, hs.getHsphone());
			psmt.setInt(4, hs.getHssex());
			psmt.setString(5, hs.getHsregion());
			psmt.setInt(6, hs.getHsgaokao_year());
			psmt.setString(7, hs.getHschoice());
			//ִ�в������
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//��������id��ѯ����

	public Highschoolstudent findHighschoolstudentByHsid(int hsid) {
		//����һ��Highschoolstudent����
		Highschoolstudent hs=new Highschoolstudent();
		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();

		try {
			//��ѯ��䣬����ѧ�Ų�ѯ
			String sql=""+"select * from highschoolstudent where hsid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hsid);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//��comment�����趨id������ֵ
				hs.setHspassword(rs.getString("hspassword"));
				hs.setHsname(rs.getString("hsname"));
				hs.setHsphone(rs.getString("hsphone"));
				hs.setHssex(rs.getInt("hssex"));
				hs.setHsregion(rs.getString("hsregion"));
				hs.setHsgaokao_year(rs.getInt("hsgaokao_year"));
				hs.setHschoice(rs.getString("hschoice"));
				
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//����Highschoolstudent����
		return hs;
	}
}