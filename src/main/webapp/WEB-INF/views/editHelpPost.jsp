<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>

	<c:url value="/help-posts/${editHelpPost.helpPostNo}" var="submitEditHelpPost" />
	<form:form modelAttribute="editHelpPost" action="${submitEditHelpPost}" method="PUT" enctype="multipart/form-data">
		
		<div>
			<label>게시글 상태</label>
			<form:select path="postStatus">
				<form:option value="">선택</form:option>
				<form:option value="OPEN">도움 요청 중</form:option>
				<form:option value="CLOSED">종료</form:option>
				<form:option value="COMPLETE">완료</form:option>
			</form:select>
		</div>
		
		<form:input path="helpCategory"/><br>
		<form:input path="postAddrGu" readonly="true" /><br>
		<form:input path="postAddrDong" readonly="true" /><br>
		<form:input path="postTitle"/><br>
		<form:textarea path="postContent"/><br>
		<form:input type="number" path="expectedPay" /><br>
		<form:input type="number" path="expectedHelperCount" /><br>
		<form:input path="wantedSkill"/><br>
		<form:input type="datetime-local" path="requestTime"/><br>
		<button>수정</button>

	</form:form>
	
	
	<c:url value="/help-posts/${editHelpPost.helpPostNo}" var="submitDeleteHelpPost" />
	<form:form action="${submitDeleteHelpPost}" method="DELETE">
		<button>삭제</button>
	</form:form>
</body>
</html>