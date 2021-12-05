package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entirety.User;
import service.ProfileService;

/**
 * Servlet implementation class UserInfoServlet
 */
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = (String)request.getParameter("id");
		System.out.println("userid"+ userid);
		ProfileService ps = new ProfileService();
		User user = ps.getUser(userid);
		String identify = ps.getIdentify(user.getIdentifyID());
		if (user != null) {
			System.out.println("获取用户成功in profileservlet");
			System.out.println("cuser"+ user);
			System.out.println("identify"+identify);
			request.setAttribute("cuser", user);
			request.setAttribute("identify",identify);
		} else {
			System.out.println("获取用户失败");		
			request.setAttribute("getUserFail", true);
		}
		System.out.print("请求转发中...\n");
		request.getRequestDispatcher("Profile/index.jsp?id="+userid).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
