<%@page import="kr.or.bit.dto.Reply"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.bit.dto.Board"%>
<%@page import="kr.or.bit.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<% pageContext.setAttribute("LF", "\n"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board_content</title>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link rel="Stylesheet" href="${pageContext.request.contextPath}/style/default.css" />
</head>
<body>
	<c:import url="/WEB-INF/include/header.jsp" />
	<div id="pageContainer">
		<div style="padding-top: 30px; text-align: center">
			<center>
				<b>게시판 글내용</b>
				<table width="80%" border="1">
					<tr>
						<td width="20%" align="center"><b> 글번호 </b></td>
						<td width="30%">${requestScope.idx}</td>
						<td width="20%" align="center"><b>작성일</b></td>
						<td>${requestScope.board.getWritedate()}</td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>글쓴이</b></td>
						<td width="30%">${requestScope.board.getWriter()}</td>
						<td width="20%" align="center"><b>조회수</b></td>
						<td>${requestScope.board.getReadnum()}</td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>홈페이지</b></td>
						<td>${requestScope.board.getHomepage()}</td>
						<td width="20%" align="center"><b>첨부파일</b></td>
						<td>${requestScope.board.getFilename()}</td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>제목</b></td>
						<td colspan="3">${requestScope.board.getSubject()}</td>
					</tr>
					<tr height="100">
						<td width="20%" align="center"><b>글내용</b></td>
						<td colspan="3">

						<c:if test="${not empty requestScope.board.content}">
							${fn:replace(requestScope.board.content, LF, '<br>')}
						</c:if>

						</td>
					</tr>
					<tr>
						<td colspan="4" align="center">
						<a href="${pageContext.request.contextPath}/board_list.meta?cp=${requestScope.cpage}&ps=${requestScope.pagesize}">목록가기</a> |
						<a href="${pageContext.request.contextPath}/board_edit.meta?idx=${param.idx}&cp=${requestScope.cpage}&ps=${requestScope.pagesize}">편집</a>	|
						<a href="${pageContext.request.contextPath}/board_delete.meta?idx=${param.idx}&cp=${requestScope.cpage}&ps=${requestScope.pagesize}">삭제</a> |
						<a href="${pageContext.request.contextPath}/board_rewrite.meta?idx=${param.idx}&cp=${requestScope.cpage}&ps=${requestScope.pagesize}&subject=${requestScope.board.getSubject().replace("[", "%5B").replace("]","%5D")}">답글</a>
						</td>
					</tr>
				</table>
				<!--  꼬리글 달기 테이블 -->
				<form name="reply">
						<!-- hidden 태그  값을 숨겨서 처리  -->
						<input type="hidden" name="idx" value="${requestScope.idx}"> 
						<input type="hidden" name="userid" value=""><!-- 추후 필요에 따라  -->
						<!-- hidden data -->
						<table width="80%" border="1">
							<tr>
								<th colspan="2">덧글 쓰기</th>
							</tr>
							<tr>
								<td align="left">작성자 :
								 	<input type="text" name="reply_writer"><br /> 
								 	내&nbsp;&nbsp;용 : 
								 	<textarea name="reply_content" rows="2" cols="50"></textarea>
								</td>
								<td align="left">
									비밀번호:
									<input type="password" name="reply_pwd" size="4"> 
									<input type="button" value="등록" onclick="reply_check()">
								</td>
							</tr>
						</table>
				</form>
				<!-- 유효성 체크	 -->
				<script type="text/javascript">
					$(function () {
						getCommentListAsync();
					});
					function getCommentListAsync() {
						const urlParams = new URL(location.href).searchParams;
						let idx = urlParams.get("idx");

						$.ajax({
							url: "${pageContext.request.contextPath}/WriteReplyServlet?idx=" + idx, // 여기에 서블릿 URL을 입력하세요.
							type: 'GET', // 또는 'POST' 등 요청 메서드를 선택합니다.
							dataType: "json",
							success: function (data) {

								$.each(data, function (index, obj) {
									addComment(obj.writer, obj.content, obj.writedate, obj.no, obj.idx_fk);
								});
							},
							error: function (xhr, status, error) {
								// 오류가 발생한 경우 처리합니다.
								alert("덧글불러오기에 실패했습니다.");
							}
						});
					}
					function reply_check() {
						var frm = document.reply;
						if (frm.reply_writer.value == "" || frm.reply_content.value == ""
								|| frm.reply_pwd.value == "") {
							alert("리플 내용, 작성자, 비밀번호를 모두 입력해야합니다.");
							return false;
						}
						resetTable();
						const urlParams = new URL(location.href).searchParams;
						let p = {"idx": urlParams.get("idx"),"reply_writer": frm.reply_writer.value,"reply_content": frm.reply_content.value, "reply_pwd": frm.reply_pwd.value};
						$.ajax({
							url: "${pageContext.request.contextPath}/WriteReplyServlet", // 여기에 서블릿 URL을 입력하세요.
							type: "POST", // 또는 'POST' 등 요청 메서드를 선택합니다.
							data: p,
							dataType: "json",
							success: function(data) {

								$.each(data, function (index, obj) {
									addComment(obj.writer, obj.content, obj.writedate, obj.no, obj.idx_fk);
								});
							},
							error: function(xhr, status, error) {
								// 오류가 발생한 경우 처리합니다.
								alert("덧글입력에 실패했습니다.")
							}
						});
						//frm.submit();
						frm.reply_writer.value = "";
		                frm.reply_content.value = "";
		                frm.reply_pwd.value = "";
					}
					function resetTable() {
						$("#dynamicComments").empty();

					}
					function reply_del(frm) {
						// alert("del");
						// var frm = document.replyDel;
						// alert(frm);
						if (frm.delPwd.value == "") {
							alert("비밀번호를 입력하세요");
							frm.delPwd.focus();
							return false;
						}

						const urlParams = new URL(location.href).searchParams;
						let p = {"idx": urlParams.get("idx"),"no": frm.no.value,"delPwd": frm.delPwd.value};
						$.ajax({
							url: "${pageContext.request.contextPath}/DelReplyServlet", // 여기에 서블릿 URL을 입력하세요.
							type: "POST", // 또는 'POST' 등 요청 메서드를 선택합니다.
							data: p,
							// dataType: "json",
							success: function(data) {
								resetTable();
								getCommentListAsync();
							},
							error: function(xhr, status, error) {
								// 오류가 발생한 경우 처리합니다.
								alert('덧글삭제에 실패했습니다.');
								resetTable();
								getCommentListAsync();
							}
						});
					}
					///////////////////////////////
					function addComment(writer, content, writedate, no, idx_fk) {
						// 동적으로 댓글 행을 생성하고 추가
						var dynamicCommentsContainer = $("#dynamicComments");

						var newRow = $("<tr>").attr("align", "left");

						var newCell1 = $("<td>").attr("width", "80%").html("[" + writer + "]" + ":" + content + "<br>작성일:" + writedate);

						var newCell2 = $("<td>").attr("width", "20%");
						var deleteForm = $("<form>").attr({
							action: "boardreply_deleteOk.jsp",
							method: "POST",
							name: "replyDel"
						});

						var hiddenNo = $("<input>").attr({
							type: "hidden",
							name: "no",
							value: no // 새로운 댓글의 번호 (필요에 따라 수정)
						});
						deleteForm.append(hiddenNo);

						var hiddenIdx = $("<input>").attr({
							type: "hidden",
							name: "idx",
							value: idx_fk // 게시글의 번호 (필요에 따라 수정)
						});
						deleteForm.append(hiddenIdx);

						var passwordInput = $("<input>").attr({
							type: "password",
							name: "delPwd",
							size: "4"
						});

						// "password:" 라벨 추가
						var passwordLabel = $("<label>").html("password:");
						deleteForm.append(passwordLabel);

						deleteForm.append(passwordInput);

						var deleteButton = $("<input>").attr({
							type: "button",
							value: "삭제"
						}).click(function() {
							reply_del(this.form);
						});
						deleteForm.append(deleteButton);

						newCell2.append(deleteForm);

						newRow.append(newCell1, newCell2);
						dynamicCommentsContainer.append(newRow);
					}
				</script>
				<br>
				<!-- 꼬리글 목록 테이블 -->

				<table width="80%" border="1">
					<tr>
						<th colspan="2">REPLY LIST</th>
					</tr>
					<tbody id="dynamicComments">

					</tbody>

				</table>
			</center>
		</div>
	</div>
</body>
</html>





