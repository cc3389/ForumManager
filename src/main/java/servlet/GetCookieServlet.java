package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import entirety.Permission;
import entirety.User;
import service.LoginService;

/**
 * Servlet implementation class GetCookieServlet
 */
public class GetCookieServlet extends HttpServlet {
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = null;
		Cookie[] cookies = request.getCookies();
		String password = null;
		for(Cookie cookie : cookies) {
			if (cookie.getName().equals("username")) {
				username = cookie.getValue();
			} else if (cookie.getName().equals("password")) {
				password = cookie.getValue();
			}
		}
		boolean isSuccess = false;
		if (username!=null&&password!=null) {//找到了cookie
			//验证账号
			LoginService ls = new LoginService(username, password);
			ls.LoginByMD5();
			if (ls.isSuccess()) {//登录成功
				String identifyName = ls.getIdentifyName();
				User user = ls.getUser();
				Permission permission = ls.getPermission();
				request.getSession().setAttribute("identifyName", identifyName);
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("permisson", permission);
				request.getSession().setAttribute("loginStatus", "success");
				isSuccess = true;
			}
		}
		if (isSuccess) {
			response.sendRedirect("index.jsp");
		} else {
			request.getSession().setAttribute("loginStatus", "fail");
			response.sendRedirect("index.jsp");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
