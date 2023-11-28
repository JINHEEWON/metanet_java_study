package kr.or.bit.service;

import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;
import kr.or.bit.dto.Reply;

public class BoardContentService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String idx= request.getParameter("idx"); 
		ActionForward forward = new ActionForward();
		
		if(idx == null || idx.trim().equals("")){
			forward.setRedirect(true);
			forward.setPath("/WEB-INF/views/board/board_list.jsp");
			
			return forward; 
		}
		
		idx=idx.trim();

		String cpage = request.getParameter("cp");
		String pagesize = request.getParameter("ps");
		request.setAttribute("cpage", cpage);
		request.setAttribute("pagesize", pagesize);
		
		
		if(cpage == null || cpage.trim().equals("")){
			cpage = "1"; 
		}
	
		if(pagesize == null || pagesize.trim().equals("")){
			pagesize = "5"; 
		}
		try {
			BoardDao dao = new BoardDao();
			boolean isRead = dao.getReadNum(idx);
			Board board = dao.getContent(Integer.parseInt(idx));
			request.setAttribute("board", board);
			
			List<Reply> replylist = dao.replylist(idx);
			request.setAttribute("replylist", replylist);
		} catch (NamingException e) {
			e.printStackTrace();
		}
						
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/board/board_content.jsp");
		
		return forward;
	}

}
