package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class signupServlet
 */
@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		//System.out.println('t');
		//��ȡ�������Ϊ
		String action = req.getParameter("action");
		System.out.println(req.getParameter("action"));
		//���ݲ�ͬ��action���󣬽��벻ͬ�ķ���
		switch (action)
		{
			case "login":
				//login(req,resp);
				break;
			case "SIGNUP":
				signup(req,resp);
				break;
			default:
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void signup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		System.out.println("����ע��ҵ��");
		req.setCharacterEncoding("GB2312");
		String username = req.getParameter("username");
		System.out.println(username+'g');
		String usernameString = new String(username.getBytes("ISO-8859-1"),"UTF-8"); //���Ľ���ת��
		String password = req.getParameter("password");
		String email = req.getParameter("telephone");
		String gender = req.getParameter("gender");
		gender = new String(gender.getBytes("ISO-8859-1"),"UTF-8"); 		
		String testtime = req.getParameter("testtime");
		String selectcourse = req.getParameter("selectcourse");
		selectcourse = new String(selectcourse.getBytes("ISO-8859-1"),"UTF-8"); 
		System.out.println(usernameString+password+email+gender+testtime+selectcourse);
		//String inseresult=mgtest.logupdb(usernameString, password, email, gender, grade);//ת����mgtest�����ݿ⽻��
        //���user���ڣ��Ǿ���ʾ�û�������
/*        if(inseresult=="exist")
        {
            req.setAttribute("err", "�û����Ѵ���!");
            req.getRequestDispatcher("logup.jsp").forward(req,resp);//����ת��
            return;
        }
        JOptionPane.showMessageDialog(null, "ע��ɹ���");//������ʾ
       resp.sendRedirect("http://localhost:8080/TomcatTest/login.jsp");//ת����¼ҳ��
 */        
        
	}

	
	
	
	
	
	
	

}
