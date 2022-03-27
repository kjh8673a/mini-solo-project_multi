<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(document).ready(function() {
	$(".tab_title li").click(function() {
		var idx = $(this).index();
		$(".tab_title li").removeClass("on");
		$(".tab_title li").eq(idx).addClass("on");
		$(".tab_content>div").hide();
		$(".tab_content>div").eq(idx).show();
	});
});
$(function(){
	// 댓글목록
	function wantListAll() {
		var url = "/myapp/want/list";
		var params = "userid=${vo.userid}";
		$.ajax({
			url: url,
			data: params,
			success: function(result) {
				var $result = $(result);
				
				var tag = "<ul>";
				
				$result.each(function(idx, vo){
					if(vo.userid == '${logId}') {
						tag += "<li>" + vo.userid + " / " + vo.kind;
						tag += " / " + vo.writedate;
						tag += " / " + vo.status;
						tag += "<br/>" + vo.comment;
						tag += "<hr/></li>";
					}
				});
				
				tag +="</ul>";
				
				$("#wantList").html(tag);
			},
			error: function(e) {
				console.log(e.responseText);
			}
		});
	}
	
	// 댓글등록
	$("#wantFrm").submit(function(){
		event.preventDefault();
		if($("#kind").val()=="none") {
			alert("분류를 선택후 등록하세요.");
			return;
		}else if($("#comment").val()=="") {
			alert("댓글을 입력후 등록하세요.");
			return;
		}else {
			var params = $("#wantFrm").serialize();
			
			$.ajax({
				url: '/myapp/want/writeOk',
				data: params,
				type: 'POST',
				success: function(r){
					$("#comment").val("");
					wantListAll();
				},
				error: function(e){
					console.log(e.responseText);
				}
			});
		}
	});
	// 댓글등록(end)
	
	wantListAll();
});


// myList
$(function(){
	function myListAll() {
		var url = "/myapp/content/myList";
		$.ajax({
			url: url,
			success: function(result) {
				var $result = $(result);
				
				var tag = "<ul>";
				tag+="<li>번호</li>";
				tag+="<li>분류</li>";
				tag+="<li>제목</li>";
				tag+="<li>내 평점</li>";
				
				$result.each(function(idx, vo){
					if(vo.userid == '${logId}') {
						tag += "<li>" + vo.contentno + "</li>";
						tag += "<li>" + vo.kind + "</li>";
						tag += "<li><a href='/myapp/content/contentsView?contentno=" + vo.contentno + "'>" + vo.title + "</a></li>";
						tag += "<li>" + vo.myrating + "</li>";
					}
				});
				
				tag += "</ul>";
				
				$("#myList").html(tag);
			},
			error: function(e) {
				console.log(e.responseText);
			}
		});
	}
	
	myListAll();
});
</script>
<style>
.tab_title li.on{
	font-weight: bold;
}
.tab_content>div{
	display: none;
}

.tab_content>div.on{
	display: block;
}
#wantList, #myList {
	display: block;
	height: 500px;
}

#wantList>ul>li {
	height: 50px;
}

#myList {
	display: block;
	height: 500px;
}
#myList>ul{
	overflow: auto;
}
#myList>ul>li{
	float:left; height:40px; line-height:40px; border-bottom:1px solid #ddd;
	width:10%;
}
#myList>ul>li:nth-child(4n+3){
	width: 70%;
	white-space:nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
<div class="container">
<h1>${logId} 마이페이지</h1>
	<ul class="tab_title">
		<li >요청</li>
		<li class="on">내 컨텐츠</li>
	</ul>
	
	<hr/><hr/>
	
	<div class="tab_content">
		<div >
			<!-- 댓글쓰기 -->
			<form method='post' id="wantFrm">
				<select name="kind" id="kind">	
					<option value="none">--분류--</option>				
					<option value="영화">영화</option>
	                <option value="책">책</option>
				</select>
				<input type="hidden" name="wantno" value="${vo.wantno}"/>
				<textarea name="comment" id='comment' style="width:500px; height:80px;"></textarea>
				<input type="submit" value="댓글등록"/>
			</form>		
			
			<!-- 댓글목록이 나올 자리 -->
			<div id="wantList">
			
			</div>
		</div>
		
		<div class="on">
			<h3>MY CONTENTS</h3>
			
			<div id="myList">
			
			</div>
		</div>
	</div>

</div>