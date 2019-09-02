package servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Collegestudent;
import beans.Highschoolstudent;
import beans.Letter;
import beans.Tag;
import daos.LetterDao;

/**
 * Servlet implementation class letterServlet
 */
@WebServlet("/letterServlet")
public class letterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public letterServlet() {
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
			case "seePrevious":
				seePrevious(req,resp);
				break;	
			case "gotozone":
				gotozone(req,resp);
				break;	
			case "send":
				send(req,resp);
				break;
			default:;
				break;
		}
	}

	private void gotozone(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session= req.getSession();
		String yunzoneOwnerName = req.getParameter("yunzoneOwnerName");
		yunzoneOwnerName = new String(yunzoneOwnerName.getBytes("ISO-8859-1"),"UTF-8");
		session.setAttribute("yunzoneOwnerType", Integer.valueOf(req.getParameter("yunzoneOwnerType")));
		session.setAttribute("yunzoneOwnerId", Integer.valueOf(req.getParameter("yunzoneOwnerId")));
		session.setAttribute("yunzoneOwnerName", yunzoneOwnerName);
	    resp.sendRedirect("moban3599/zone.jsp");
	}

	private void send(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Letter le = new Letter();
		HttpSession session= req.getSession();
		int senderid = 0;//错误码
		if (session.getAttribute("usertype").equals("collegestudent"))
		{
			le.setSendertype(1);
			Collegestudent sender = (Collegestudent) session.getAttribute("user");
			senderid=sender.getCsid();
		}
		else
		{
			le.setSendertype(0);
			Highschoolstudent sender =(Highschoolstudent) session.getAttribute("user");
			senderid=sender.getHsid();
		}
		if (req.getParameter("yunzoneOwnerType").equals("collegestudent"))
		{
			le.setReceivertype(1);
			req.setAttribute("yunzoneOwnerType", "collegestudent") ;
		}
		else
			{le.setReceivertype(0);
			req.setAttribute("yunzoneOwnerType", "highschoolstudent") ;
			}
		
		int receiverid = Integer.valueOf(req.getParameter("yunzoneOwnerId"));
		String text = req.getParameter("text");
		text = new String(text.getBytes("ISO-8859-1"),"UTF-8"); 
		String yunzoneOwnerName = req.getParameter("yunzoneOwnerName");
		yunzoneOwnerName = new String(yunzoneOwnerName.getBytes("ISO-8859-1"),"UTF-8");
		
		System.out.println(text);
		le.setReceiverid(receiverid);
		le.setSenderid(senderid);
		le.setText(text);
		LetterDao ld = new LetterDao();
		ld.addLetter(le);
		System.out.println(req.getContextPath());
		
		//req.setAttribute("yunzoneOwnerName", yunzoneOwnerName) ;
	    //req.setAttribute("yunzoneOwnerId", receiverid) ;
	    
		//req.getRequestDispatcher("moban3599/zone.jsp").forward(req,resp);
	    resp.sendRedirect("moban3599/zone.jsp");
	}

	private void seePrevious(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		HttpSession session= req.getSession();
		int senderid = 0;//错误码
		int receivertype;
		int sendertype;
		if (session.getAttribute("usertype").equals("collegestudent"))
		{
			sendertype = 1;
			Collegestudent sender = (Collegestudent) session.getAttribute("user");
			senderid=sender.getCsid();
		}
		else
		{
			sendertype = 0;
			Highschoolstudent sender =(Highschoolstudent) session.getAttribute("user");
			senderid=sender.getHsid();
		}
		if (req.getParameter("yunzoneOwnerType").equals("collegestudent"))
		{
			receivertype=1;
		}
		else
			receivertype=0;
		
		int receiverid = Integer.valueOf(req.getParameter("yunzoneOwnerId"));
		LetterDao ld = new LetterDao();
		List<Letter> letters= ld.findLettersByTalkersid(senderid, receiverid, sendertype, receivertype);
		for (int i = 0; i < letters.size(); i++)
        {
		Letter le= (Letter)(letters.get(i));
		req.setAttribute("text"+i,le.getText());
		req.setAttribute("time"+i,le.getTime().toString());
		if(senderid==le.getSenderid()&&sendertype==le.getSendertype())
		{
			req.setAttribute("direction"+i,"right");
		}
		else
			req.setAttribute("direction"+i,"left");
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

