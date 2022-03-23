<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/myapp/css/loginForm.css" type="text/css"/>
<script src="/myapp/js/loginForm.js"></script>


<div class="container">
	<div id="loginBox">
		<div>
			<h1>로그인</h1>
			처음이십니까? <b><a href="/myapp/member/registerForm" style="text-decoration: none;">회원 가입</a></b>
            
		</div>
		<div>
			<form method="post" action="/myapp/member/loginOk" id="logFrm" onsubmit="return logFormCheck()">
				<ul>
					<li>아이디</li>
					<li><input type="text" name="userid" id="userid" placeholder="아이디"/></li>
					<li><span class="loginError"></span></li>
					
					<li>비밀번호</li>
					<li><input type="password" name="userpwd" id="userpwd" placeholder="비밀번호"/></li>
					<li><span class="loginError"></span></li>
					
					<li><input type="submit" id="loginbtn" value="로그인"/></li>
				</ul>
			</form>
		</div>
	</div>
</div>
