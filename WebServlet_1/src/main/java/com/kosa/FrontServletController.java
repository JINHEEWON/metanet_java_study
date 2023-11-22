package com.kosa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontServletController", urlPatterns = { "/action.do" })
public class FrontServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontServletController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		String msg = "";
		Message m = null;
		if(cmd.equals("greeting")) {
			m = new Message();
			msg = m.getMessage(cmd);
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("msgobj", m);
		
		//결과 지정 (request)
		RequestDispatcher dis = request.getRequestDispatcher("/greeting.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
