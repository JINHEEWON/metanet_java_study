package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;

public class RewriteServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		
		String idx = request.getParameter("idx");
		String cpage = request.getParameter("cp");
		String pagesize = request.getParameter("ps");
		String subject = request.getParameter("subject"); // 답글의 제목으로 사용
		
		if(idx == null || subject == null || idx.trim().equals("") || subject.trim().equals("")){
			forward.setRedirect(true);
			forward.setPath("/WEB-INF/views/board/board_list.jsp");
			return forward;
		}
		if(cpage == null || pagesize == null){
			cpage ="1";
			pagesize = "5";
		}
	
		request.setAttribute("idx", idx);
		request.setAttribute("cpage", cpage);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("subject", subject);
		
		forward.setRedirect(false); //forward 방식
		forward.setPath("/WEB-INF/views/board/board_rewrite.jsp");
		return forward;
	}

}
