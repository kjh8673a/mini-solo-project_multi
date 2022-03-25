<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %> 
<style>
#mainSearch {
	height: 500px;
	border-bottom: 1px solid #ddd;
	text-align: center;
	margin-top: 50px;
}
#mainSearch>img {
	width: 600px;
	margin-bottom: 25px;
}

#searchBox {
	margin: 0 auto;
	width: 500px;
	height: 40px;
	border: 1px solid #1b5ac2;
	background-color: #fff;
}
#searchWord {
	font-size: 16px;
	width: 400px;
	padding: 10px;
	border: 0px;
	outline: none;
	float: left;
}
#searchbtn {
	width: 75px;
	height: 40px;
	border: 0px;
	ouline: none;
	float: right;
	background-color: #1b5ac2;
	color: #fff;
}
</style>

<div class="container">
	<div id="mainSearch">
		<img src="<spring:url value='/img/err.jpg'/>">
		<div id="searchBox">
			<form id="searchFrm">
				<input type="text" name="searchWord" id="searchWord" placeholder="검색어 입력" />
				<input type="submit" id="searchbtn" value="검색" />
			</form>
		</div>
	</div>
</div>