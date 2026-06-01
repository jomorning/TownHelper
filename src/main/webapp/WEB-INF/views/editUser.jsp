<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 수정</title>

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
			<h2>사용자 정보 수정</h2>
		</div>

		<div class="content-panel">

			<img src="<c:url value='/upload/user/${editUser.profileImgName}'/>"
				style="width: 20%" />

			<c:url value="/users/${editUser.userNo}" var="submitEditUser" />

			<form:form modelAttribute="editUser"
				action="${submitEditUser}"
				method="PUT"
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

					<div class="info-list">

						<div class="info-item">
							<span>이름</span>
							<strong>${editUser.userName}</strong>
						</div>

						<div class="info-item">
							<span>성별</span>
							<strong>${editUser.userGender}</strong>
						</div>

						<div class="info-item">
							<span>생년월일</span>
							<strong>${editUser.userBirth}</strong>
						</div>

						<div class="info-item">
							<span>주소</span>
							<strong>${editUser.userAddrGu} ${editUser.userAddrDong}</strong>
						</div>

					</div>

					<div class="form-row">
						<label>나만의 스킬</label>
						<form:input path="userSkill"
							placeholder="예: 과외 잘 할 자신 있습니다" />
					</div>

					<div class="form-row">
						<label>프로필 이미지</label>
						<form:input type="file" path="profileImgFile" />
					</div>

				</div>

				<div class="form-actions">
					<button type="submit" class="btn-blue">수정</button>
					<button type="reset" class="btn-light">초기화</button>
				</div>

			</form:form>

		</div>

	</div>
</main>

</body>
</html>