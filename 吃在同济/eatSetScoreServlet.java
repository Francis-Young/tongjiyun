package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Collegestudent;
import beans.Restaurant;
import beans.Score;
import daos.RestaurantDao;
import daos.ScoreDao;

/**
 * Servlet implementation class eatServlet
 */
@WebServlet("/eatSetScoreServlet")
public class eatSetScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eatSetScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//resp.getWriter().append("Served at: ").append(req.getContextPath());

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		int resid = Integer.valueOf(req.getParameter("resid"));
		int score = Integer.valueOf(req.getParameter("score"));
		HttpSession session= req.getSession();
		Collegestudent cs = (Collegestudent) session.getAttribute("user");
		int csid = cs.getCsid();
		//System.out.println("csc"+csid);
		Score sc = new Score();
		sc.setCsid(cs.getCsid());
		sc.setResid(resid);
		sc.setScore(score);
		//����Ƿ�������
		ScoreDao sd = new ScoreDao();
		if(sd.checkScoreByCsidAndResid(csid, resid))//�޸�
		{
			int scoreid=sd.findScoreByCsidAndResid(csid, resid).getScoreid();
			int newScore = score;
			//System.out.println("upp2");
			sd.updatescoreByScorid(scoreid, newScore);
			//System.out.println("up1");
		}
		else
		//����
		{
			sd.addScore(sc);
		}
		//����ƽ����
		double dresscore= sd.findAvscoreByResid(resid);
		//System.out.println("dr"+dresscore);
		int resscore = (int) (dresscore*10);
		//System.out.println(resscore+"gr");
		RestaurantDao rt = new RestaurantDao();
		Restaurant res =rt.findRestaurantByResid(resid);
		rt.updateResscore(resscore, res); 	
		resp.setContentType("text/html");
        resp.getWriter().print("��л���ۣ���������Ϊ"+score+",�������֣�");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
