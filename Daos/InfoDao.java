package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Info;
import com.model.PageBean;
import com.util.DateUtil;
import com.util.PropertiesUtil;
import com.util.StringUtil;

public class InfoDao {

	public List<Info> infoList(Connection con,String sql)throws Exception{
		List<Info> infoList=new ArrayList<Info>();
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Info info=new Info();
			info.setInfoId(rs.getInt("infoId"));
			info.setTitle(rs.getString("title"));
			info.setContent(rs.getString("content"));
			info.setPublishDate(DateUtil.formatString(rs.getString("publishDate"), "yyyy-MM-dd HH:mm:ss"));
			info.setAuthor(rs.getString("author"));
			info.setTypeId(rs.getInt("typeId"));
			info.setClick(rs.getInt("click"));
			info.setIsHead(rs.getInt("isHead"));
			info.setImageName(PropertiesUtil.getValue("userImage")+rs.getString("imageName"));
			info.setIsHot(rs.getInt("isHot"));
			infoList.add(info);
		}
		return infoList;
	}
	
	public List<Info> infoList(Connection con,Info s_info,PageBean pageBean,String s_bPublishDate,String s_aPublishDate)throws Exception{
		List<Info> infoList=new ArrayList<Info>();
		StringBuffer sb=new StringBuffer("select * from t_info t1,t_infoType t2 where t1.typeId=t2.infoTypeId ");
		if(s_info.getTypeId()!=-1){
			sb.append(" and t1.typeId="+s_info.getTypeId());
		}
		if(StringUtil.isNotEmpty(s_info.getTitle())){
			sb.append(" and t1.title like '%"+s_info.getTitle()+"%'");
		}
		if(StringUtil.isNotEmpty(s_bPublishDate)){
			sb.append(" and TO_DAYS(t1.publishDate)>=TO_DAYS('"+s_bPublishDate+"')");
		}
		if(StringUtil.isNotEmpty(s_aPublishDate)){
			sb.append(" and TO_DAYS(t1.publishDate)<=TO_DAYS('"+s_aPublishDate+"')");
		}
		sb.append(" order by t1.publishDate desc ");
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Info info=new Info();
			info.setInfoId(rs.getInt("infoId"));
			info.setTitle(rs.getString("title"));
			info.setContent(rs.getString("content"));
			info.setPublishDate(DateUtil.formatString(rs.getString("publishDate"), "yyyy-MM-dd HH:mm:ss"));
			info.setAuthor(rs.getString("author"));
			info.setTypeId(rs.getInt("typeId"));
			info.setTypeName(rs.getString("typeName"));
			info.setClick(rs.getInt("click"));
			info.setIsHead(rs.getInt("isHead"));
			info.setImageName(PropertiesUtil.getValue("userImage")+rs.getString("imageName"));
			info.setIsHot(rs.getInt("isHot"));
			infoList.add(info);
		}
		return infoList;
	}
	
	public int infoCount(Connection con,Info s_info,String s_bPublishDate,String s_aPublishDate)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_info");
		if(s_info.getTypeId()!=-1){
			sb.append(" and typeId="+s_info.getTypeId());
		}
		if(StringUtil.isNotEmpty(s_info.getTitle())){
			sb.append(" and title like '%"+s_info.getTitle()+"%'");
		}
		if(StringUtil.isNotEmpty(s_bPublishDate)){
			sb.append(" and TO_DAYS(publishDate)>=TO_DAYS('"+s_bPublishDate+"')");
		}
		if(StringUtil.isNotEmpty(s_aPublishDate)){
			sb.append(" and TO_DAYS(publishDate)<=TO_DAYS('"+s_aPublishDate+"')");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	public Info getInfoById(Connection con,String infoId)throws Exception{
		String sql="select * from t_info t1,t_infoType t2 where t1.typeId=t2.infoTypeId and t1.infoId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, infoId);
		ResultSet rs=pstmt.executeQuery();
		Info info=new Info();
		if(rs.next()){
			info.setInfoId(rs.getInt("infoId"));
			info.setTitle(rs.getString("title"));
			info.setContent(rs.getString("content"));
			info.setPublishDate(DateUtil.formatString(rs.getString("publishDate"), "yyyy-MM-dd HH:mm:ss"));
			info.setAuthor(rs.getString("author"));
			info.setTypeName(rs.getString("typeName"));
			info.setTypeId(rs.getInt("typeId"));
			info.setClick(rs.getInt("click"));
			info.setIsHead(rs.getInt("isHead"));
			info.setIsImage(rs.getInt("isImage"));
			info.setImageName(PropertiesUtil.getValue("userImage")+rs.getString("imageName"));
			info.setIsHot(rs.getInt("isHot"));
		}
		return info;
	}
	
	public int infoClick(Connection con,String infoId)throws Exception{
		String sql="update t_info set click=click+1 where infoId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, infoId);
		return pstmt.executeUpdate();
	}
	
	public List<Info> getUpAndDownPageId(Connection con,String infoId)throws Exception{
		List<Info> upAndDownPage=new ArrayList<Info>();
		String sql="SELECT * FROM t_info WHERE infoId<? ORDER BY infoId DESC LIMIT 1;";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, infoId);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			upAndDownPage.add(new Info(rs.getInt("infoId"),rs.getString("title")));
		}else{
			upAndDownPage.add(new Info(-1,""));
		}
		
		sql="SELECT * FROM t_info WHERE infoId>? ORDER BY infoId ASC LIMIT 1;";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, infoId);
		rs=pstmt.executeQuery();
		if(rs.next()){
			upAndDownPage.add(new Info(rs.getInt("infoId"),rs.getString("title")));
		}else{
			upAndDownPage.add(new Info(-1,""));
		}
		return upAndDownPage;
	}
	
	
	public boolean existInfoWithInfoTypeId(Connection con,String typeId)throws Exception{
		String sql="select * from t_info where typeId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, typeId);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}
	
	public int infoAdd(Connection con,Info info)throws Exception{
		String sql="insert into t_info values(null,?,?,now(),?,?,0,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, info.getTitle());
		pstmt.setString(2, info.getContent());
		pstmt.setString(3, info.getAuthor());
		pstmt.setInt(4, info.getTypeId());
		pstmt.setInt(5, info.getIsHead());
		pstmt.setInt(6, info.getIsImage());
		pstmt.setString(7, info.getImageName());
		pstmt.setInt(8, info.getIsHot());
		return pstmt.executeUpdate();
	}
	
	public int infoUpdate(Connection con,Info info)throws Exception{
		String sql="update t_info set title=?,content=?,author=?,typeId=?,isHead=?,isImage=?,imageName=?,isHot=? where infoId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, info.getTitle());
		pstmt.setString(2, info.getContent());
		pstmt.setString(3, info.getAuthor());
		pstmt.setInt(4, info.getTypeId());
		pstmt.setInt(5, info.getIsHead());
		pstmt.setInt(6, info.getIsImage());
		pstmt.setString(7, info.getImageName());
		pstmt.setInt(8, info.getIsHot());
		pstmt.setInt(9, info.getInfoId());
		return pstmt.executeUpdate();
	}
	

	public int infoDelete(Connection con,String infoId)throws Exception{
		String sql="delete from t_info where infoId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, infoId);
		return pstmt.executeUpdate();
	}
}