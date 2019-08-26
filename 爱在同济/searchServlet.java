package servlets;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tag;
import daos.TagDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Search(request,response);
	}

	private void Search(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
	    resp.setHeader("Cache-Control", "no-cache"); 
		String key= req.getParameter("key");
		System.out.println(key);
		TagDao tg = new TagDao();
		List<Tag> tags=tg.getTagbySearch(key);
		  
		
		
		if (tags.isEmpty())
		{
			
			resp.getWriter().print(URLEncoder.encode("mark0*mark1没有相关记录！mark2","utf-8"));
			
		}
		else
		{
			String s="";
		for(int i=0; i<tags.size();i++)
		{
			s += "mark0"+tags.get(i).getDate().toString()+"mark1"+tags.get(i).getText()+"mark2";
			
		}
		System.out.println(s);
		resp.getWriter().print(URLEncoder.encode(s,"utf-8"));//½â¾öÖÐÎÄÂÒÂë
		}	
	
			// TODO Auto-generated catch block
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
