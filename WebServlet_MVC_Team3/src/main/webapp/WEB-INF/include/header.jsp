<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<div id="header">
            <div class="title">
                <a href="${pageContext.request.contextPath}/index.meta">DEMO WEBSITE</a>
            </div>
            <div class="links">
                <a href="#">${pageContext.request.contextPath}/index.meta</a>
                <a href="#">추후등록</a>
                <a href="#">추후로그아웃</a>

            </div>
        </div>       
        <div id="menu">
            <div>
                <ul>
                	<!-- a : 페이지 이동을 처리하는 마크업 -->
                    <li><a href="${pageContext.request.contextPath}/board_list.meta">BOARD LIST</a></li>
					<li><a href="${pageContext.request.contextPath}/board_write.meta">BOARD WRITE</a></li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
                </ul>
            </div>
        </div>
        <div style="text-align:right;margin-top:1px;
        	border:solid 1px;padding:5px">
        	[ TOTAL : 명 ]
        	[ CURRENT : 명 ]
        </div>
        
        
        
        
        
        
        
        
        
        
        
        