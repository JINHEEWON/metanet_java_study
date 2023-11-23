package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.EmpDto;

public class ModifyServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int empno = (Integer)session.getAttribute("curempno");
		String ename = (String)session.getAttribute("curename");
		
		EmpDao dao = new EmpDao();
		
		EmpDto dto = new EmpDto();

		dto = dao.selectEmpByEmpnoEname(empno,ename);
		
		if(dto.getEname() != null) {
			request.setAttribute("emp", dto);
			
		}else {
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //forward 방식
		forward.setPath("/WEB-INF/views/emp/empmodify.jsp");
		
		return forward;
	}

}
