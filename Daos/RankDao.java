package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Course;
import beans.Rank;
import beans.Tag;
import util.DataBaseUtil;

public class RankDao {
	public void update() {
		//建立与数据库的连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//插入语句，其中courseid为自增，所以只用写default
			String sql=""+ "update rank set islastest = 0";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	public void add(Rank rk) {
		//建立与数据库的连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//插入语句，其中courseid为自增，所以只用写default
			String sql=""+ "insert into rank" +" (rid,frequency,type,islastest,name) "+"values(default,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rk.getFrequency());
			psmt.setInt(1, rk.getType());
			psmt.setInt(1, rk.getIslastest());
			psmt.setString(1,rk.getName());
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//获得最新
	public List<Rank> getlastestRank() {
		List<Rank> rks=new ArrayList<Rank>();
		Connection conn=DataBaseUtil.getConnection();
		try {
			
			String sql=""+"select * from rank where islastest =1";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
	        ResultSet rs = psmt.executeQuery();
	        
	        while (rs.next()) {
	        	Rank rk=new Rank();
	        	rk.setRid(rs.getInt("rid"));
	        	rk.setFrequency(rs.getInt("frequency"));
	        	rk.setIslastest(rs.getInt("islastest"));
	        	rk.setType(rs.getInt("type"));
	        	rk.setName(rs.getString("name"));
	        	rks.add(rk);
	        }
	        
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return rks;
	}
	
}
