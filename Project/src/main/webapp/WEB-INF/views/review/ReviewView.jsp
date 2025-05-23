<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>리뷰 상세보기</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/style.css">
</head>
<body>

<section class="content board view list">
    <div class="page_top">
        <div class="inner">
            <!-- 리뷰 제목을 상단에 출력 -->
            <h2 id="pageName">리뷰</h2>
        </div>
    </div>			
    <div class="inner">
        <div class="view_wrap">
            <div class="view_top">
                <h3 class="view_title">${review.review_title}</h3>
                <div class="view_info">
                    <div class="view_info_lt">
                        <p><span>작성자</span> ${review.id}</p>
                        <p><span>조회수</span> ${review.review_views}</p>
                    </div>
                    <div class="view_info_rt">
                        <p><span>작성날짜</span> ${review.created_at}</p>
                    </div>
                </div>
            </div>
            <div class="view_btm">
                ${review.review_content}
                
                <!-- 첨부파일이 있을 경우 표시 -->
                <c:if test="${not empty review.review_file}">
                    <div class="view_file">
                        <a href="${pageContext.request.contextPath}/upload/${review.review_file}" download>${review.review_file}</a>
                    </div>
                </c:if>
            </div>
        </div>
        
        <!-- 관리자 답변 영역 -->
        <div class="admin_answer">
            <h4>댓글</h4>
            <c:choose>
                <c:when test="${not empty answer}">
                    <p>${answer.cmt_content}</p>
                    <p>작성자: ${answer.id}</p>

                    <!-- 관리자만 수정/삭제 가능 -->
                    <c:if test="${sessionScope.mvo.user_type eq 'ADMIN'}">
                        <form action="${pageContext.request.contextPath}/updateReviewAnswer?id=${mvo.id}" method="post">
                            <textarea name="cmt_content">${answer.cmt_content}</textarea>
                            <input type="hidden" name="cmt_idx" value="${answer.cmt_idx}" />
                            <input type="hidden" name="review_idx" value="${review.review_idx}" />
                            <input class="bttn " type="submit" value="수정">		
                        </form>
                        <form action="${pageContext.request.contextPath}/deleteReviewAnswer?id=${mvo.id}" method="post">
						    <input type="hidden" name="cmt_idx" value="${answer.cmt_idx}" />
						    <input type="hidden" name="review_idx" value="${review.review_idx}" />
						    <input class="bttn" type="submit" value="삭제">		
						</form>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <c:if test="${sessionScope.mvo.user_type eq 'ADMIN'}">
                        <form action="${pageContext.request.contextPath}/writeReviewAnswer?id=${mvo.id}" method="post">
                            <textarea name="cmt_content" placeholder="답변 내용을 작성하세요."></textarea>
                            <input type="hidden" name="review_idx" value="${review.review_idx}" />
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

