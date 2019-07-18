package daos;
import beans.Major;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.DataBaseUtil;

public class MajorDao {
	//����һ��רҵ
	public void addMajor(Major major) {
		Connection conn=DataBaseUtil.getConnection();
		try {
			String sql=""+ "insert into major" +" (mid,mname,schname,mintro,videoaddr,picaddr,mjob,mtele,mlink) "+"values(default,?,?,?,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, major.getMname());
			psmt.setString(2, major.getSchname());
			psmt.setString(3, major.getMintro());
			psmt.setString(4, major.getVideoaddr());
			psmt.setString(5, major.getPicaddr());
			psmt.setString(6, major.getMjob());
			psmt.setString(7, major.getMtele());
			psmt.setString(8, major.getMlink());
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		
	}
	//����רҵ������רҵ����Ϊ�ڽ������ǵ��һ��רҵ����רҵ��������̨
	public Major findMajorByMname(String name) {
		Major major=new Major();
		Connection conn=DataBaseUtil.getConnection();
		try {
			String sql=""+"select * from major where mname = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
	        psmt.setString(1,name);
	        ResultSet rs = psmt.executeQuery();
	        if (rs.next()) {
	        	major.setMid(rs.getInt("mid"));
	        	major.setMname(rs.getString("mname"));
	        	major.setSchname(rs.getString("schname"));
	        	major.setMintro(rs.getString("mintro"));
	        	major.setVideoaddr(rs.getString("videoaddr"));
	        	major.setPicaddr(rs.getString("picaddr"));
	        	major.setMjob(rs.getString("mjob"));
	        	major.setMtele(rs.getString("mtele"));
	        	major.setMlink(rs.getString("mlink"));
	        	
	        }
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return major;
	}
	
	//����ѧԺ�����Ҹ�ѧԺ����רҵ����Ϊҳ�����ǵ��һ����ͼ��Ӧ��ѧԺ¥����ʾ����ѧԺ���е�רҵ
	public List<Major>  getMajorBySchname(String name) {
		List<Major> major=new ArrayList<Major>();
		Connection conn=DataBaseUtil.getConnection();
		try {
			String sql=""+"select * from major where schname = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,name);
	        ResultSet rs = psmt.executeQuery();
	        while (rs.next()) {
	        	Major m=new Major();
	        	m.setMid(rs.getInt("mid"));
	        	m.setMname(rs.getString("mname"));
	        	m.setSchname(rs.getString("schname"));
	        	m.setMintro(rs.getString("mintro"));
	        	m.setVideoaddr(rs.getString("videoaddr"));
	        	m.setPicaddr(rs.getString("picaddr"));
	        	m.setMjob(rs.getString("mjob"));
	        	m.setMtele(rs.getString("mtele"));
	        	m.setMlink(rs.getString("mlink"));
	        	major.add(m);
	        }
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return major;
	}
	
}
