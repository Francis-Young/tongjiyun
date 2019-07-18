package daos;
import beans.Dormitory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.DataBaseUtil;

public class DormitoryDao {
	//插入一个宿舍，其中宿舍id自增
	public void addDormitory(Dormitory dorm) {
		Connection conn=DataBaseUtil.getConnection();
		try {
			String sql=""+ "insert into dormitory" +" (doid,doname,dointro,modeladdr,balcony,bathroom,doprice,donew) "+"values(default,?,?,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dorm.getDoname());
			psmt.setString(2, dorm.getDointro());
			psmt.setString(3, dorm.getModeladdr());
			psmt.setInt(4, dorm.getBalcony());
			psmt.setInt(5, dorm.getBathroom());
			psmt.setInt(6, dorm.getDoprice());
			psmt.setString(7, dorm.getDonew());
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//根据宿舍名查找宿舍，因为页面中点击某个宿舍后，传给后端的是宿舍名，根据这个宿舍名找到该宿舍
	public Dormitory findDormitoryByName (String name) {
		Dormitory dorm=new Dormitory();
		Connection conn=DataBaseUtil.getConnection();
		try {
			String sql=""+"select * from Dormitory where doname = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
	        psmt.setString(1,name);
	        ResultSet rs = psmt.executeQuery();
	        if (rs.next()) {
	        	dorm.setDoid(rs.getInt("doid"));
	        	dorm.setDoname(rs.getString("doname"));
	        	dorm.setDointro(rs.getString("dointro"));
	        	dorm.setModeladdr(rs.getString("modeladdr"));
	        	dorm.setBalcony(rs.getInt("balcony"));
	        	dorm.setBathroom(rs.getInt("bathroom"));
	        	dorm.setDoprice(rs.getInt("doprice"));
	        	dorm.setDonew(rs.getString("donew"));
	        }
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return dorm;
	}
	//获得所有的宿舍
	public List<Dormitory>  getDormitory () {
		List<Dormitory> dormitory=new ArrayList<Dormitory>();
		Connection conn=DataBaseUtil.getConnection();
		try {
			String sql=""+"select * from Dormitory";
			PreparedStatement psmt = conn.prepareStatement(sql);
	        ResultSet rs = psmt.executeQuery();
	        while (rs.next()) {
	        	Dormitory dorm=new Dormitory();
	        	dorm.setDoid(rs.getInt("doid"));
	        	dorm.setDoname(rs.getString("doname"));
	        	dorm.setDointro(rs.getString("dointro"));
	        	dorm.setModeladdr(rs.getString("modeladdr"));
	        	dorm.setBalcony(rs.getInt("balcony"));
	        	dorm.setBathroom(rs.getInt("bathroom"));
	        	dorm.setDoprice(rs.getInt("doprice"));
	        	dorm.setDonew(rs.getString("donew"));
	        	dormitory.add(dorm);
	        }
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return dormitory;
	}

}
