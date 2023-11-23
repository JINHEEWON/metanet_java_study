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

public class DeleteOkServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int empno = (Integer)session.getAttribute("curempno");
		
		EmpDao dao = new EmpDao();
		
		int result = dao.deletByDeptno(empno);
		
		if(result > 0) {
			List<EmpDto> emplist = new ArrayList<EmpDto>();
			emplist = dao.selectAll();
			request.setAttribute("emplist", emplist);
		}else {
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //forward 방식
		forward.setPath("/WEB-INF/views/login/login.jsp");
		
		return forward;
	}

}
