<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/myapp/js/myPage.js"></script>
<script>

</script>
<style>

.tab_title li.on{
	font-weight:bold;
}
.tab_content div{
	display: none;
}

.tab_content div.on{
	display: block;
}

</style>
<div class="container">
<h1>${logId} 마이페이지</h1>
	<ul class="tab_title">
		<li class="on">요청</li>
		<li>회원정보수정</li>
	</ul>
	<div class="tab_content">
		<div class="on">
			<!-- 댓글쓰기 -->
			<form method='post' id="wantFrm">
				<select name="kind" id="kind">	
					<option value="none">--분류--</option>				
					<option value="movie">영화</option>
                    <option value="book">책</option>
				</select>
				<textarea name="comment" id='comment' style="width:500px; height:80px;"></textarea>
				<input type="submit" value="댓글등록"/>
			</form>
			
			<!-- 댓글목록이 나올 자리 -->
			<div id="wantList">
			
			</div>
		</div>
		
		<div>
			<h3>회원정보수정</h3>
		</div>
	</div>

</div>