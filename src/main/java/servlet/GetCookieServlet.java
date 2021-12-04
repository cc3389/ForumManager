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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = null;
		Cookie[] cookies = request.getCookies();
		String password = null;
		if (cookies!=null) {
			for(Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					username = cookie.getValue();
				} else if (cookie.getName().equals("password")) {
					password = cookie.getValue();
				}
			}
		}
		boolean isSuccess = false;
		if (username!=null&&password!=null) {//找到了cookie
			//验证账号
			LoginService ls = new LoginService(username, password);
			ls.LoginByMD5();
			if (ls.isSuccess()) {//登录成功
				System.out.println("用户以cookie方式登录成功");
				String identifyName = ls.getIdentifyName();
				User user = ls.getUser();
				Permission permission = ls.getPermission();
				request.getSession().setAttribute("identifyName", identifyName);
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("permission", permission);
				isSuccess = true;
			}
		}
		if (isSuccess) {	
			response.sendRedirect("index.jsp");			
			return;
		} else {
			System.out.println("用户以cookie方式登录失败");
			response.sendRedirect("Login/index.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
