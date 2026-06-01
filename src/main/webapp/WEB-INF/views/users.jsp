<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 목록</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>

<style>
.admin-table {
	width: 100%;
	border-collapse: collapse;
}

.admin-table th {
	background: #f8fafc;
	font-weight: 700;
}

.admin-table th, .admin-table td {
	padding: 14px;
	border-bottom: 1px solid #e5e7eb;
	text-align: left;
	vertical-align: middle;
}

.admin-table tr:hover {
	background: #f8fafc;
}
</style>

<body>

	<header class="top-header">
		<div class="container header-inner">

			<c:url value="/" var="main" />

			<h1 class="logo">
				<a href="${main}">TownHelper Admin</a>
			</h1>

		</div>
	</header>

	<main class="page-area">
		<div class="container">

			<div class="page-title">
				<h2>사용자 관리</h2>
				<p>전체 회원 목록</p>
			</div>

			<div class="content-panel">

				<table class="admin-table">

					<thead>
						<tr>
							<th>프로필</th>
							<th>아이디</th>
							<th>성별</th>
							<th>생년월일</th>
							<th>주소</th>
							<th>가입일</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach var="user" items="${userList}">
							<tr>

								<td><img
									src="<c:url value='/upload/user/${user.profileImgName}'/>"
									style="width: 60px; height: 60px; border-radius: 50%; object-fit: cover;">
								</td>

								<td>${user.userId}</td>

								<td>${user.userGender}</td>

								<td>${user.userBirth}</td>

								<td>${user.userAddrGu} ${user.userAddrDong}</td>

								<td>${user.userCreatedAt}</td>

							</tr>
						</c:forEach>

					</tbody>

				</table>

			</div>

		</div>
	</main>

	<footer class="footer">
		<p>© TownHelper Admin</p>
	</footer>

</body>
</html>