<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(function(){
	function ratingListAll() {
		var url = "/myapp/rating/list";
		var params = "contentno=${vo.contentno}";
		$.ajax({
			url: url,
			data: params,
			success: function(result) {
				var $result = $(result);
				
				var tag = "<ul>";
				
				$result.each(function(idx, vo){
					if(vo.userid == '${logId}') {
						tag += "<li>" + vo.userid;
						tag += " / " + vo.myrating;
						tag += "<hr/></li>";
					}
				});
				
				tag +="</ul>";
				
				$("#ratingList").html(tag);
			},
			error: function(e) {
				console.log(e.responseText);
			}
		});
	}
	ratingListAll();
});
$("#ratingFrm").submit(function(){
	event.preventDefault();
	if(!$('input:radio[name=myrating]').is(":checked")) {
		alert("선택후 등록하세요.");
		return;
	}else {
		var params = "contentno=${vo.contentno}";
		
		$.ajax({
			url: '/myapp/rating/ratingOk',
			contentType: 'application/json',
			data: {
				contentno : ${vo.contentno}
			},
			type: 'POST',
			success: function(r){
				$("#myrating").val("");
				ratingListAll();
			},
			error: function(e){
				console.log(e.responseText);
			}
		});
	}
});

</script>
<style>
#ratingList {
	display: block;
	height: 500px;
}

#ratingList>ul>li {
	height: 50px;
}
</style>
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
	<c:if test="${logStatus=='Y'}">
		<form method='post' id="ratingFrm" action="/myapp/rating/ratingOk">
			<input type="hidden" id="contentno" name="contentno" value="${vo.contentno}" />
			<input type='radio' name='myrating' id='r1' value='1'/>
			<label for='r1'>1</label>
			<input type='radio' name='myrating' id='r2' value='2'/>
			<label for='r2'>2</label>
			<input type='radio' name='myrating' id='r3' value='3'/>
			<label for='r3'>3</label>
			<input type='radio' name='myrating' id='r4' value='4'/>
			<label for='r4'>4</label>
			<input type='radio' name='myrating' id='r5' value='5'/>
			<label for='r5'>5</label>
			<input type='radio' name='myrating' id='r6' value='6'/>
			<label for='r6'>6</label>
			<input type='radio' name='myrating' id='r7' value='7'/>
			<label for='r7'>7</label>
			<input type='radio' name='myrating' id='r8' value='8'/>
			<label for='r8'>8</label>
			<input type='radio' name='myrating' id='r9' value='9'/>
			<label for='r9'>9</label>
			<input type='radio' name='myrating' id='r10' value='10'/>
			<label for='r10'>10</label>
			<input type="submit" value="등록">
		</form>
	</c:if>
	
	<div id="ratingList">
	
	</div>
	
	
</div>