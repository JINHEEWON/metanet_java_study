package kr.or.bit.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class EditOkServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		
		try {
			
			PrintWriter out = response.getWriter();
		
			String idx = request.getParameter("idx");
			  
			if(idx == null || idx.trim().equals("")){
				out.print("<script>");
				out.print("alert('글번호 입력 오류')");
				out.print("location.href='board_list.jsp'");
				out.print("</script>");
			}
			  
			BoardDao dao = new BoardDao();
			int result = dao.boardEdit(request);
			  
			String msg="";
			String url="";
			if(result > 0){
				msg="edit success";
				url="board_list.meta";
			}else{
				msg="edit fail";
				url="board_edit.meta?idx="+idx;
			}
			
			request.setAttribute("board_msg",msg);
			request.setAttribute("board_url",url);
			
			forward.setPath("/WEB-INF/views/board/redirect.jsp");
		    forward.setRedirect(false); //forward 방식
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}
}
