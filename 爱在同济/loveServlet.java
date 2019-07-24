package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Collegestudent;
import beans.Message;
import daos.CollegestudentDao;
import daos.MessageDao;

/**
 * Servlet implementation class loveServlet
 */
@WebServlet("/loveServlet")
public class loveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//只有大学生可以发送此类信件
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		HttpSession session= req.getSession();
		Collegestudent cssender = (Collegestudent) session.getAttribute("user");
		int sendid = cssender .getCsnum();
		int recieveid = Integer.valueOf(req.getParameter("recieveid"));
		String text = req.getParameter("text");
		text = new String(text.getBytes("ISO-8859-1"),"UTF-8"); //中文解码转换;
		Message ms = new Message();
		ms.setRecieveid(recieveid);
		ms.setSendid(sendid);
		ms.setText(text);
		MessageDao md = new MessageDao();
		md.addMessage(ms);//记录
		
		Collegestudent csreceiver = CollegestudentDao.findCollegestudentByNum(recieveid);
		String recevierAddress = csreceiver.getCsemail(); 
		Emailsender em = new Emailsender(recevierAddress, text);
		try {
			em.send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
