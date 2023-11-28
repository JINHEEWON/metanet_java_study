package kr.or.bit.service;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class RewriteOkServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
	
		ActionForward forward = new ActionForward();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String filename = request.getParameter("filename");
		String pwd = request.getParameter("pwd"); 
		
		Board board = new Board();
		board.setIdx(idx);
		board.setSubject(subject);
		board.setWriter(writer);
		board.setContent(content);
		board.setEmail(email);
		board.setHomepage(homepage);
		board.setFilename(filename);
		board.setPwd(pwd);
		
		//서비스 요청(게시물 상세조회  > 답글 쓰기(rewriteok)
		try {
			BoardDao dao = new BoardDao();
			int result = dao.reWriteOk(board);
		
			//list 이동시 현재 pagesize , cpage
			String cpage = request.getParameter("cp"); //current page
			String pagesize = request.getParameter("ps"); //pagesize
			
			//코드는 필요에 따라서  url ="board_list.jsp?cp=<%=cpage";
			String msg="";
		    String url="";
		    if(result > 0){
		    	msg ="rewrite insert success";
		    	url ="board_list.meta";
		    }else{
		    	msg="rewrite insert fail";
		    	url="/WEB-INF/views/board/board_content.jsp?idx="+board.getIdx();
		    }
		    
		    request.setAttribute("board_msg",msg);
		    request.setAttribute("board_url", url);
		    
		    forward.setPath("/WEB-INF/views/board/redirect.jsp");
		    forward.setRedirect(false); //forward 방식
		
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return forward;	
	}
}
