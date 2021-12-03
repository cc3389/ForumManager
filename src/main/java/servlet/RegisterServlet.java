package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entirety.User;
import service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("uname");
		String password = request.getParameter("upwd");	
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		User user = new User();
		user.setUserName(name);
		user.setPassword(password);
		user.setMail(email);
		user.setSex(sex);
		Date currentDate = new Date();
		user.setRegisterDate(currentDate);
		System.out.println("注册已发起，用户信息如下：");
		System.out.println(user);
		if (name == null || password == null || email == null || sex == null) {
			//失败重新跳转到注册界面
			request.setAttribute("Fail", "Fail");
			request.getRequestDispatcher("Register/Register.jsp").forward(request, response);
		}
		RegisterService registerService = new RegisterService(user);
		if (registerService.isSuccess()) {
			//跳转到提示界面提示注册成功
			response.sendRedirect("Register/Sucess.jsp");
		} else {
			//失败重新跳转到注册界面
			request.setAttribute("Fail", "Fail");
			request.getRequestDispatcher("Register/Register.jsp").forward(request, response);
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
