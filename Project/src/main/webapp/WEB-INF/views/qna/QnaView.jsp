<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>고객문의 상세보기</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/style.css">
</head>
<body>

<section class="content board view list">
    <div class="page_top">
        <div class="inner">
            <h2 id="pageName">고객문의</h2>
        </div>
    </div>
    <div class="inner">
        <div class="view_wrap">
            <div class="view_top">
                <h3 class="view_title">${qna.qna_title}</h3>
                <div class="view_info">
                    <div class="view_info_lt">
                        <p><span>작성자</span> ${qna.id}</p>
                        <p><span>조회수</span> ${qna.qna_views}</p>
                    </div>
                    <div class="view_info_rt">
                        <p><span>작성날짜</span> ${qna.created_at}</p>
                    </div>
                </div>
            </div>
            <div class="view_btm">
                ${qna.qna_content}
                
                
                <c:if test="${not empty qna.qna_file}">
                    <div class="view_file">
                        <a href="${pageContext.request.contextPath}/upload/${qna.qna_file}" download>${qna.qna_file}</a>
                    </div>
                </c:if>
            </div>
        </div>

        <!-- 관리자 답변 영역 -->
        <div class="admin_answer">
            <h4>댓글</h4>
            <c:choose>
                <c:when test="${not empty answer}">
                    <p>${answer.answer_content}</p>
                    <p>작성자: ${answer.admin_id}</p>

                    <!-- 관리자만 수정/삭제 가능 -->
                    <c:if test="${sessionScope.mvo.user_type eq 'ADMIN'}">
                        <form action="${pageContext.request.contextPath}/updateQnaAnswer?id=${mvo.id}" method="post">
                            <textarea name="answer_content">${answer.answer_content}</textarea>
                            <input type="hidden" name="answer_idx" value="${answer.answer_idx}" />
                            <input type="hidden" name="qna_idx" value="${qna.qna_idx}" />
                            <input class="bttn " type="submit" value="수정">		
                        </form>
                        <form action="${pageContext.request.contextPath}/deleteQnaAnswer?id=${mvo.id}" method="post">
						    <input type="hidden" name="answer_idx" value="${answer.answer_idx}" />
						    <input type="hidden" name="qna_idx" value="${qna.qna_idx}" />
						    <input class="bttn" type="submit" value="삭제">		
						</form>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <c:if test="${sessionScope.mvo.user_type eq 'ADMIN'}">
                        <form action="${pageContext.request.contextPath}/writeQnaAnswer?id=${mvo.id}" method="post">
                            <textarea name="answer_content" placeholder="답변 내용을 작성하세요."></textarea>
                            <input type="hidden" name="qna_idx" value="${qna.qna_idx}" />
                            <input class="bttn " type="submit" value="등록">		
                        </form>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</section>
</body>
</html>
