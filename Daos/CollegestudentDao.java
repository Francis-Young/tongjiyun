package daos;
import beans.Collegestudent;
import util.DataBaseUtil;
import java.sql.*;

public class CollegestudentDao {
	//����һ����ѧ��
	public void addCollegestudent(Collegestudent cs) {
		//���������ݿ������
		Connection conn=DataBaseUtil.getConnection();
		try {
			//������䣬����csidΪ����������ֻ��дdefault
			String sql=""+ "insert into collegestudent" +" (csid,csname,cspassword,cssex,csnum,mname,csyear,csemail,cstele) "+"values(default,?,?,?,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//�趨������û�����ֵ������
			psmt.setString(1, cs.getCsname());
			psmt.setString(2, cs.getCspassword());
			psmt.setInt(3, cs.getCssex());
			psmt.setInt(4, cs.getCsnum());
			psmt.setString(5, cs.getMname());
			psmt.setInt(6, cs.getCsyear());
			psmt.setString(7, cs.getCsemail());
			psmt.setString(8, cs.getCstele());
			//ִ�в������
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//����ѧ�ţ�����id����ѯ��ѧ��
	public Collegestudent findCollegestudentByNum(int num) {
		//����һ��collegestudent����
		Collegestudent cs=new Collegestudent();
		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();
		try {
			//��ѯ��䣬����ѧ�Ų�ѯ
			String sql=""+"select * from collegestudent where csnum = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//��collegestudent�����趨id���û���������ֵ
				cs.setCsid(rs.getInt("csid"));
				cs.setCsname(rs.getString("csname"));
				cs.setCspassword(rs.getString("cspassword"));
				cs.setCssex(rs.getInt("cssex"));
				cs.setCsnum(rs.getInt("csnum"));
				cs.setMname(rs.getString("mname"));
				cs.setCsyear(rs.getInt("csyear"));
				cs.setCsemail(rs.getString("csemail"));
				cs.setCstele(rs.getString("cstele"));
				
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//����collegestudent����
		return cs;
	}
	//�ж�ĳѧ��ѧ���Ƿ���ڣ��������򷵻�true���������ڷ���false
	public boolean isCsNumExist(int num) {
		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();
		try {
			//��ѯ��䣬����ѧ�Ų�ѯ
			String sql=""+"select * from collegestudent where csnum = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
				
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return false;
	}
	//�ж�ĳУ԰�����Ƿ���ڣ��������򷵻�true���������ڷ���false
	public boolean isCsemailExist(String email) {
		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();
		try {
			//��ѯ��䣬����У԰�����ѯ
			String sql=""+"select * from collegestudent where csemail = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);;
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
				
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return false;
	}
	//�ж�ѧ�������Ƿ���ȷ
	public boolean isPasswordRight (String password,Collegestudent cs) {
		if (password.equals(cs.getCspassword())) {
			return true;
		}
		return false;
	}
}
