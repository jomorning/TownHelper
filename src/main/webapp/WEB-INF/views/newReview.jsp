<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<body>

	<header class="top-header">
		<div class="container header-inner">

			<c:url value="/" var="main" />

			<h1 class="logo">
				<a href="${main}">TownHelper</a>
			</h1>

			<nav class="top-nav">
				<a href="#">도움 찾기</a> <a href="${main}help-posts/new">요청하기</a> <a
					href="#">관심글</a> <a href="${main}users/{userNo}">마이페이지</a> <a
					href="${main}login">로그인</a> <a href="${main}users/register"
					class="join-btn">회원가입</a>
			</nav>

		</div>
	</header>

	<main class="page-area">
		<div class="container">

			<section class="content-panel">

				<div class="section-head">
					<h2>리뷰 작성</h2>
				</div>

				<c:url value="/reviews/${targetUserNo}" var="submitNewReview" />

				<form:form modelAttribute="newReview" action="${submitNewReview}">
				
				    <input type="hidden" name="targetUserNo" value="${newReview.targetUserNo}">
				    <input type="hidden" name="targetType" value="${newReview.targetType}">
				    <input type="hidden" name="helpPostNo" value="${newReview.helpPostNo}">

					<div class="form-row">
						<label>평점</label> <form:select path="reviewStar">
							<form:option value="5">5점</form:option>
							<form:option value="4">4점</form:option>
							<form:option value="3">3점</form:option>
							<form:option value="2">2점</form:option>
							<form:option value="1">1점</form:option>
						</form:select>
					</div>

					<div class="form-row">
						<label>리뷰 내용</label>
						<form:textarea path="reviewContent" rows="8" placeholder="리뷰 내용을 입력하세요"></form:textarea>
					</div>

					<div class="form-actions">
						<button>리뷰 등록</button>
					</div>
				</form:form>
			</section>

		</div>
	</main>

	<footer class="footer">
		<p>© TownHelper. 우리 동네 생활 도움 매칭 플랫폼</p>
	</footer>
</body>
</html>