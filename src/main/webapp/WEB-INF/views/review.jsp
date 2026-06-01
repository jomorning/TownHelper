<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 조회</title>

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
				<a href="#">도움 찾기</a> <a href="${main}help-posts/new">요청하기</a> <a
					href="#">관심글</a> <a href="${main}users/{userNo}">마이페이지</a>
			</nav>

		</div>
	</header>

	<main class="page-area">
		<div class="container">

			<section class="content-panel">

				<div class="detail-head">

					<div>
						<span class="status open"> ${review.targetType} </span>

						<h2>리뷰 #${review.reviewNo}</h2>

						<div class="detail-meta">
							<span>작성자 ${review.writerUserId}</span> <span>대상자
								${review.targetUserId}</span> <span>${review.reviewCreatedAt}</span>
						</div>
					</div>

					<div class="detail-price">
						<span>평점</span> <strong>${review.reviewStar} / 5</strong>
					</div>

				</div>

				<div class="info-list">

					<div class="info-item">
						<span>도움 게시글 번호</span> <strong>${review.helpPostNo}</strong>
					</div>

					<div class="info-item">
						<span>도움 카테고리</span> <strong>${review.helpCategory}</strong>
					</div>

					<div class="info-item">
						<span>작성자</span> <strong>${review.writerUserId}</strong>
					</div>

					<div class="info-item">
						<span>대상자</span> <strong>${review.targetUserId}</strong>
					</div>

					<div class="info-item">
						<span>리뷰 대상 유형</span> <strong>${review.targetType}</strong>
					</div>

				</div>

				<div class="detail-body">${review.reviewContent}</div>

			</section>

		</div>
	</main>

	<footer class="footer">
		<p>© TownHelper. 우리 동네 생활 도움 매칭 플랫폼</p>
	</footer>

</body>
</html>