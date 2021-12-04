package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entirety.Permission;
import entirety.User;
import service.LoginService;
import util.MD5Util;

/**
 * Servlet implementation class LogInServlet
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//查询用户信息 失败则提示重新登，成功则跳转到主页		
		String name = request.getParameter("uname");
		String password = request.getParameter("upwd");
		System.out.println("用户名："+name+"\t"+"密码："+password+"\n"+"发起登录");
		LoginService logSer = new LoginService(name,password);
		logSer.LoginByPass();
		if (logSer.isSuccess()) {
			//将用户名与密码md5保存到cookie上
			//权限与用户信息保存到session上
			//重定向到主页
			System.out.println("登陆成功，Servlet中为用户分配权限与session，准备重定向到主页");
			Cookie nameCookie = new Cookie("username",name);	
			nameCookie.setMaxAge(60*60*24*7);
			String md5 = MD5Util.md5(password);
			Cookie passMD5 = new Cookie("password",md5);
			passMD5.setMaxAge(60*60*24*7);
			response.addCookie(passMD5);
			response.addCookie(nameCookie);
			String identifyName = logSer.getIdentifyName();
			User user = logSer.getUser();
			Permission permission = logSer.getPermission();
			request.getSession().setAttribute("identifyName", identifyName);
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("permission", permission);
			response.sendRedirect("index.jsp");
		} else {
			//重新登
			System.out.println("登录失败，重新登，请求转发到登陆界面");
			request.setAttribute("loginFail", "Fail");
			request.getRequestDispatcher("Login/index.jsp").forward(request, response);			
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
