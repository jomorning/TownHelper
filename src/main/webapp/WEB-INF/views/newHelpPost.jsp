<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>

	<c:url value="/help-posts" var="submitNewHelpPost" />
	<form:form modelAttribute="newHelpPost" action="${submitNewHelpPost}"
		enctype="multipart/form-data">

		<form:input path="helpCategory" placeholder="예) 이삿짐 나르기, 과외, 반려동물 돌봄" /><br>
		<form:input path="postAddrGu" placeholder="예) XX구" /><br>
		<form:input path="postAddrDong" placeholder="예) XX동" /><br>
		<form:input path="postTitle" placeholder="제목을 입력하세요" /><br>
		<form:textarea path="postContent" placeholder="내용을 입력하세요" /><br>
		<form:input type="number" path="expectedPay" /><br>
		<form:input type="number" path="expectedHelperCount" /><br>
		<form:input path="wantedSkill" placeholder="원하는 도우미 스킬을 입력하세요" /><br>
		<form:input type="datetime-local" path="requestTime" /><br>
		<button>작성</button>

	</form:form>
</body>
</html>