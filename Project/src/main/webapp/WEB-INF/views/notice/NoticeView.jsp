<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>공지사항 상세보기</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/style.css">
</head>
<body>

<section class="content board view list">
    <div class="page_top">
        <div class="inner">
            <!-- 공지사항 제목을 상단에 출력 -->
            <h2 id="pageName">${bvo.notice_title}</h2>
        </div>
    </div>			
    <div class="inner">
        <div class="view_wrap">
            <div class="view_top">
                <h3 class="view_title">${bvo.notice_title}</h3>
                <div class="view_info">
                    <div class="view_info_lt">
                        <p><span>작성자</span> ${bvo.notice_writer}</p>
                        <p><span>조회수</span> ${bvo.notice_views}</p>
                    </div>
                    <div class="view_info_rt">
                        <p><span>작성날짜</span> ${bvo.notice_date}</p>
                    </div>
                </div>
            </div>
            <div class="view_btm">
                ${bvo.notice_content}
                
                <!-- 첨부파일이 있을 경우 표시 -->
                <c:if test="${not empty bvo.notice_file}">
                    <div class="view_file">
                        <a href="${pageContext.request.contextPath}/upload/${bvo.notice_file}" download>${bvo.notice_file}</a>
                    </div>
                </c:if>
            </div>
        </div>				
        <div class="btn_wrap">
            <!-- 해당 글 작성자 또는 관리자일 경우 버튼 표시 -->
            <c:if test="${sessionScope.userId eq bvo.notice_writer || sessionScope.userRole eq 'admin'}">
                <button onClick="location.href='NoticeEdit.jsp?no=${bvo.notice_no}'" class="btn">수정</button>
                <button onClick="location.href='NoticeDelete.jsp?no=${bvo.notice_no}'" class="btn">삭제</button>
            </c:if>
            <button onClick="javascript:history.back()" class="btn ipt_sbm">목록</button>
        </div>				
    </div>	
</section>

</body>
</html>
