package daos;
import beans.Tag;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.DataBaseUtil;

public class TagDao {

	//����һ�����
	public void addTag (Tag tag) {
		Connection conn=DataBaseUtil.getConnection();
		try {

			String sql=""+ "insert into tag" +" (tagid,csid,text,time) "+"values(default,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, tag.getCsid());
			psmt.setString(2, tag.getText());
			psmt.setTime(3, tag.getTime());
			
			psmt.execute();
			
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	
	//���ݱ��id����һ�����
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
	//���ȫ���ı��
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
