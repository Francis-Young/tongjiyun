package daos;
import beans.Collegestudent;
import util.DataBaseUtil;
import java.sql.*;

public class CollegestudentDao {
	//插入一个大学生
	public void addCollegestudent(Collegestudent cs) {
		//建立与数据库的连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//插入语句，其中csid为自增，所以只用写default
			String sql=""+ "insert into collegestudent" +" (csid,csname,cspassword,cssex,csnum,mname,csyear,csemail,cstele,csuniname) "+"values(default,?,?,?,?,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//设定插入的用户名等值，密码
			psmt.setString(1, cs.getCsname());
			psmt.setString(2, cs.getCspassword());
			psmt.setInt(3, cs.getCssex());
			psmt.setInt(4, cs.getCsnum());
			psmt.setString(5, cs.getMname());
			psmt.setInt(6, cs.getCsyear());
			psmt.setString(7, cs.getCsemail());
			psmt.setString(8, cs.getCstele());
			psmt.setString(8, cs.getCsuniname());
			//执行插入语句
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//根据学号（不是id）查询大学生
	public Collegestudent findCollegestudentByNum(int num) {
		//建立一个collegestudent对象
		Collegestudent cs=new Collegestudent();
		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//查询语句，根据学号查询
			String sql=""+"select * from collegestudent where csnum = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			//执行查询语句
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//给collegestudent对象设定id，用户名等属性值
				cs.setCsid(rs.getInt("csid"));
				cs.setCsname(rs.getString("csname"));
				cs.setCspassword(rs.getString("cspassword"));
				cs.setCssex(rs.getInt("cssex"));
				cs.setCsnum(rs.getInt("csnum"));
				cs.setMname(rs.getString("mname"));
				cs.setCsyear(rs.getInt("csyear"));
				cs.setCsemail(rs.getString("csemail"));
				cs.setCstele(rs.getString("cstele"));
				cs.setCsuniname(rs.getString("csuniname"));
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//返回collegestudent对象
		return cs;
	}
	//判断某学号学生是否存在，若存在则返回true，若不存在返回false
	public boolean isCsNumExist(int num) {
		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//查询语句，根据学号查询
			String sql=""+"select * from collegestudent where csnum = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
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
	//判断某校园邮箱是否存在，若存在则返回true，若不存在返回false
	public boolean isCsemailExist(String email) {
		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//查询语句，根据校园邮箱查询
			String sql=""+"select * from collegestudent where csemail = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);;
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
	//判断学生密码是否正确
	public boolean isPasswordRight (String password,Collegestudent cs) {
		if (password.equals(cs.getCspassword())) {
			return true;
		}
		return false;
	}
}
