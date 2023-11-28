package kr.or.bit.service;

import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;
import kr.or.bit.utils.ThePager;

public class BoardListService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		try {
			BoardDao dao = new BoardDao();
			int totalboardcount = dao.totalBoardCount();
			
			String ps = request.getParameter("ps");
			String cp = request.getParameter("cp");
			
			if(ps == null || ps.trim().equals("")){
				ps = "5";
			}
		
			if(cp == null || cp.trim().equals("")){
				cp = "1"; 
			}
			
			int pagesize = Integer.parseInt(ps);
			int cpage = Integer.parseInt(cp);
			int pagecount=0;
			
			if(totalboardcount % pagesize == 0){
				pagecount = totalboardcount / pagesize;
			}else{
				pagecount = (totalboardcount / pagesize) + 1; 
			}
			
			List<Board> list = dao.list(cpage, pagesize);
			
			int pagersize=3; 
			ThePager pager = new ThePager(totalboardcount,cpage,pagesize,pagersize,"/WebServlet_92_Board_Model1/board_list.meta");
			
			request.setAttribute("pagesize", pagesize);
			request.setAttribute("cpage", cpage);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("list", list);
			request.setAttribute("totalboardcount", totalboardcount);
			request.setAttribute("pager", pager.toString());
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/board/board_list.jsp");
		
		return forward;
	}

}
