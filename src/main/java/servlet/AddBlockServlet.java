package servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entirety.Block;
import service.BlockService;

/**
 * Servlet implementation class AddBlockServlet
 */
public class AddBlockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String blockName = request.getParameter("blockName");
		String userID = request.getParameter("userID");
		Block block= new Block();
		block.setBlockID(UUID.randomUUID().toString());
		block.setType(blockName);
		block.setSuperAdminID(userID);
		System.out.println("block Info:"+block);
		BlockService bs = new BlockService();
		boolean isAdded = bs.add(block);
		if (isAdded) {
			System.out.println("板块添加成功");
		} else {
			System.out.println("板块添加失败");
		}		
		response.sendRedirect("Manage/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
