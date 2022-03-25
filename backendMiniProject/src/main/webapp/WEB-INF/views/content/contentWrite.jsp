<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="//cdn.ckeditor.com/4.17.2/standard/ckeditor.js"></script>
<script>
	$(function(){
		CKEDITOR.replace("detail");
		
		$("#contentFrm").submit(function(){
			
			if($("#kind").val()=="none"){
				alert("분류를 선택하세요");
				return false;
			}
			if($("#title").val()==""){
				alert("제목을 입력하세요");
				return false;
			}
			if($("#madeby").val()==""){
				alert("만든사람을 입력하세요");
				return false;
			}
			if(CKEDITOR.instances.detail.getData()==""){
				alert("상세정보를 입력하세요");
				return false;
			}
		});
	});

</script>

<div class="container">
	<h2>컨텐츠 등록</h2>
	<form method="post" action="/myapp/content/contentWriteOk" id="contentFrm">
		<ul>
			<li>분류</li>
			<li>
				<select name="kind" id="kind">
					<option value="none">--분류--</option>
					<option value="영화">영화</option>
					<option value="책">책</option>
				</select>
			</li>
			<li>제목</li>
			<li><input type="text" name="title" id="title"/></li>
			<li>만든사람</li>
			<li><input type="text" name="madeby" id="madeby"/></li>
			<li>상세정보</li>
			<li><textarea name="detail" id="detail"></textarea></li>
			<li><input type="submit" value="등록"/></li>
		</ul>
		
	</form>
		
</div>