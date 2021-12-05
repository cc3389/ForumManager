package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BlockService;
import service.PostsService;
import service.ReviewService;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String ID = request.getParameter("id");
	String type = request.getParameter("type");
	System.out.println("delete postID:"+ID);
	System.out.println("type:"+type);
	boolean isDel = false;
	if (type.equals("post")) {
		PostsService ps = new PostsService();
		isDel = ps.delPost(ID);
		response.sendRedirect("Posts/index.jsp?id="+ID);
		//request.getRequestDispatcher("Posts/index.jsp?id="+ID).forward(request, response);
	} else if (type.equals("review")) {
		ReviewService rs = new ReviewService();
		isDel = rs.delReivew(ID);
		response.sendRedirect("Posts/content.jsp?id="+ID);
		//request.getRequestDispatcher("Posts/content.jsp?id="+ID).forward(request, response);
	} else if (type.equals("block")) {
		BlockService bs = new BlockService();
		isDel = bs.del(ID);
		response.sendRedirect("Manage/index.jsp");
		//request.getRequestDispatcher("Manage/index.jsp").forward(request, response);
	}
	if (isDel) {
		System.out.println(type+"删除成功");
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
