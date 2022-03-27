<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<h1>글내용보기</h1>
	<ul>
		<li>번호 : ${vo.contentno}</li>
		<li>분류 : ${vo.kind}</li>
		<li>제목 : ${vo.title}</li>
		<li>만든사람 : ${vo.madeby}</li>
		<li>평점 : ${vo.totalrating}</li>
		<li>글내용</li>
		<li>${vo.detail}</li>
	</ul>
	
</div>