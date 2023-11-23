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

public class ModifyOkServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
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
		}else {
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //forward 방식
		forward.setPath("/WEB-INF/views/emp/empmain.jsp");
		
		return forward;
	}

}
