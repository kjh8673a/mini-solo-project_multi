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
<h1>관리자메뉴</h1>
	<ul class="tab_title">
		<li class="on">요청</li>
		<li>영화</li>
		<li>책</li>
	</ul>
	<div class="tab_content">
		<div class="on">
			tab1
		</div>
		<div>
			tab2
		</div>
		<div>
			tab3
		</div>
	</div>

</div>