package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.InfoType;

public class InfoTypeDao {

	public List<InfoType> infoTypeList(Connection con)throws Exception{
		List<InfoType> infoTypeList=new ArrayList<InfoType>();
		String sql="select * from t_infoType";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			InfoType infoType=new InfoType();
			infoType.setInfoTypeId(rs.getInt("infoTypeId"));
			infoType.setTypeName(rs.getString("typeName"));
			infoTypeList.add(infoType);
		}
		return infoTypeList;
	}
	
	public InfoType getInfoTypeById(Connection con,String infoTypeId)throws Exception{
		InfoType infoType=new InfoType();
		String sql="select * from t_infoType where infoTypeId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, infoTypeId);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			infoType.setInfoTypeId(rs.getInt("infoTypeId"));
			infoType.setTypeName(rs.getString("typeName"));
		}
		return infoType;
	}
	
	public int infoTypeAdd(Connection con,InfoType infoType)throws Exception{
		String sql="insert into t_infoType values(null,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, infoType.getTypeName());
		return pstmt.executeUpdate();
	}
	
	public int infoTypeUpdate(Connection con,InfoType infoType)throws Exception{
		String sql="update t_infoType set typeName=? where infoTypeId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, infoType.getTypeName());
		pstmt.setInt(2, infoType.getInfoTypeId());
		return pstmt.executeUpdate();
	}
	
	public int infoTypeDelete(Connection con,String infoTypeId)throws Exception{
		String sql="delete from t_infoType where infoTypeId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, infoTypeId);
		return pstmt.executeUpdate();
	}
}
