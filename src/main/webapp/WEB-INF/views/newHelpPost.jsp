<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>

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

		<nav class="top-nav">
			<a href="#">도움 찾기</a>
			<a href="${main}help-posts/new">요청하기</a>
			<a href="#">관심글</a>
			<a href="${main}users/{userNo}">마이페이지</a>
			<a href="${main}login">로그인</a>
			<a href="${main}users/register" class="join-btn">회원가입</a>
		</nav>
	</div>
</header>

<main class="page-area">
	<div class="container">

		<div class="page-title">
			<h2>도움 요청 작성</h2>
			<p>필요한 도움 내용을 작성하면 주변 도우미들이 지원할 수 있습니다.</p>
		</div>

		<div class="content-panel">

			<c:url value="/help-posts" var="submitNewHelpPost" />

			<form:form
				modelAttribute="newHelpPost"
				action="${submitNewHelpPost}"
				enctype="multipart/form-data">

				<div class="form-grid">

					<div class="form-row">
						<label>도움 카테고리</label>
						<form:input
							path="helpCategory"
							placeholder="예) 이삿짐 나르기, 과외, 반려동물 돌봄" />
					</div>

					<div class="form-row">
						<label>도움 요청 지역(구)</label>
						<form:input
							path="postAddrGu"
							placeholder="예) 관악구" />
					</div>

					<div class="form-row">
						<label>도움 요청 지역(동)</label>
						<form:input
							path="postAddrDong"
							placeholder="예) 봉천동" />
					</div>

					<div class="form-row">
						<label>제목</label>
						<form:input
							path="postTitle"
							placeholder="제목을 입력하세요" />
					</div>

					<div class="form-row">
						<label>내용</label>
						<form:textarea
							path="postContent"
							placeholder="도움 요청 내용을 입력하세요" />
					</div>

					<div class="form-row">
						<label>예상 보수</label>
						<form:input
							type="number"
							path="expectedPay" />
					</div>

					<div class="form-row">
						<label>예상 도우미 인원</label>
						<form:input
							type="number"
							path="expectedHelperCount" />
					</div>

					<div class="form-row">
						<label>원하는 도우미 스킬</label>
						<form:input
							path="wantedSkill"
							placeholder="예) 운전 가능, 수학 지도 가능" />
					</div>

					<div class="form-row">
						<label>도움 요청 시간</label>
						<form:input
							type="datetime-local"
							path="requestTime" />
					</div>

				</div>

				<div class="form-actions">
					<a href="${main}" class="btn-light">취소</a>
					<button type="submit" class="btn-dark">작성</button>
				</div>

			</form:form>

		</div>

	</div>
</main>

<footer class="footer">
	<p>© TownHelper. 우리 동네 생활 도움 매칭 플랫폼</p>
</footer>

</body>
</html>