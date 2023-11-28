package kr.or.bit.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class EditServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		
		try {
			PrintWriter out = response.getWriter();
			
			String idx = request.getParameter("idx");
			String cpage = request.getParameter("cp");
			String pagesize = request.getParameter("ps");
			
			if(idx == null || idx.trim().equals("")){
				forward.setRedirect(true);
				forward.setPath("/WEB-INF/views/board/board_list.jsp");
				return forward;
			}

			BoardDao dao = new BoardDao();
			Board board = dao.getEditContent(idx);
			
			if(board == null){
				out.print("데이터 오류");
				out.print("<hr><a href='board_list.jsp'>목록가지</a>");
			} else {
				request.setAttribute("board", board);
				request.setAttribute("idx", idx);
				request.setAttribute("cp", cpage);
				request.setAttribute("ps", pagesize);
				
				forward.setRedirect(false); //forward 방식
				forward.setPath("/WEB-INF/views/board/board_edit.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return forward;
	}
}
