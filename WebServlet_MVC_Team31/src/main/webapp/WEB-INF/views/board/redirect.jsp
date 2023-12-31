<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="msg" value="${requestScope.board_msg}" />
<c:set var="url" value="${requestScope.board_url}" />

<c:if test="${not empty msg and not empty url}">
    <script>
        alert('${msg}');
        location.href='${pageContext.request.contextPath}/${url}';;
    </script>
</c:if>