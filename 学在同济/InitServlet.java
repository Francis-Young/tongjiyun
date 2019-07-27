package com.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.dao.InfoDao;
import com.dao.InfoTypeDao;
import com.model.Info;
import com.model.InfoType;
import com.util.DbUtil;
import com.util.ResponseUtil;

public class InitServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DbUtil dbUtil=new DbUtil();
	InfoDao infoDao=new InfoDao();
	InfoTypeDao infoTypeDao=new InfoTypeDao();

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext application=config.getServletContext();
		this.refreshSystem(application);
	}
	
	private void refreshSystem(ServletContext application){
		Connection con=null;
		try{
			con=dbUtil.getCon();
			
			List<InfoType> infoTypeList=infoTypeDao.infoTypeList(con);
			application.setAttribute("infoTypeList", infoTypeList);
			
			String sql="select * from t_info order by publishDate desc limit 0,8 ";
			List<Info> newestInfoList=infoDao.infoList(con, sql);
			application.setAttribute("newestInfoList", newestInfoList);
			
			sql="select * from t_info order by click desc limit 0,8";
			List<Info> hotInfoList=infoDao.infoList(con, sql);
			application.setAttribute("hotInfoList", hotInfoList);
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
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		ServletContext application=session.getServletContext();
		this.refreshSystem(application);
		JSONObject result=new JSONObject();
		result.put("success", true);
		try {
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
