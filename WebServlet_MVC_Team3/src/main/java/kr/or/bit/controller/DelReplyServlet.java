package kr.or.bit.controller;



import kr.or.bit.service.BoardService;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelReplyServlet")
public class DelReplyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        //한글처리
        request.setCharacterEncoding("UTF-8");
        //데이터 받기
        String idx_fk=request.getParameter("idx");//댓글의 원본 게시글 번호
        String no = request.getParameter("no");//댓글의 순번(PK)
        String pwd = request.getParameter("delPwd");//댓글의 암호

        if(idx_fk == null || no == null || pwd == null || no.trim().equals("")) {
            return;
        }
        //parameter 정상인 경우
        BoardService service = BoardService.getInBoardService();
        int result = 0;
        try {
            result = service.replyDelete(no, pwd);
            System.out.println(result);
            if(result == 0) response.setStatus(400);
            else {
                response.setStatus(200);
            }
        } catch (NamingException e) {
            response.setStatus(400);
            throw new RuntimeException(e);
        }
    }
}
