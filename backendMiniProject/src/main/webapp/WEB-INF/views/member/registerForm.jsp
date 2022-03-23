<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/myapp/css/registerForm.css" type="text/css"/>
<script src="/myapp/js/registerForm.js"></script>

<div class="container">
		<div id="regBox">
		<div>
			<h1>환영합니다</h1>
			이미 계정이 있으십니까? <b><a href="/myapp/member/loginForm" style="text-decoration: none;">로그인</a></b>
		</div>
		<div>
			<form method="post" action="/myapp/member/registerOk" id="regFrm" onsubmit="return registerCheck()">
				<ul>
					<li>아이디</li>
					<li><input type="text" name="userid" id="userid" placeholder="아이디" /></li>
					<li><span class="regError"></span></li>
					
					<li>비밀번호</li>
					<li><input type="password" name="userpwd" id="userpwd" placeholder="비밀번호"/></li>
					<li><span class="regError"></span></li>
					
					<li>비밀번호 재확인</li>
					<li><input type="password" name="userpwd2" id="userpwd2" placeholder="비밀번호 재확인"/></li>
					<li><span class="regError"></span></li>
					
					<li>이름</li>
					<li><input type="text" name="username" id="username" placeholder="이름"/></li>
					<li><span class="regError"></span></li>
					
					<li>생년월일</li>
					<li>
						<input type="text" name="birthdate1" id="birthdate1" placeholder="년(4자)"/>
						<select name="birthdate2" id="birthdate2">
                            <option value="none">--월--</option>
                            <option value="01">1</option>
                            <option value="02">2</option>
                            <option value="03">3</option>
                            <option value="04">4</option>
                            <option value="05">5</option>
                            <option value="06">6</option>
                            <option value="07">7</option>
                            <option value="08">8</option>
                            <option value="09">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                        <input type="text" name="birthdate3" id="birthdate3" placeholder="일"/>
					</li>
					<li><span class="regError"></span></li>
					
					<li>성별</li>
					<li>
						<select name="gender" id="gender">
                        	<option value="none">--성별--</option>
                            <option value="male">남자</option>
                            <option value="female">여자</option>
                            <option value="other">선택안함</option>
                        </select>
					</li>
					<li><span class="regError"></span></li>
					
					<li>MBTI</li>
					<li>
						<select name="mbti" id="mbti">
                        	<option value="none">--MBTI--</option>
                            <option value="ISTJ">ISTJ</option>
                            <option value="ISFJ">ISFJ</option>
                            <option value="INFJ">INFJ</option>
                            <option value="INTJ">INTJ</option>
                            <option value="ISTP">ISTP</option>
                            <option value="ISFP">ISFP</option>
                            <option value="INFP">INFP</option>
                            <option value="INTP">INTP</option>
                            <option value="ESTP">ESTP</option>
                            <option value="ESFP">ESFP</option>
                            <option value="ENFP">ENFP</option>
                            <option value="ENTP">ENTP</option>
                            <option value="ESTJ">ESTJ</option>
                            <option value="ESFJ">ESFJ</option>
                            <option value="ENFJ">ENFJ</option>
                            <option value="ENTJ">ENTJ</option>
                    	</select>
                	</li>
                	<li><span class="regError"></span></li>
                	<li><a href="#">MBTI 확인하러 가기</a></li>
                	<li><input type="submit" id="registerbtn" value="가입하기"/></li>
				</ul>
			</form>
		</div>
	</div>
</div>