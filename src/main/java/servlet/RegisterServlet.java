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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = (String)request.getAttribute("uname");
		String password = (String)request.getAttribute("upwd");
		String email = (String)request.getAttribute("mail");
		String sex = (String)request.getAttribute("sex");
		User user = new User();
		user.setUserName(name);
		user.setPassword(password);
		user.setMail(email);
		user.setSex(sex);
		Date currentDate = new Date();
		user.setRegisterDate(currentDate);
		RegisterService registerService = new RegisterService(user);
		if (registerService.isSucess()) {
			//跳转到提示界面提示注册成功
			response.sendRedirect("Register/Sucess.jsp");
		} else {
			//失败重新跳转到注册界面
			request.setAttribute("Fail", "Fail");
			request.getRequestDispatcher("Register/Register.jsp").forward(request, response);
		}
		//System.out.println(user);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
