<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%
    // 세션에서 로그인 사용자 정보 가져오기
    com.smhrd.member.MemberVO mvo = (com.smhrd.member.MemberVO) session.getAttribute("mvo");
    String userName = (mvo != null) ? mvo.getName() : "비회원";
    String userId = (mvo != null) ? mvo.getId() : "Guest";
    String profileImg = (mvo != null && mvo.getProfile_img() != null && !mvo.getProfile_img().equals("null")) 
                        ? "../resources/file/"+mvo.getProfile_img() : "../resources/images/user.png";
%>

<section class="content">
    <div class="page_top">
        <div class="inner">
            <h2 class="pageName">마이페이지</h2>
        </div>
    </div>
    <div class="inner pdx">
        <div class="mypage">
            <div class="mp_nav">
                <div class="mp_profile">
                    <div class="thumb">
                        <img src="<%=profileImg%>" alt="프로필 이미지" />
                    </div>
                    <ul class="txt">
                        <!-- 이름 -->
                        <p><%=userName%></p>
                        <!-- 아이디 -->
                        <small><%=userId%></small>
                    </ul>
                </div>
                <ul class="mp_menu">
                    <li>
                        <a href="#">내 갤러리</a>
                    </li>                   
                    <li>
                        <a href="#">내 게시글</a>                   
                    </li>
                    <li>
                        <a href="/mypage/My_edit">회원정보수정</a>
                    </li>
                </ul>
            </div>
            <div class="mp_cont">
                <div class="no_content">
                    <p>아직 클로킹한 이미지가 없습니다.</p>
                </div>
            </div>
        </div>
    </div>
</section>    

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
