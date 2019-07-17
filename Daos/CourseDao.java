package daos;
import beans.Course;
import util.DataBaseUtil;
import java.sql.*;
import java.util.ArrayList;


public class CourseDao {
	//����һ������
	public void addCourse(Course cr) {
		//���������ݿ������
		Connection conn=DataBaseUtil.getConnection();
		try {
			//������䣬����courseidΪ����������ֻ��дdefault
			String sql=""+ "insert into course" +" (courseid,mid,coursename,credit) "+"values(default,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//�趨��������Ӻŵ�ֵ
			psmt.setInt(1, cr.getMid());
			psmt.setString(2, cr.getCoursename());
			psmt.setDouble(3, cr.getCredit());
			//ִ�в������
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//��������id��ѯ����
	public Course findCourseByCourseid(int courseid) {
		//����һ��Course����
		Course cr=new Course();
		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();
		try {
			//��ѯ��䣬���ݿγ�id��ѯ
			String sql=""+"select * from course where courseid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, courseid);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//��Course�����趨id������ֵ
				cr.setCourseid(rs.getInt("courseid"));
				cr.setCoursename(rs.getString("coursename"));
				cr.setCredit(rs.getDouble("credit"));
				cr.setMid(rs.getInt("mid"));
				
				
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//����Course����
		return cr;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList findCourseByMid(int mid) {//��ѯרҵ�����пγ�
		//����һ��Course����
		Course cr=new Course();
		//�������ݿ�����
		Connection conn=DataBaseUtil.getConnection();
		ArrayList aList=new ArrayList<String>();
		try {
			//��ѯ��䣬����רҵid��ѯ
			String sql=""+"select * from course where mid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mid);
			//ִ�в�ѯ���
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				//��Course�����趨id������ֵ
				cr.setCourseid(rs.getInt("courseid"));
				cr.setCoursename(rs.getString("coursename"));
				cr.setCredit(rs.getDouble("credit"));
				cr.setMid(rs.getInt("mid"));
				aList.add(cr);
				
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//����Course������
		return aList;		
		
		
	}
}