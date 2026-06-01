<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

<header class="top-header">
	<div class="container header-inner">
		<c:url value="/" var="main" />

		<h1 class="logo">
			<a href="${main}">TownHelper</a>
		</h1>
	</div>
</header>

<main class="page-area">
	<div class="container">

		<div class="page-title">
			<h2>게시글 수정</h2>
		</div>

		<div class="content-panel">

			<c:url value="/help-posts/${editHelpPost.helpPostNo}" var="submitEditHelpPost" />

			<form:form
				modelAttribute="editHelpPost"
				action="${submitEditHelpPost}"
				method="PUT"
				enctype="multipart/form-data">

				<div class="form-grid">

					<div class="form-row">
						<label>게시글 상태</label>
						<form:select path="postStatus">
							<form:option value="">선택</form:option>
							<form:option value="OPEN">도움 요청 중</form:option>
							<form:option value="CLOSED">종료</form:option>
							<form:option value="COMPLETE">완료</form:option>
						</form:select>
					</div>

					<div class="form-row">
						<label>도움 카테고리</label>
						<form:input path="helpCategory" />
					</div>

					<div class="form-row">
						<label>도움 요청 지역(구)</label>
						<form:input path="postAddrGu" readonly="true" />
					</div>

					<div class="form-row">
						<label>도움 요청 지역(동)</label>
						<form:input path="postAddrDong" readonly="true" />
					</div>

					<div class="form-row">
						<label>제목</label>
						<form:input path="postTitle" />
					</div>

					<div class="form-row">
						<label>본문</label>
						<form:textarea path="postContent" />
					</div>

					<div class="form-row">
						<label>예상 보수</label>
						<form:input type="number" path="expectedPay" />
					</div>

					<div class="form-row">
						<label>예상 도우미 인원</label>
						<form:input type="number" path="expectedHelperCount" />
					</div>

					<div class="form-row">
						<label>원하는 도우미 스킬</label>
						<form:input path="wantedSkill" />
					</div>

					<div class="form-row">
						<label>도움 시간</label>
						<form:input type="datetime-local" path="requestTime" />
					</div>

				</div>

				<div class="form-actions">
					<button type="submit" class="btn-blue">수정</button>
				</div>

			</form:form>

			<c:url value="/help-posts/${editHelpPost.helpPostNo}" var="submitDeleteHelpPost" />

			<form:form action="${submitDeleteHelpPost}" method="DELETE">
				<div class="form-actions">
					<button type="submit" class="btn-red">삭제</button>
				</div>
			</form:form>

		</div>

	</div>
</main>

</body>
</html>