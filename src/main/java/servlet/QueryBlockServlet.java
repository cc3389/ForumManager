package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlockDao;
import entirety.Block;

/**
 * Servlet implementation class QueryBlockServlet
 */
public class QueryBlockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryBlockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BlockDao bd = new BlockDao();
		String where = request.getParameter("from");
		
		List<Block> blocks = bd.queryAll();
		request.setAttribute("blocks", blocks);
		System.out.println("以找到blocks:"+blocks);
		if (where.equals("manage")) {
			request.getRequestDispatcher("Manage/index.jsp").forward(request, response);
			return;
		} else if (where.equals("home")){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
