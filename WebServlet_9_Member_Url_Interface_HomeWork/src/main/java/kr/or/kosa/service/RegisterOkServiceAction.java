package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.EmpDto;

public class RegisterOkServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		
		EmpDao dao = new EmpDao();
		
		EmpDto dto = new EmpDto();
		dto.setEmpno(empno);
		dto.setEname(ename);
		
		int result = dao.insert(dto);
		
		if(result > 0) {
  		    //viewpage="/WEB-INF/views/login/login.jsp";
		}else {
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //forward 방식
		forward.setPath("/WEB-INF/views/login/login.jsp");
		
		return forward;
	}
	
}
