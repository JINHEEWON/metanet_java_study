package kr.or.bit.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;

public class IndexService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		Connection conn = null;
		PrintWriter out = null; 
		try {
			Context context = new InitialContext();
			out = response.getWriter();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
                try {
                    conn.close(); // 반환하기 
                    out.println("db 연결여부: " + conn.isClosed() + "<br>");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		}
		return null;
	}
	
} 
