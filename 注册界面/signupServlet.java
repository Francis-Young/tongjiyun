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
		//获取请求的行为
		String action = req.getParameter("action");
		System.out.println(req.getParameter("action"));
		//根据不同的action请求，进入不同的方法
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
		System.out.println("进入注册业务！");
		req.setCharacterEncoding("GB2312");
		String username = req.getParameter("username");
		System.out.println(username+'g');
		String usernameString = new String(username.getBytes("ISO-8859-1"),"UTF-8"); //中文解码转换
		String password = req.getParameter("password");
		String email = req.getParameter("telephone");
		String gender = req.getParameter("gender");
		gender = new String(gender.getBytes("ISO-8859-1"),"UTF-8"); 		
		String testtime = req.getParameter("testtime");
		String selectcourse = req.getParameter("selectcourse");
		selectcourse = new String(selectcourse.getBytes("ISO-8859-1"),"UTF-8"); 
		System.out.println(usernameString+password+email+gender+testtime+selectcourse);
		//String inseresult=mgtest.logupdb(usernameString, password, email, gender, grade);//转发到mgtest与数据库交互
        //如果user存在，那就提示用户名错误
/*        if(inseresult=="exist")
        {
            req.setAttribute("err", "用户名已存在!");
            req.getRequestDispatcher("logup.jsp").forward(req,resp);//请求转发
            return;
        }
        JOptionPane.showMessageDialog(null, "注册成功！");//弹窗提示
       resp.sendRedirect("http://localhost:8080/TomcatTest/login.jsp");//转到登录页面
 */        
        
	}

	
	
	
	
	
	
	

}
