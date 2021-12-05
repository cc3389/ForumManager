package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entirety.Post;
import entirety.User;
import service.PostsService;

/**
 * Servlet implementation class PostsServlet
 */
public class PostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//根据block ID查询相应的帖子，进入帖子界面
		String blockID = (String)request.getAttribute("blockID");
		System.out.println("blockID:"+blockID);	
		PostsService ps = new PostsService();
		List<Post> posts = ps.getPosts(blockID);
		List<String> userid = new ArrayList<String>();
		for(int i = 0 ;i <posts.size();++i) {
			User u = ps.getPostWriter(posts.get(i));
			userid.add(u.getUserID());
		}
		
		if (posts != null) {//成功获取帖子
			System.out.println("成功获取帖子,如下：");
			System.out.println(posts);
			request.setAttribute("posts", posts);
			request.setAttribute("isGetPost",true);		
			request.setAttribute("userids",userid);
		} else {
			System.out.println("获取帖子失败");
			request.setAttribute("isGetPost",false);
		}
		request.getRequestDispatcher("Posts/index.jsp?id="+blockID).forward(request,response);		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
