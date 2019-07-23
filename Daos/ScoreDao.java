package daos;
import beans.Score;
import util.DataBaseUtil;
import java.sql.*;

public class ScoreDao {
	//插入一个大学生
	public void addScore(Score sc) {
		//建立与数据库的连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//插入语句，其中csid为自增，所以只用写default
			String sql=""+ "insert into score" +" (scoreid,csid,resid,score) "+"values(default,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//设定插入的用户名等值，密码
			psmt.setInt(1, sc.getCsid());
			psmt.setInt(2, sc.getResid());
			psmt.setInt(3, sc.getScore());

			//执行插入语句
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//根据用户id:csid和饭店id:resid查询评分
	public Score findScoreByCsidAndResid(int csid,int resid) {
		//建立一个score对象
		Score sc=new Score();
		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			
			String sql=""+"select * from score where csid = ? and resid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, csid);
			psmt.setInt(2, resid);
			//执行查询语句
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//给score对象设定id，用户名等属性值
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
		//返回score对象
		return sc;
	}
	//根据饭店id:resid查询饭店平均分
	public int findAvscoreByResid(int resid) {

		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();
		int avgScore=0;
		try {
			//查询语句，根据resid查询
			String sql=""+"select avg(score) from score where resid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, resid);
			//执行查询语句
			ResultSet rs = psmt.executeQuery();
			avgScore=rs.getInt(1);
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//返回score对象
		return avgScore;
	}
	
	//查询所有饭店
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList findAllRestaurant() {

		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();
		//打包在字符串数组里
			ArrayList residList= new ArrayList();
		try {
			//查询语句，根据学号查询
			String sql=""+"select * from score";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			//执行查询语句
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				residList.add(rs.getString("resid"));
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		
		return residList;
	}
	
	
}
