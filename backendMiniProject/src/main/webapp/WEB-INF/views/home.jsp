<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %> 
<style>
#mainMain {
	height: 500px;
	border-bottom: 1px solid #ddd;
	text-align: center;
	margin-top: 50px;
}
#mainMain>img {
	width: 600px;
	margin-bottom: 25px;
}

</style>

<div class="container">
	<div id="mainMain">
		<img src="<spring:url value='/img/err.jpg'/>">
	</div>
</div>