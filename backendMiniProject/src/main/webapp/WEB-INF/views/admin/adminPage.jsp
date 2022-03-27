<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(document).ready(function(){
	$(".tab_title li").click(function(){
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
					tag += "<li>" + vo.userid + " / " + vo.kind;
					tag += " / " + vo.writedate;
					tag += " / " + vo.status + " ";
					
					if("admin" == '${logId}') {
						tag += "<div><form method='post'>";
						tag += "<input type='hidden' name='wantno' value='" + vo.wantno + "'/>"; 
						tag += "<select name='status'>";
						tag += "<option value='none'>--상태--</option>";
						tag += "<option value='접수'>접수</option>";
						tag += "<option value='접수취소'>접수취소</option>";
						tag += "<option value='처리중'>처리중</option>";
						tag += "<option value='처리완료'>처리완료</option>";
						tag += "</select>";
						tag += "<input type='submit' value='수정'/>";
						tag += "</form></div>";
					}
					
					tag += "<br/>" + vo.comment;	
					
					
					tag += "<hr/></li>"
				});
				
				tag +="</ul>";
				
				$("#wantList").html(tag);
			},
			error: function(e) {
				console.log(e.responseText);
			}
		});
	}	
	
	// 수정
	$(document).on('submit', '#wantList form', function(){
		event.preventDefault();
		
		var params = $(this).serialize();
		var url = '/myapp/want/editOk';
		$.ajax({
			url: url,
			data: params,
			type: 'POST',
			success: function(result) {
				wantListAll();
			},
			error: function() {
				console.log(e.responseText);
			}
		});
	});
	
	wantListAll();
});

$(function(){
	function contentListAll() {
		var url = "/myapp/content/list";
		var params = "kind=${vo.kind}";
		$.ajax({
			url: url,
			data: params,
			success: function(result) {
				var $result = $(result);
				
				var tag = "<ul>";
				tag+="<li>번호</li>";
				tag+="<li>분류</li>";
				tag+="<li>제목</li>";
				tag+="<li>평점</li>";
				
				$result.each(function(idx, vo){
					tag += "<li>" + vo.contentno + "</li>";
					tag += "<li>" + vo.kind + "</li>";
					tag += "<li><a href='/myapp/content/contentView?contentno=" + vo.contentno + "'>" + vo.title + "</a></li>";
					tag += "<li>" + vo.totalrating + "</li>";
				});
				
				tag += "</ul>";
				
				$("#contentList").html(tag);
			},
			error: function(e) {
				console.log(e.responseText);
			}
		});
	}
	
	contentListAll();
});


</script>

<style>

.tab_title li.on{
	font-weight:bold;
}
.tab_content>div{
	display: none;
}

.tab_content>div.on{
	display: block;
}

#wantList {
	display: block;
	height: 500px;
}

#wantList>ul>li {
	height: 100px;
}

#contentList {
	display: block;
	height: 500px;
}
#contentList>ul{
	overflow: auto;
}
#contentList>ul>li{
	float:left; height:40px; line-height:40px; border-bottom:1px solid #ddd;
	width:10%;
}
#contentList>ul>li:nth-child(4n+3){
	width: 70%;
	white-space:nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}


</style>
<div class="container">
<h1>관리자메뉴</h1>
	<ul class="tab_title">
		<li >요청</li>
		<li class="on">컨텐츠관리</li>
	</ul>
	
	<hr/><hr/>
	
	<div class="tab_content">
		<div>
			<h3>요청목록</h3>
			<div id="wantList">
			
			</div>
		</div>
		<div class="on">
			<h3>컨텐츠목록</h3>
			<div>
				<a href="/myapp/content/contentWrite">글쓰기</a>
			</div>
			<div id="contentList">
			
			</div>
		</div>
	</div>
</div>