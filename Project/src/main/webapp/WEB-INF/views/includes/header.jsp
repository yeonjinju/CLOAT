<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="k">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CLOAT, 이미지 클로킹 서비스</title>

<!-- summernote 에디터 cdn, css 충돌 위험 가능하면 에디터 사용 페이지에서만 추가되도록-->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>	 
<!-- summernote 에디터 cdn, css 충돌 위험 가능하면 에디터 사용 페이지에서만 추가되도록-->

<link rel="stylesheet" href="resources/assets/css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>

<body>
   <header class="header">
      <div class="inner">
         <h1 class="logo">
            <a href="index.html"><img src="resources/images/logo.svg" alt=""></a>
         </h1>
         <ul class="depth">
            <li>
               <a href="">CLOAT</a>
               <ul class="depth2">
                  <li><a href="">개요</a></li>
                  <li><a href="">팀 소개</a></li>
                  <li><a href="">비전</a></li>
                  <li><a href="">오시는 길</a></li>
               </ul>
            </li>
            <li>
               <a href="">서비스</a>
            </li>
            <li>
               <a href="ReviewList">고객후기</a>
            </li>
            <li>
               <a href="">고객지원</a>
               <ul class="depth2">
                  <li><a href="NoticeList">공지사항</a></li>
                  <li><a href="NewsList">뉴스</a></li>
                  <li><a href="QnaList">고객문의</a></li>
                  <li><a href="map">도움기관 지도</a></li>
               </ul>
            </li>
         </ul>
         <div class="hd_util">
            <a href="join">회원가입</a>
            <a href="login">로그인</a>
         </div>
      </div>
   </header>