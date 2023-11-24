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
@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjaxController() {
        super();
       
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8"); //클라언트에게 전달한 페이지의 정보 구성
  	  	PrintWriter out = response.getWriter();
  	  	
    	String requestUri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlcommand = requestUri.substring(contextPath.length());
    	
    	System.out.println("requestUri : " + requestUri);
    	System.out.println("contextPath : " + contextPath);
    	System.out.println("urlcommand : " + urlcommand);
    	
    	//Action action = null;
    	//ActionForward forward = null;
   
    	//사원번호 체크
    	if(urlcommand.equals("/logincheck.ajax")) {
    		int empno = Integer.parseInt(request.getParameter("empno"));
    		
    		EmpDao dao = new EmpDao();
    		EmpDto dto = new EmpDto();
    		dto = dao.selectEmpByEmpno(empno);
    		
    		if(dto.getEname() != null) {
    			out.write("{\"isExist\":false}");
    		}else {
    			out.write("{\"isExist\":true}");
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
