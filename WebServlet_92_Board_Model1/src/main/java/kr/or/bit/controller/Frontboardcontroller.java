package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.BoardContentService;
import kr.or.bit.service.BoardDeleteOkService;
import kr.or.bit.service.BoardListService;
import kr.or.bit.service.BoardWriteService;
import kr.or.bit.service.EditOkServiceAction;
import kr.or.bit.service.EditServiceAction;
import kr.or.bit.service.RewriteOkServiceAction;
import kr.or.bit.service.RewriteServiceAction;



@WebServlet("*.meta")
public class Frontboardcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Frontboardcontroller() {
		super();
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlcommand = requestUri.substring(contextPath.length());

		Action action = null;
		ActionForward forward = null;

		if (urlcommand.equals("/board_content.meta")) {

			action = new BoardContentService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/board_list.meta")) {

			action = new BoardListService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/board_delete.meta")) {

			forward = new  ActionForward();
    		forward.setPath("/WEB-INF/views/board/board_delete.jsp");
		} else if (urlcommand.equals("/board_deleteok.meta")) {

			action = new BoardDeleteOkService();
			forward = action.execute(request, response);
		} /*else if (urlcommand.equals("/board_edit.meta")) {

			action = new BoardEditService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/board_editok.meta")) {

			action = new BoardEditOkService();
			forward = action.execute(request, response);
		}*/ else if (urlcommand.equals("/board_write.meta")) {
    		forward = new ActionForward();
    		forward.setPath("WEB-INF/views/board/board_write.jsp");
    	} else if (urlcommand.equals("/board_writeok.meta")) {
    		action = new BoardWriteService();
    		forward = action.execute(request, response);
    	} else if(urlcommand.equals("/board_rewrite.meta")) {
    		action = new RewriteServiceAction();
    		forward = action.execute(request, response);
    	} else if (urlcommand.equals("/index.meta")) {
    		// action = new IndexService();
    		// forward = action.execute(request, response);
    		forward = new ActionForward();
    		forward.setPath("/index.jsp");
    	}
    	
    	//답글 처리
    	else if(urlcommand.equals("/board_rewriteok.meta")) {
    		action = new RewriteOkServiceAction();
    		forward = action.execute(request, response);
    	}
    	
    	//수정
    	if(urlcommand.equals("/board_edit.meta")) {
    		action = new EditServiceAction();
    		forward = action.execute(request, response);
    	}
    	
    	//수정 처리
    	else if(urlcommand.equals("/board_editok.meta")) {
    		action = new EditOkServiceAction();
    		forward = action.execute(request, response);
    	}

		if (forward != null) {
			if (forward.isRedirect()) { // true // location.href="" 새로운 페이지 처리
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
