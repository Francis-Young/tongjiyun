package com.web;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.CommentDao;
import com.dao.InfoDao;
import com.dao.InfoTypeDao;
import com.model.Comment;
import com.model.Info;
import com.model.InfoType;
import com.model.PageBean;
import com.util.DateUtil;
import com.util.DbUtil;
import com.util.NavUtil;
import com.util.PageUtil;
import com.util.PropertiesUtil;
import com.util.ResponseUtil;
import com.util.StringUtil;

public class InfoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DbUtil dbUtil=new DbUtil();
	InfoDao infoDao=new InfoDao();
	InfoTypeDao infoTypeDao=new InfoTypeDao();
	CommentDao commentDao=new CommentDao();
	
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
		if("list".equals(action)){
			this.infoList(request, response);
		}else if("show".equals(action)){
			this.infoShow(request, response);
		}else if("preSave".equals(action)){
			this.infoPreSave(request, response);
		}else if("save".equals(action)){
			this.infoSave(request, response);
		}else if("backList".equals(action)){
			this.infoBackList(request,response);
		}else if("delete".equals(action)){
			this.infoDelete(request,response);
		}
		
	}

	private void infoList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String typeId=request.getParameter("typeId");
		String page=request.getParameter("page");
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		Connection con=null;
		Info s_info=new Info();
		if(StringUtil.isNotEmpty(typeId)){
			s_info.setTypeId(Integer.parseInt(typeId));
		}
		try{
			con=dbUtil.getCon();
			int total=infoDao.infoCount(con, s_info,null,null);
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("pageSize")));
			List<Info> newestInfoListWithType=infoDao.infoList(con, s_info, pageBean,null,null);
			request.setAttribute("newestInfoListWithType", newestInfoListWithType);
			String typeName = infoTypeDao.getInfoTypeById(con, typeId).getTypeName();
			request.setAttribute("navCode", NavUtil.genInfoListNavigation(typeName, typeId));
			request.setAttribute("pageCode", PageUtil.getUpAndDownPagation(total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")), typeId));
			request.setAttribute("mainPage", "info/infoList.jsp");
			request.setAttribute("title", typeName);
			request.getRequestDispatcher("foreground/infoTemp.jsp").forward(request, response);
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
	
	private void infoShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String infoId=request.getParameter("infoId");
		Connection con=null;
		try{
			con=dbUtil.getCon();
			infoDao.infoClick(con, infoId);
			Info info=infoDao.getInfoById(con, infoId);
			Comment s_comment=new Comment();
			s_comment.setInfoId(Integer.parseInt(infoId));
			List<Comment> commentList=commentDao.commentList(con, s_comment,null,null,null);
			request.setAttribute("commentList", commentList);
			request.setAttribute("info", info);
			request.setAttribute("pageCode", this.genUpAndDownPageCode(infoDao.getUpAndDownPageId(con, infoId)));
			request.setAttribute("navCode", NavUtil.genInfoNavigation(info.getTypeName(), info.getTypeId()+"",info.getTitle()));
			request.setAttribute("title", info.getTitle());
			request.setAttribute("mainPage", "info/infoShow.jsp");
			request.getRequestDispatcher("foreground/infoTemp.jsp").forward(request, response);
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
	
	private String genUpAndDownPageCode(List<Info> upAndDownPage){
		Info upInfo=upAndDownPage.get(0);
		Info downInfo=upAndDownPage.get(1);
		StringBuffer pageCode=new StringBuffer();
		if(upInfo.getInfoId()==-1){
			pageCode.append("<p>上一篇：没有了</p>");
		}else{
			pageCode.append("<p>上一篇：<a href='info?action=show&infoId="+upInfo.getInfoId()+"'>"+upInfo.getTitle()+"</a></p>");
		}
		if(downInfo.getInfoId()==-1){
			pageCode.append("<p>下一篇：没有了</p>");
		}else{
			pageCode.append("<p>下一篇：<a href='info?action=show&infoId="+downInfo.getInfoId()+"'>"+downInfo.getTitle()+"</a></p>");
		}
		return pageCode.toString();
	}
	
	
	private void infoPreSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String infoId=request.getParameter("infoId");
		Connection con=null;
		try{
			con=dbUtil.getCon();
			if(StringUtil.isNotEmpty(infoId)){
				Info info=infoDao.getInfoById(con, infoId);
				request.setAttribute("info", info);
			}
			List<InfoType> infoTypeList=infoTypeDao.infoTypeList(con);
			request.setAttribute("infoTypeList", infoTypeList);
			if(StringUtil.isNotEmpty(infoId)){
				request.setAttribute("navCode", NavUtil.genInfoManageNavigation("新闻管理", "新闻修改"));				
			}else{
				request.setAttribute("navCode", NavUtil.genInfoManageNavigation("新闻管理", "新闻添加"));				
			}
			request.setAttribute("mainPage", "/background/info/infoSave.jsp");
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
	
	private void infoSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> items=null;
		try {
			items=upload.parseRequest(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator itr=items.iterator();
		Info info=new Info();
		while(itr.hasNext()){
			FileItem item=(FileItem) itr.next();
			if(item.isFormField()){
				String fieldName=item.getFieldName();
				if("infoId".equals(fieldName)){
					if(StringUtil.isNotEmpty(item.getString("utf-8"))){
						info.setInfoId(Integer.parseInt(item.getString("utf-8")));
					}
				}
				if("title".equals(fieldName)){
					info.setTitle(item.getString("utf-8"));
				}
				if("content".equals(fieldName)){
					info.setContent(item.getString("utf-8"));
				}
				if("author".equals(fieldName)){
					info.setAuthor(item.getString("utf-8"));
				}
				if("typeId".equals(fieldName)){
					info.setTypeId(Integer.parseInt(item.getString("utf-8")));
				}
				if("isHead".equals(fieldName)){
					info.setIsHead(Integer.parseInt(item.getString("utf-8")));
				}
				if("isImage".equals(fieldName)){
					info.setIsImage(Integer.parseInt(item.getString("utf-8")));
				}
				if("isHot".equals(fieldName)){
					info.setIsHot(Integer.parseInt(item.getString("utf-8")));
				}
				if("imageName".equals(fieldName)&&info.getImageName()==null){
					if(StringUtil.isNotEmpty(item.getString("utf-8"))){
						info.setImageName(item.getString("utf-8").split("/")[1]);
					}
				}
			}else if(!"".equals(item.getName())){
				try {
					String imageName=DateUtil.getCurrentDateStr();
					info.setImageName(imageName+"."+item.getName().split("\\.")[1]);
					String filePath=PropertiesUtil.getValue("imagePath")+imageName+"."+item.getName().split("\\.")[1];
					item.write(new File(filePath));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			if(info.getInfoId()!=0){
				infoDao.infoUpdate(con, info);
			}else{
				infoDao.infoAdd(con, info);
			}
			request.getRequestDispatcher("/info?action=backList").forward(request, response);
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
	
	private void infoBackList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s_bPublishDate=request.getParameter("s_bPublishDate");
		String s_aPublishDate=request.getParameter("s_aPublishDate");
		String s_title=request.getParameter("s_title");
		String page=request.getParameter("page");
		HttpSession session=request.getSession();
		if(StringUtil.isEmpty(page)){
			page="1";
			session.setAttribute("s_bPublishDate", s_bPublishDate);
			session.setAttribute("s_aPublishDate", s_aPublishDate);
			session.setAttribute("s_title", s_title);
		}else{
			s_bPublishDate=(String) session.getAttribute("s_bPublishDate");
			s_aPublishDate=(String) session.getAttribute("s_aPublishDate");
			s_title=(String) session.getAttribute("s_title");
		}
		Connection con=null;
		Info s_info=new Info();
		if(StringUtil.isNotEmpty(s_title)){
			s_info.setTitle(s_title);
		}
		try{
			con=dbUtil.getCon();
			int total=infoDao.infoCount(con, s_info, s_bPublishDate, s_aPublishDate);
			String pageCode=PageUtil.getPagation(request.getContextPath()+"/info?action=backList", total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("backPageSize")));
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("backPageSize")));
			List<Info> infoBackList=infoDao.infoList(con, s_info,pageBean,s_bPublishDate,s_aPublishDate);
			request.setAttribute("pageCode", pageCode);
			request.setAttribute("infoBackList", infoBackList);
			request.setAttribute("navCode", NavUtil.genInfoManageNavigation("新闻管理", "新闻列表"));
			request.setAttribute("mainPage", "/background/info/infoList.jsp");
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
	
	private void infoDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String infoId=request.getParameter("infoId");
		Connection con=null;
		boolean delFlag;
		try{
			con=dbUtil.getCon();
			int delNums=infoDao.infoDelete(con, infoId);
			if(delNums==1){
				delFlag=true;
			}else{
				delFlag=false;
			}
			ResponseUtil.write(delFlag, response);
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
