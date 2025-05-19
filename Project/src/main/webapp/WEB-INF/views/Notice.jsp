
<%@include file="./includes/header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="jumbotron text-center">
	<h1>공지사항 게시판 입니다.</h1>
	<p>문의사항 내용 문희는 포도가 먹고시푼뎅~</p>
</div>
<div class="container">
	<div class="panel panel-default">
		<div class="panel-body">
			<table class="table table-bordered" border="1">
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
				</tr>
				<c:forEach items="${list}" var="bvo">

					<tr>
						<td>${bvo.qna_idx}</td>
						<td>${bvo.qna_title}</td>
						<td>${bvo.id}</td>
						<td>${bvo.created_at}</td>
					</tr>
				</c:forEach>
				<c:if test="${empty list}">
					<p>게시물이 없습니다.</p>
				</c:if>
			</table>
	</div>
</div>
<%@include file="./includes/footer.jsp"%>