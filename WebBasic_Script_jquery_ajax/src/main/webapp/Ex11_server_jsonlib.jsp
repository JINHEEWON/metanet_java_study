<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosa.dto.Member"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//java 객체 json 데이터 변환
	// 1. JSONObject 사용 > { } json객체 하나
	// 2. JSONArray  사용 > [{},{},{}] 생성
	
	Member member = new Member();
	JSONObject obj = JSONObject.fromObject(member);
	//{"address":"서울시 강남구","admin":"1","password":"1004","username":"kosa"}
	
	
%>
<%=obj %>
<hr>
<%
	List<Member> list = new ArrayList<>();
	list.add(new Member("hong","1004","서울시 강남구","0"));
	list.add(new Member("kim","1004","서울시 강남구","1"));
	list.add(new Member("park","1004","서울시 강남구","0"));
	
	JSONArray memberarray = JSONArray.fromObject(list);
	
/* [{"address":"서울시 강남구","admin":"0","password":"1004","username":"hong"},{"address":"서울시 강남구","admin":"1","password":"1004","username":"kim"},{"address":"서울시 강남구","admin":"0","password":"1004","username":"park"}] */

%>
<%=memberarray %>