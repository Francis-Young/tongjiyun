package daos;
import beans.Tag;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.DataBaseUtil;

public class TagDao {

	//插入一条表白
	public void addTag (Tag tag) {
		Connection conn=DataBaseUtil.getConnection();
		try {

			String sql=""+ "insert into tag" +" (tagid,csid,text,time,date) "+"values(default,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, tag.getCsid());
			psmt.setString(2, tag.getText());
			psmt.setTime(3, tag.getTime());
			psmt.setDate(4, tag.getDate());
			psmt.execute();
			
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	
	//根据表白id查找一条表白
	public Tag findTagByTagid(int tid) {
		Tag tag=new Tag();
		Connection conn=DataBaseUtil.getConnection();
		try {
			
			String sql=""+"select * from tag where tagid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1,tid);
	        ResultSet rs = psmt.executeQuery();
	        
	        if (rs.next()) {
	        	tag.setTagid(rs.getInt("tagid"));
	        	tag.setCsid(rs.getInt("csid"));
	        	tag.setText(rs.getString("text"));
	        	tag.setTime(rs.getTime("time"));
	        	tag.setDate(rs.getDate("date"));
	        }
	        
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return tag;
	}
	//获得全部的表白
	public List<Tag> getTag() {
		List<Tag> tag=new ArrayList<Tag>();
		Connection conn=DataBaseUtil.getConnection();
		try {
			
			String sql=""+"select * from tag";
			PreparedStatement psmt = conn.prepareStatement(sql);
	        ResultSet rs = psmt.executeQuery();
	        
	        while (rs.next()) {
	        	Tag t=new Tag();
	        	t.setTagid(rs.getInt("tagid"));
	        	t.setCsid(rs.getInt("csid"));
	        	t.setText(rs.getString("text"));
	        	t.setTime(rs.getTime("time"));
	        	t.setDate(rs.getDate("date"));
	        	tag.add(t);
	        }
	        
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return tag;
	}
		//获得前一天全部的表白
		public List<Tag> getTagYesterday(Date date) {
			List<Tag> tag=new ArrayList<Tag>();
			Connection conn=DataBaseUtil.getConnection();
			try {
				
				String sql=""+"select * from tag where date = ?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setDate(1,date);
		        ResultSet rs = psmt.executeQuery();
		        
		        while (rs.next()) {
		        	Tag t=new Tag();
		        	t.setTagid(rs.getInt("tagid"));
		        	t.setCsid(rs.getInt("csid"));
		        	t.setText(rs.getString("text"));
		        	t.setTime(rs.getTime("time"));
		        	t.setDate(rs.getDate("date"));
		        	tag.add(t);
		        }
		        
			}catch(SQLException e) {
	            e.printStackTrace();
	        }catch(NullPointerException f){
	            f.printStackTrace();
	        }finally {
	            DataBaseUtil.closeConnection(conn);
	        }
			return tag;
		}
}
