package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Collegestudent;
import beans.Restaurant;
import beans.Tag;
import daos.RestaurantDao;
import daos.TagDao;

/**
 * Servlet implementation class biaobaiServlet
 */
@WebServlet("/biaobaiServlet")
public class biaobaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public biaobaiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		//获取请求的行为
		String action = req.getParameter("action");
		switch (action)
		{
			case "see":
				see(req,resp);
				break;			
			case "Hand_in":
				Hand_in(req,resp);
				break;
			default:;
				break;
		}
		
		
		
	}

	private void Hand_in(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		java.sql.Date date= getWebTime.getWebsiteDate("http://www.baidu.com");//获取网络日期
		java.sql.Time time= getWebTime.getWebsiteTime("http://www.baidu.com");//获取网络时间
		HttpSession session= req.getSession();
		Collegestudent cs = (Collegestudent) session.getAttribute("user");
		int csid=cs.getCsid();
		String text = req.getParameter("text");
		Tag tag = new Tag();
		tag.setCsid(csid);
		tag.setDate(date);
		tag.setText(text);
		tag.setTime(time);
		
		
	}
	private void see(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		java.sql.Date dateToday= getWebTime.getWebsiteDate("http://www.baidu.com");//获取网络日期
		java.sql.Time time= getWebTime.getWebsiteTime("http://www.baidu.com");//获取网络时间
		HttpSession session= req.getSession();
		Collegestudent cs = (Collegestudent) session.getAttribute("user");
		int csid=cs.getCsid();
		Date datey=getWebTime.yesterday(dateToday);
		java.sql.Date dateYesterday=new java.sql.Date(datey.getTime());//转换date类型
		List list = (new TagDao()).getTagYesterday(dateYesterday);
		for (int i = 0; i < list.size(); i++)
            {
			Tag tag= (Tag)(list.get(i));
			req.setAttribute("no."+i,tag.getText());
            }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
