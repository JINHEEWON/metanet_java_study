package kr.or.kosa.utils;

import java.sql.Connection;
import java.sql.DriverManager;

//singleton 형태 ... 연결 객체는... APP 종료될때까지.. 공유 
//개인 연습용 .... 문제 없음
//현업 DB ... 연결 (Connection pool) >> 히카리, 반환하기를 기대(반환주기가 빠름(메소드단위))
//https://velog.io/@dongvelop/Spring-Boot-Hikari-CP-%EC%BB%A4%EC%8A%A4%ED%85%80%EC%9C%BC%EB%A1%9C-%EC%84%B1%EB%8A%A5-%EC%B5%9C%EC%A0%81%ED%99%94%ED%95%98%EA%B8%B0
//
public class SingletonHelper {
	
	private static Connection conn = null;
	
	private SingletonHelper() {}
	
	//함수....static....Connection 인터페이스 리턴 타입 ...
	public static void getConnection(String dsn) {
		getConnection(dsn, "KOSA", "1004");
	}
	
	public static Connection getConnection(String dsn, String id, String pw) {
		if(conn == null) {
			try {
			if(dsn.equals("oracle")) {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", id, pw);
			}else if(dsn.equals("mariadb")) {
				conn= DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/kosadb",id,pw);
			}
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return conn;
	}
}
