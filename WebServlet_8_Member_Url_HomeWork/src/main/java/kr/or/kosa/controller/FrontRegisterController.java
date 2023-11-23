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

import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.EmpDto;

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
		//1.한글
    	//2.데이터 받기
    	//3.요청 판단하기 ... 판단에 따른 서비스 실행
    	
    	// register 라면 회원가입 주세요 >> register.jsp
    	// registerok 라면 회원데이터 받아서 DB insert 하세요 그리고 webcome 페이지 forward
    	// request 에 "회원 id 하고 환영인사" 담아서 view 에서 출력 >> register_welcome.jsp
    	
    	//4.데이터 담기
    	//5.뷰지정
    	//6.뷰 forward

    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8"); //클라언트에게 전달한 페이지의 정보 구성
  	  	PrintWriter out = response.getWriter();
  	  	
  	  	HttpSession session = request.getSession();
    	
    	String requestUri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlcommand = requestUri.substring(contextPath.length());
    	
    	System.out.println("requestUri : " + requestUri);
    	System.out.println("contextPath : " + contextPath);
    	System.out.println("urlcommand : " + urlcommand);
    	
    	
    	//3. 요청 서비스 판단 (command 통해서) 문자열 비교
    	//3.1 판단에 의해서 서비스 동작 (DB작업 , 암호화 , ....)
    	String viewpage="";
    	
    	//로그인 화면
    	if(urlcommand.equals("/login.do")) {
    		viewpage="/WEB-INF/views/login/login.jsp";
    	}
    	
    	//로그인 시도 (성공->list / 실패->경고창후 다시 로그인화면)
    	else if(urlcommand.equals("/loginok.do")) {
    		int empno = Integer.parseInt(request.getParameter("empno"));
    		String ename = request.getParameter("ename");
    		
    		EmpDao dao = new EmpDao();
    		
    		EmpDto dto = new EmpDto();
    		dto = dao.selectEmpByEmpnoEname(empno,ename);
    		
    		String resultdata="";
    		if(dto.getEname() != null) {
    			List<EmpDto> emplist = new ArrayList<EmpDto>();
    			emplist = dao.selectAll();
    			request.setAttribute("emplist", emplist);
    			session.setAttribute("curempno", empno);
    			session.setAttribute("curename", ename);
    			viewpage="/WEB-INF/views/emp/empmain.jsp";
    			
    		}else {
    			out.print("<script>");
      		    out.print("alert('등록실패..');");
      		    out.print("location.href='loginok.do';");
      		    out.print("</script>");
      		    
      		    viewpage="/WEB-INF/views/login/login.jsp";
    		}
    	}
    	
    	//회원가입
    	else if(urlcommand.equals("/register.do")) { 	
    		viewpage="/WEB-INF/views/register/register.jsp";
    	}
    	
    	//회원가입 처리
    	else if(urlcommand.equals("/registerok.do")) {
    		//회원가입 처리 (DB작업)
    		//입력 데이터 >> DB 연결 >> insert >> 여부 > 처리
    		int empno = Integer.parseInt(request.getParameter("empno"));
    		String ename = request.getParameter("ename");
    		
    		EmpDao dao = new EmpDao();
    		
    		EmpDto dto = new EmpDto();
    		dto.setEmpno(empno);
    		dto.setEname(ename);
    		
    		int result = dao.insert(dto);
    		
    		if(result > 0) {
    			out.print("<script>");
      		    out.print("alert('회원가입 성공!');");
      		    out.print("location.href='registerok.do';");
      		    out.print("</script>");
      		    
      		    viewpage="/WEB-INF/views/login/login.jsp";
    		}else {
    		}
    	}
    	
    	//이름 검색
    	else if(urlcommand.equals("/search.do")) {
    		String searchename = request.getParameter("searchename");
    		
    		EmpDao dao = new EmpDao();
    		
    		List<EmpDto> emplist = new ArrayList<EmpDto>();
			emplist = dao.selectEmpByName(searchename);
			request.setAttribute("emplist", emplist);

    		viewpage="/WEB-INF/views/emp/empmain.jsp";

    	}
    	
    	//삭제
    	else if(urlcommand.equals("/delete.do")) {
    		int empno = (Integer)session.getAttribute("curempno");
    		
    		EmpDao dao = new EmpDao();
    		
    		int result = dao.deletByDeptno(empno);
    		
    		if(result > 0) {
    			List<EmpDto> emplist = new ArrayList<EmpDto>();
    			emplist = dao.selectAll();
    			request.setAttribute("emplist", emplist);
    			
    			out.print("<script>");
      		    out.print("alert('사원삭제');");
      		    out.print("location.href='registerok.do';");
      		    out.print("</script>");
      		   
      		    viewpage="/WEB-INF/views/login/login.jsp";
    		}else {
    		}
    	}
    	
    	//수정화면
    	else if(urlcommand.equals("/modify.do")) {
    		int empno = (Integer)session.getAttribute("curempno");
    		String ename = (String)session.getAttribute("curename");
    		
    		EmpDao dao = new EmpDao();
    		
    		EmpDto dto = new EmpDto();
 
    		dto = dao.selectEmpByEmpnoEname(empno,ename);
    		
    		String resultdata="";
    		if(dto.getEname() != null) {
    			request.setAttribute("emp", dto);
    			viewpage="/WEB-INF/views/emp/empmodify.jsp";
    			
    		}else {
    		}
    	}
    	
    	//수정
    	else if(urlcommand.equals("/modifyok.do")) {
    		int empno = Integer.parseInt(request.getParameter("empno"));
    		String ename = request.getParameter("ename");
    		String job = request.getParameter("job");
    		int mgr = Integer.parseInt(request.getParameter("mgr"));
    		String hiredate = request.getParameter("hiredate");
    		int sal = Integer.parseInt(request.getParameter("sal"));
    		int comm = Integer.parseInt(request.getParameter("comm"));
    		int deptno = Integer.parseInt(request.getParameter("deptno"));
    		
    		EmpDao dao = new EmpDao();
    		
    		EmpDto dto = new EmpDto();
    		dto.setEmpno(empno);
    		dto.setEname(ename);
    		dto.setJob(job);
    		dto.setMgr(mgr);
    		dto.setHiredate(hiredate);
    		dto.setSal(sal);
    		dto.setComm(comm);
    		dto.setDeptno(deptno);
    		
    		int result = dao.update(dto);
    		
    		if(result > 0) {
    			List<EmpDto> emplist = new ArrayList<EmpDto>();
    			emplist = dao.selectAll();
    			request.setAttribute("emplist", emplist);
    			session.setAttribute("curempno", empno);
    			session.setAttribute("curename", ename);
    			out.print("<script>");
      		    out.print("alert('수정');");
      		    out.print("location.href='registerok.do';");
      		    out.print("</script>");
      		    viewpage="/WEB-INF/views/emp/empmain.jsp";
    		}else {
    		}

    	}
    	
    	//5. View 지정하기
    	RequestDispatcher dis = request.getRequestDispatcher(viewpage);
 	
    	//6. View forward
    	dis.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
