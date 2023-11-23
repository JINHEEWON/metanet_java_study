package kr.or.kosa.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.EmpDto;

public class SearchNameServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String searchename = request.getParameter("searchename");
		
		EmpDao dao = new EmpDao();
		
		List<EmpDto> emplist = new ArrayList<EmpDto>();
		emplist = dao.selectEmpByName(searchename);
		request.setAttribute("emplist", emplist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //forward 방식
		forward.setPath("/WEB-INF/views/emp/empmain.jsp");
		
		return forward;
	}

}
