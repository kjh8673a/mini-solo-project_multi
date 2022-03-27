<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(function(){
	function contentListAll() {
		var url = "/myapp/content/movieList";
		$.ajax({
			url: url,
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
					tag += "<li><a href='/myapp/content/contentsView?contentno=" + vo.contentno + "'>" + vo.title + "</a></li>";
					tag += "<li>" + vo.totalrating + "</li>";
				});
				
				tag += "</ul>";
				
				$("#movieList").html(tag);
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
#movieList {
	display: block;
	height: 500px;
}
#movieList>ul{
	overflow: auto;
}
#movieList>ul>li{
	float:left; height:40px; line-height:40px; border-bottom:1px solid #ddd;
	width:10%;
}
#movieList>ul>li:nth-child(4n+3){
	width: 70%;
	white-space:nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
<div class="container">
	
	<h3>MOVIE</h3>
	<div id="movieList">
			
	</div>
</div>