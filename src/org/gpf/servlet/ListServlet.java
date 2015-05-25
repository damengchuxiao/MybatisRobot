package org.gpf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gpf.bean.Message;
import org.gpf.factory.DAOFactory;

/**
 * 列表页面初始化控制
 * @author gaopengfei
 * @date 2015-5-24 下午4:03:22
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		try {
			List<Message>messages = DAOFactory.getIMessageDAOInstance().findAll(command, description);
			request.setAttribute("messages", messages);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request, response);
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
