package com.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LinkDao;
import com.dao.InfoDao;
import com.dao.InfoTypeDao;
import com.model.Link;
import com.model.Info;
import com.model.InfoType;
import com.util.DbUtil;
import com.util.StringUtil;

public class IndexServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DbUtil dbUtil=new DbUtil();
	InfoDao infoDao=new InfoDao();
	InfoTypeDao infoTypeDao=new InfoTypeDao();
	LinkDao linkDao=new LinkDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			
			List<InfoType> infoTypeList=infoTypeDao.infoTypeList(con);
			
			String sql="select * from t_info where isImage=1 order by publishDate desc limit 0,5";
			List<Info> imageInfoList=infoDao.infoList(con, sql);
			request.setAttribute("imageInfoList", imageInfoList);
			
			sql="select * from t_info where isHead=1 order by publishDate desc limit 0,1 ";
			List<Info> headInfoList=infoDao.infoList(con, sql);
			Info headInfo=headInfoList.get(0);
			headInfo.setContent(StringUtil.Html2Text(headInfo.getContent()));
			request.setAttribute("headInfo", headInfo);
			
			
			sql="select * from t_info where isHot=1 order by publishDate desc limit 0,8 ";
			List<Info> hotSpotInfoList=infoDao.infoList(con, sql);
			request.setAttribute("hotSpotInfoList", hotSpotInfoList);
			
			List allIndexInfoList=new ArrayList();
			if(infoTypeList!=null && infoTypeList.size()!=0){
				for(int i=0;i<infoTypeList.size();i++){
					InfoType infoType=infoTypeList.get(i);
					sql="select * from t_info,t_infoType where typeId=infoTypeId and typeId="+infoType.getInfoTypeId()+" order by publishDate desc limit 0,8";
					List<Info> oneSubList=infoDao.infoList(con, sql);
					allIndexInfoList.add(oneSubList);
				}
			}
			request.setAttribute("allIndexInfoList", allIndexInfoList);
			
			sql="select * from t_link order by orderNum ";
			List<Link> linkList=linkDao.linkList(con, sql);
			request.setAttribute("linkList", linkList);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	

}
