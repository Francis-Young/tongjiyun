package daos;
import beans.Course;
import util.DataBaseUtil;
import java.sql.*;
import java.util.ArrayList;


public class CourseDao {
	//插入一个评论
	public void addCourse(Course cr) {
		//建立与数据库的连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//插入语句，其中courseid为自增，所以只用写default
			String sql=""+ "insert into course" +" (courseid,mid,coursename,credit) "+"values(default,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//设定插入的帖子号等值
			psmt.setInt(1, cr.getMid());
			psmt.setString(2, cr.getCoursename());
			psmt.setDouble(3, cr.getCredit());
			//执行插入语句
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//根据评论id查询评论
	public Course findCourseByCourseid(int courseid) {
		//建立一个Course对象
		Course cr=new Course();
		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//查询语句，根据课程id查询
			String sql=""+"select * from course where courseid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, courseid);
			//执行查询语句
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//给Course对象设定id等属性值
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
		//返回Course对象
		return cr;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList findCourseByMid(int mid) {//查询专业下所有课程
		//建立一个Course对象
		Course cr=new Course();
		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();
		ArrayList aList=new ArrayList<String>();
		try {
			//查询语句，根据专业id查询
			String sql=""+"select * from course where mid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mid);
			//执行查询语句
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				//给Course对象设定id等属性值
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
		//返回Course对象组
		return aList;		
		
		
	}
}