package kr.or.bit.controller;

import kr.or.bit.dto.Reply;
import kr.or.bit.service.BoardService;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/WriteReplyServlet")
public class WriteReplyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idx= request.getParameter("idx");
        BoardService service = BoardService.getInBoardService();
        JSONArray jsonArray = getJsonArray(service, idx);
        response.getWriter().write(jsonArray.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        //한글처리
        request.setCharacterEncoding("UTF-8");
        //데이터 받기
        String idx= request.getParameter("idx");
        String writer = request.getParameter("reply_writer");
        String content = request.getParameter("reply_content");
        String pwd = request.getParameter("reply_pwd");
        String userid = "empty";
        //service 객체 생성
        BoardService service = BoardService.getInBoardService();
        //DB저장

        try {
            int result = service.replyWrite(Integer.parseInt(idx), writer, userid, content, pwd);
            if (result == 0 ) response.setStatus(400);
        } catch (NamingException e) {
            response.setStatus(400);
            throw new RuntimeException(e);
        }

        JSONArray jsonArray = getJsonArray(service, idx);

        response.getWriter().write(jsonArray.toString());
    }
    private JSONArray getJsonArray(BoardService service, String idx) {
        //덧글 목록 보여주기
        List<Reply> replylist = null; //참조하는 글번호
        JSONArray jsonArray = new JSONArray();
        try {
            replylist = service.replyList(idx);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        if(replylist != null && replylist.size() > 0) {
            for (Reply reply : replylist) {
                JSONObject jsonObject = new JSONObject(reply);

                jsonArray.put(jsonObject);
            }
        }
        return jsonArray;
    }
}