<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>

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

		<div class="auth-wrap">
			<div class="auth-box">

				<h2>회원 가입</h2>
				<p>TownHelper에서 도움을 요청하거나 이웃을 도와보세요.</p>

				<c:url value="/users" var="submitRegister" />

				<form:form
					modelAttribute="newUser"
					action="${submitRegister}"
					enctype="multipart/form-data">

					<div class="form-grid">

						<div class="form-row">
							<label>아이디</label>
							<form:input path="userId" />
						</div>

						<div class="form-row">
							<label>비밀번호</label>
							<form:password path="userPw" />
						</div>

						<div class="form-row">
							<label>이름</label>
							<form:input path="userName" />
						</div>

						<div class="form-row">
							<label>성별</label>
							<form:select path="userGender">
								<form:option value="">선택</form:option>
								<form:option value="MALE">남성</form:option>
								<form:option value="FEMALE">여성</form:option>
							</form:select>
						</div>

						<div class="form-row">
							<label>생년월일</label>
							<form:input type="date" path="userBirth" />
						</div>

						<div class="form-row">
							<label>구</label>
							<form:input path="userAddrGu" placeholder="예: 진해구" />
						</div>

						<div class="form-row">
							<label>동</label>
							<form:input path="userAddrDong" placeholder="예: 석동" />
						</div>

						<div class="form-row">
							<label>나만의 스킬</label>
							<form:input
								path="userSkill"
								placeholder="예: 과외 잘 할 자신 있습니다" />
						</div>

						<div class="form-row">
							<label>프로필 이미지</label>
							<form:input
								type="file"
								path="profileImgFile" />
						</div>

					</div>

					<div class="form-actions">
						<button type="reset" class="btn-light">초기화</button>
						<button type="submit" class="btn-dark">회원가입</button>
					</div>

				</form:form>

			</div>
		</div>

	</div>
</main>

<footer class="footer">
	<p>© TownHelper. 우리 동네 생활 도움 매칭 플랫폼</p>
</footer>

</body>
</html>