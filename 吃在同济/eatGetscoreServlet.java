package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Collegestudent;
import beans.Restaurant;
import daos.RestaurantDao;
import daos.ScoreDao;

/**
 * Servlet implementation class eatGetscoreServlet
 */
@WebServlet("/eatGetscoreServlet")
public class eatGetscoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eatGetscoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		//��ʾ���з���ƽ������
		
		List list = (new RestaurantDao()).getRestaurant();
		for (int i = 0; i < list.size(); i++)
            {
			Restaurant res= (Restaurant)(list.get(i));
			req.setAttribute("avScore"+res.getResid(),res.getResscore()/10.0);//ƽ����������ʽΪ��avScore+resid��
            }
		//��ʾѧ��ԭ������
		HttpSession session= req.getSession();
		if (session.getAttribute("usertype").equals("collegestudent"))
		{
			Collegestudent cs = (Collegestudent) session.getAttribute("user");
			int csid = cs.getCsid();
			ScoreDao sd = new ScoreDao();
			for (int i = 0; i < list.size(); i++)
            {
				Restaurant res= (Restaurant)(list.get(i));
				int resid = res.getResid();
				if(sd.checkScoreByCsidAndResid(csid, resid))
					{req.setAttribute("csScore"+resid,sd.findScoreByCsidAndResid(csid, resid).getScore());
					
					}
					
            }
		}
		req.getRequestDispatcher("eat.jsp").forward(req,resp);//����ת��
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
