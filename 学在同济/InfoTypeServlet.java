package com.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.dao.InfoDao;
import com.dao.InfoTypeDao;
import com.model.Link;
import com.model.InfoType;
import com.util.DbUtil;
import com.util.NavUtil;
import com.util.ResponseUtil;
import com.util.StringUtil;

public class InfoTypeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DbUtil dbUtil=new DbUtil();
	InfoDao infoDao=new InfoDao();
	InfoTypeDao infoTypeDao=new InfoTypeDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		if("preSave".equals(action)){
			this.infoTypePreSave(request, response);
		}else if("save".equals(action)){
			this.infoTypeSave(request, response);
		}else if("backList".equals(action)){
			this.infoTypeBackList(request, response);
		}else if("delete".equals(action)){
			this.infoTypeDelete(request, response);
		}
		
	}

	
	private void infoTypePreSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String infoTypeId=request.getParameter("infoTypeId");
		Connection con=null;
		try{
			con=dbUtil.getCon();
			if(StringUtil.isNotEmpty(infoTypeId)){
				InfoType infoType=infoTypeDao.getInfoTypeById(con, infoTypeId);
				request.setAttribute("infoType", infoType);
			}
			
			if(StringUtil.isNotEmpty(infoTypeId)){
				request.setAttribute("navCode", NavUtil.genInfoManageNavigation("专业信息类别管理", "专业信息类别修改"));
			}else{
				request.setAttribute("navCode", NavUtil.genInfoManageNavigation("专业信息类别管理", "专业信息类别添加"));
			}
			request.setAttribute("mainPage", "/background/infoType/infoTypeSave.jsp");
			request.getRequestDispatcher("/background/mainTemp.jsp").forward(request, response);
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
	
	private void infoTypeSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con=null;
		String infoTypeId=request.getParameter("infoTypeId");
		String typeName=request.getParameter("typeName");
		
		InfoType infoType=new InfoType(typeName);
		
		if(StringUtil.isNotEmpty(infoTypeId)){
			infoType.setInfoTypeId(Integer.parseInt(infoTypeId));
		}
		try{
			con=dbUtil.getCon();
			if(StringUtil.isNotEmpty(infoTypeId)){
				infoTypeDao.infoTypeUpdate(con, infoType);
			}else{
				infoTypeDao.infoTypeAdd(con, infoType);
			}
			request.getRequestDispatcher("/infoType?action=backList").forward(request, response);
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
	
	
	private void infoTypeBackList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con=null;
		try{
			con=dbUtil.getCon();
			List<InfoType> infoTypeBackList=infoTypeDao.infoTypeList(con);
			request.setAttribute("infoTypeBackList", infoTypeBackList);
			request.setAttribute("navCode", NavUtil.genInfoManageNavigation("专业信息类别管理", "专业信息类别维护"));
			request.setAttribute("mainPage", "/background/infoType/infoTypeList.jsp");
			request.getRequestDispatcher("/background/mainTemp.jsp").forward(request, response);
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
	
	private void infoTypeDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String infoTypeId=request.getParameter("infoTypeId");
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			boolean exist=infoDao.existInfoWithInfoTypeId(con, infoTypeId);
			if(exist){
				result.put("errorMsg", "该专业信息类别下有专业信息，不能删除此专业信息类别");
			}else{
				int delNums=infoTypeDao.infoTypeDelete(con, infoTypeId);
				if(delNums>0){
					result.put("success", true);
				}else{
					result.put("errorMsg", "删除失败");
				}
			}
			ResponseUtil.write(result, response);
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
