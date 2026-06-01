<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 상세 조회</title>

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
			<h2>사용자 상세 조회</h2>
			<p>사용자의 기본 정보와 활동 정보를 확인할 수 있습니다.</p>
		</div>

		<div class="profile-layout">

			<section class="profile-card-large">

				<c:choose>
					<c:when test="${not empty user.profileImgName}">
						<img src="<c:url value='/upload/user/${user.profileImgName}'/>"
							alt="프로필 이미지"
							style="width:86px; height:86px; border-radius:50%; object-fit:cover; margin-bottom:18px;">
					</c:when>

					<c:otherwise>
						<div class="profile-avatar"></div>
					</c:otherwise>
				</c:choose>

				<h3>${user.userId}</h3>

				<p>
					${user.userAddrGu} ${user.userAddrDong}<br>
					${user.userSkill}
				</p>

				<div class="score-box">
					<strong>${user.mannerScore}</strong>
					<span>매너 점수</span>
				</div>

			</section>

			<section class="content-panel">

				<div class="section-head">
					<h2>기본 정보</h2>
				</div>

				<div class="info-list">

					<div class="info-item">
						<span>아이디</span>
						<strong>${user.userId}</strong>
					</div>

					<div class="info-item">
						<span>성별</span>
						<strong>${user.userGender}</strong>
					</div>

					<div class="info-item">
						<span>생년월일</span>
						<strong>${user.userBirth}</strong>
					</div>

					<div class="info-item">
						<span>나이</span>
						<strong>${user.userAge}</strong>
					</div>

					<div class="info-item">
						<span>주소</span>
						<strong>${user.userAddrGu} ${user.userAddrDong}</strong>
					</div>

					<div class="info-item">
						<span>나만의 스킬</span>
						<strong>${user.userSkill}</strong>
					</div>

					<div class="info-item">
						<span>요청 완료 횟수</span>
						<strong>${user.requesterCompletedCount}</strong>
					</div>

					<div class="info-item">
						<span>도움 완료 횟수</span>
						<strong>${user.helperCompletedCount}</strong>
					</div>

					<div class="info-item">
						<span>가입일</span>
						<strong>${user.userCreatedAt}</strong>
					</div>

				</div>

				<div class="form-actions">

					<c:url value="/users/${user.userNo}/edit" var="getEditUser" />
					<a href="${getEditUser}" class="btn-blue">
						내 정보 수정
					</a>

					<c:url value="/users/${user.userNo}" var="submitDeleteUser" />
					<form:form action="${submitDeleteUser}" method="DELETE">
						<button type="submit" class="btn-red">
							회원 탈퇴
						</button>
					</form:form>

				</div>

			</section>

		</div>

	</div>
</main>

<footer class="footer">
	<p>© TownHelper. 우리 동네 생활 도움 매칭 플랫폼</p>
</footer>

</body>
</html>