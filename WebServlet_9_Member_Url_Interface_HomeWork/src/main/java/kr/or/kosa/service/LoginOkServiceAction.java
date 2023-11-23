package kr.or.kosa.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.EmpDto;

public class LoginOkServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		
		EmpDao dao = new EmpDao();
		
		EmpDto dto = new EmpDto();
		dto = dao.selectEmpByEmpnoEname(empno,ename);
		
		String path="";
		if(dto.getEname() != null) {
			List<EmpDto> emplist = new ArrayList<EmpDto>();
			emplist = dao.selectAll();
			request.setAttribute("emplist", emplist);
			session.setAttribute("curempno", empno);
			session.setAttribute("curename", ename);
			path="/WEB-INF/views/emp/empmain.jsp";
			
		}else {
  		    path="/WEB-INF/views/login/login.jsp";
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //forward 방식
		forward.setPath(path);
		
		return forward;
	}

}
