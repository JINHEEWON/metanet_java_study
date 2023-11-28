package kr.or.bit.service;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class BoardWriteService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		
		BoardDao dao;
		int result = 0;
		try {
			dao = new BoardDao();		
			Board board = new Board();
			board.setSubject(subject);
			board.setWriter(writer);
			board.setEmail(email);
			board.setHomepage(homepage);
			board.setContent(content);
			board.setPwd(pwd);
			result = dao.writeok(board);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		String msg;
		String url;
		
	    if(result > 0){
	    	msg ="insert success";
	    	url ="/WebServlet_MVC_Team3/board_list.meta";
			//WebServlet_92_Board_Model1/
	    }else{
	    	msg="insert fail";
	    	url="/WebServlet_MVC_Team3/board_write.meta";
	    }
	    
	    System.out.println(msg);
	    System.out.println(url);
	    System.out.println(result);

	    request.setAttribute("board_msg",msg);
	    request.setAttribute("board_url", url);

		String resultdata = "/WEB-INF/views/board/redirect.jsp";
		
		ActionForward forward  = new ActionForward();
		forward.setRedirect(false);
		forward.setPath(resultdata);
		
		return forward;
	}
}

