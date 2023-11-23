package kr.or.kosa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.EmpDto;
import kr.or.kosa.service.DeleteOkServiceAction;
import kr.or.kosa.service.LoginOkServiceAction;
import kr.or.kosa.service.ModifyOkServiceAction;
import kr.or.kosa.service.ModifyServiceAction;
import kr.or.kosa.service.RegisterOkServiceAction;
import kr.or.kosa.service.SearchNameServiceAction;

/*
Url 방식 (command 방식 상관 없다)
http://192.168.0.46:8090/WebSite/list.do >> *.do 매핑
http://192.168.0.46:8090/WebSite/write.do >> *.do 매핑

Command방식(parameter 업무 파악)
@WebServlet("site.do")
http://192.168.0.46:8090/WebSite/site.do?cmd=list
http://192.168.0.46:8090/WebSite/site.do?cmd=write

*/
@WebServlet("*.do")
public class FrontRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontRegisterController() {
        super();
       
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setCharacterEncoding("UTF-8");
    	
    	String requestUri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlcommand = requestUri.substring(contextPath.length());
    	
    	System.out.println("requestUri : " + requestUri);
    	System.out.println("contextPath : " + contextPath);
    	System.out.println("urlcommand : " + urlcommand);
    	
    	Action action = null;
    	ActionForward forward = null;
   
    	//로그인 화면
    	if(urlcommand.equals("/login.do")) {
    		//UI 제공
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/views/login/login.jsp");
    	}
    	
    	//로그인 처리
    	else if(urlcommand.equals("/loginok.do")) {
    		//UI + 서비스 로직
    		action = new LoginOkServiceAction();
    		forward = action.execute(request, response);
    	}
    	
    	//회원가입
    	else if(urlcommand.equals("/register.do")) {
    		//UI 제공
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/views/register/register.jsp");
    	}
    	
    	//회원가입 처리
    	else if(urlcommand.equals("/registerok.do")) {
    		//UI + 서비스 로직
    		action = new RegisterOkServiceAction();
    		forward = action.execute(request, response);
    	}
    	
    	//이름 검색
    	else if(urlcommand.equals("/search.do")) {
    		//UI + 서비스 로직
    		action = new SearchNameServiceAction();
    		forward = action.execute(request, response);
    	}
    	
    	//삭제
    	else if(urlcommand.equals("/delete.do")) {
    		//UI + 서비스 로직
    		action = new DeleteOkServiceAction();
    		forward = action.execute(request, response);
    	}
    	
    	//수정화면
    	else if(urlcommand.equals("/modify.do")) {
    		//UI + 서비스 로직
    		action = new ModifyServiceAction();
    		forward = action.execute(request, response);
    	}
    	
    	//수정
    	else if(urlcommand.equals("/modifyok.do")) {
    		//UI + 서비스 로직
    		action = new ModifyOkServiceAction();
    		forward = action.execute(request, response);
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
