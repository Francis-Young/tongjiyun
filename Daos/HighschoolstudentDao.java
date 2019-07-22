package daos;
import beans.Highschoolstudent;
import util.DataBaseUtil;
import java.sql.*;


public class HighschoolstudentDao {
	//插入一个评论
	public static void addHighschoolstudent(Highschoolstudent hs) {
		//建立与数据库的连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//插入语句，其中hsid为自增，所以只用写default
			String sql=""+ "insert into highschoolstudent" +" (hsid,hspassword,hsname,hsphone,hssex,hsregion,hsgaokao_year,hschoice) "+"values(default,?,?,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//设定插入的账号等值
			psmt.setString(1, hs.getHspassword());
			psmt.setString(2, hs.getHsname());
			psmt.setString(3, hs.getHsphone());
			psmt.setInt(4, hs.getHssex());
			psmt.setString(5, hs.getHsregion());
			psmt.setInt(6, hs.getHsgaokao_year());
			psmt.setString(7, hs.getHschoice());
			//执行插入语句
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	

	public static Highschoolstudent findHighschoolstudentByHsid(int hsid) {
		//建立一个Highschoolstudent对象
		Highschoolstudent hs=new Highschoolstudent();
		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();

		try {
			//查询语句，根据账号查询
			String sql=""+"select * from highschoolstudent where hsid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hsid);
			//执行查询语句
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//给comment对象设定id等属性值
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
		//返回Highschoolstudent对象
		return hs;
	}
	
	public static boolean checkPasswordByHsname(String hsname,String hspassword) {

		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();

		try {
			//查询语句，根据账号查询
			String sql=""+"select * from highschoolstudent where hsname = ? and hspassword = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, hsname);
			psmt.setString(2, hspassword);
			//执行查询语句
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
		//返回t or f
		return false;
	}

	
	
	
	public static boolean checkHighschoolstudentByHsname(String hsname) {

		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();

		try {
			//查询语句，根据账号查询
			String sql=""+"select * from highschoolstudent where hsname = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, hsname);
			//执行查询语句
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
		//返回t or f
		return false;
	}


	public static boolean isHsNameExist(String hsname) {
		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//查询语句，根据学号查询
			String sql=""+"select * from highschoolstudent where hsname = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, hsname);
			//执行查询语句
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
}
