package daos;

import beans.Restaurant;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DataBaseUtil;

public class RestaurantDao {

	//插入一个饭店
	public void addRestaurant(Restaurant res) {
		Connection conn=DataBaseUtil.getConnection();
		try {
			
			String sql=""+ "insert into restaurant" +" (resid,resname,resintro,respicaddr,menuaddr,resvideoaddr,foodtype,specialdish,meanprice,resscore,resaddr) "+"values(default,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, res.getResname());
			psmt.setString(2, res.getResintro());
			psmt.setString(3, res.getRespicaddr());
			psmt.setString(4, res.getMenuaddr());
			psmt.setString(5, res.getResvideoaddr());
			psmt.setString(6, res.getFoodtype());
			psmt.setString(7, res.getSpecialdish());
			psmt.setInt(8, res.getMeanprice());
			psmt.setInt(9, res.getResscore());
			psmt.setString(10, res.getResaddr());
			psmt.execute();
			
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//根据饭店名查找一个饭店
	public Restaurant findRestaurantByName(String name) {
		Restaurant res=new Restaurant();
		Connection conn=DataBaseUtil.getConnection();
		try {
			
			String sql=""+"select * from restaurant where resname = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
	        psmt.setString(1,name);
	        ResultSet rs = psmt.executeQuery();
	        
	        if (rs.next()) {
	        	res.setResid(rs.getInt("resid"));
	        	res.setResname(rs.getString("resname"));
	        	res.setResintro(rs.getString("resintro"));
	        	res.setRespicaddr(rs.getString("respicaddr"));
	        	res.setMenuaddr(rs.getString("menuaddr"));
	        	res.setResvideoaddr(rs.getString("resvideoaddr"));
	        	res.setFoodtype(rs.getString("foodtype"));
	        	res.setSpecialdish(rs.getString("specialdish"));
	        	res.setMeanprice(rs.getInt("meanprice"));
	        	res.setResscore(rs.getInt("resscore"));
	        	res.setResaddr(rs.getString("resaddr"));
	        }
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return res;
	}
		//根据饭店名id查找一个饭店
	public Restaurant findRestaurantByResid(int resid) {
		Restaurant res=new Restaurant();
		Connection conn=DataBaseUtil.getConnection();
		try {
			
			String sql=""+"select * from restaurant where resid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
	        psmt.setInt(1,resid);
	        ResultSet rs = psmt.executeQuery();
	        
	        if (rs.next()) {
	        	res.setResid(rs.getInt("resid"));
	        	res.setResname(rs.getString("resname"));
	        	res.setResintro(rs.getString("resintro"));
	        	res.setRespicaddr(rs.getString("respicaddr"));
	        	res.setMenuaddr(rs.getString("menuaddr"));
	        	res.setResvideoaddr(rs.getString("resvideoaddr"));
	        	res.setFoodtype(rs.getString("foodtype"));
	        	res.setSpecialdish(rs.getString("specialdish"));
	        	res.setMeanprice(rs.getInt("meanprice"));
	        	res.setResscore(rs.getInt("resscore"));
	        	res.setResaddr(rs.getString("resaddr"));
	        }
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return res;
	}
	
	
	//得到全部的饭店
	public List<Restaurant> getRestaurant() {
		List<Restaurant> restaurant=new ArrayList<Restaurant>();
		Connection conn=DataBaseUtil.getConnection();
		try {
			
			String sql=""+"select * from restaurant";
			PreparedStatement psmt = conn.prepareStatement(sql);
	        ResultSet rs = psmt.executeQuery();
	        
	        while (rs.next()) {
	        	Restaurant res=new Restaurant();
	        	res.setResid(rs.getInt("resid"));
	        	res.setResname(rs.getString("resname"));
	        	res.setResintro(rs.getString("resintro"));
	        	res.setRespicaddr(rs.getString("respicaddr"));
	        	res.setMenuaddr(rs.getString("menuaddr"));
	        	res.setResvideoaddr(rs.getString("resvideoaddr"));
	        	res.setFoodtype(rs.getString("foodtype"));
	        	res.setSpecialdish(rs.getString("specialdish"));
	        	res.setMeanprice(rs.getInt("meanprice"));
	        	res.setResscore(rs.getInt("resscore"));
	        	res.setResaddr(rs.getString("resaddr"));
	        	restaurant.add(res);
	        }
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return restaurant;
	}
	//更新饭店的评分
	public void updateResscore(int resscore,Restaurant res) {
		Connection conn=DataBaseUtil.getConnection();
		try {
			
			String sql=""+"update restaurant set resscore = ? where resid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, resscore);
			psmt.setInt(2, res.getResid());
			psmt.execute();
			
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		
	}
}
