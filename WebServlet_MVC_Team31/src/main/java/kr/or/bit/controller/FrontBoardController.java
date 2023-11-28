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
import kr.or.bit.service.BoardWriteService;
import kr.or.bit.service.EditOkServiceAction;
import kr.or.bit.service.EditServiceAction;
import kr.or.bit.service.RewriteOkServiceAction;
import kr.or.bit.service.RewriteServiceAction;


@WebServlet("*.meta")
public class FrontBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontBoardController() {
        super();
       
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8"); //클라언트에게 전달한 페이지의 정보 구성
    	
    	String requestUri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlcommand = requestUri.substring(contextPath.length());
    	
    	System.out.println("requestUri : " + requestUri);
    	System.out.println("contextPath : " + contextPath);
    	System.out.println("urlcommand : " + urlcommand);
    	
    	Action action = null;
    	ActionForward forward = null;
   
    	//답글
    	if(urlcommand.equals("/board_rewrite.meta")) {
    		action = new RewriteServiceAction();
    		forward = action.execute(request, response);
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
    	
    	//글쓰기
    	else if (urlcommand.equals("/board_write.meta")) {
    		forward = new ActionForward();
    		forward.setPath("WEB-INF/views/board/board_write.jsp");
    	} 
    	
    	//글쓰기 처리
    	else if (urlcommand.equals("/board_writeok.meta")) {
    		action = new BoardWriteService();
    		forward = action.execute(request, response);
    	}
    	
    	
    	//리스트
    	else if(urlcommand.equals("/board_list.meta")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/views/board/board_list.jsp");
    	}
    	
    	//컨텐츠
    	else if(urlcommand.equals("/board_content.meta")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/views/board/board_content.jsp");
    	}
    	
    	
    	if(forward != null) {
    		if(forward.isRedirect()) {	//true  //location.href="" 새로운 페이지 처리
    			response.sendRedirect(forward.getPath());
    			
    		} else {
    			//false, view 페이지 forward view 데이터 출력
    	    	RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    	    	dis.forward(request, response);
    		}
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
