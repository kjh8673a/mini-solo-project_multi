<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${cnt>0 }">
	<script>
		alert("환영합니다!");
		location.href="/myapp/member/loginForm";
	</script>
</c:if>

<c:if test="${cnt==null || cnt==0}">
	<script>
		alert("회원 가입 실패하였습니다.");
		history.go(-1);
	</script>
</c:if>