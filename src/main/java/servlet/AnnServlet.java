package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entirety.Announcement;
import service.AnnouncementService;

/**
 * Servlet implementation class AnnServlet
 */
public class AnnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("annTitle");
		String userID = request.getParameter("userID");
		String content = request.getParameter("annContent");
		String type = request.getParameter("type");
		System.out.println("type:"+type);
		AnnouncementService as = new AnnouncementService();
		if (type != null && type.equals("get")) {
			List<Announcement> list = as.get();
			if (list!=null) {
				System.out.println("获取成功");
				request.setAttribute("ann", list);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}
			System.out.println("获取失败");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		} else if (type != null && type.equals("del")) {
			boolean isDel = as.del();
			if (isDel) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
			response.sendRedirect("Manage/index.jsp");
			return;
		} else {
			Announcement ann = new Announcement();
			ann.setAnnouncement_id(UUID.randomUUID().toString());
			ann.setContent(content);
			ann.setPublishTime(new Date());
			ann.setTitle(title);
			
			boolean isAdded = as.add(ann, userID);
			if (isAdded) {
				System.out.println("发布公告成功");
			} else {
				System.out.println("发布公告失败");
			}
			response.sendRedirect("Manage/index.jsp");
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
