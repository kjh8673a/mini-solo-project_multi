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
				},
				error: function(e){
					console.log(e.responseText);
				}
			});
		}
	});
	// 댓글등록(end)
	
	
});
