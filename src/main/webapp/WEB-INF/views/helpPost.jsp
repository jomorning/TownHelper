<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
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
					href="#">관심글</a> <a href="${main}users/{userNo}">마이페이지</a> <a
					href="${main}login">로그인</a> <a href="${main}users/register"
					class="join-btn">회원가입</a>
			</nav>

		</div>
	</header>

	<main class="page-area">
		<div class="container">

			<div class="two-column">

				<section class="content-panel">

					<div class="detail-head">

						<div>
							<span class="status open"> ${helpPost.postStatus} </span>

							<h2>${helpPost.postTitle}</h2>

							<div class="detail-meta">
								<span>작성자 ${helpPost.userId}</span> <span>${helpPost.postAddrGu}
									${helpPost.postAddrDong}</span> <span>작성
									${helpPost.postCreatedAt}</span> <span>수정
									${helpPost.postUpdatedAt}</span>
							</div>
						</div>

						<div class="detail-price">
							<span>예상 보수</span> <strong>${helpPost.expectedPay}원</strong>
						</div>

					</div>

					<div class="detail-body">${helpPost.postContent}</div>

					<div class="info-list">

						<div class="info-item">
							<span>도움 카테고리</span> <strong>${helpPost.helpCategory}</strong>
						</div>

						<div class="info-item">
							<span>도움 요청 지역</span> <strong>${helpPost.postAddrGu}
								${helpPost.postAddrDong}</strong>
						</div>

						<div class="info-item">
							<span>확정 보수</span> <strong>${helpPost.finalPay}</strong>
						</div>

						<div class="info-item">
							<span>예상 도우미 인원</span> <strong>${helpPost.expectedHelperCount}명</strong>
						</div>

						<div class="info-item">
							<span>지원 도우미 인원</span> <strong>${helpPost.appliedHelperCount}명</strong>
						</div>

						<div class="info-item">
							<span>수락 도우미 인원</span> <strong>${helpPost.acceptedHelperCount}명</strong>
						</div>

						<div class="info-item">
							<span>원하는 도우미 스킬</span> <strong>${helpPost.wantedSkill}</strong>
						</div>

						<div class="info-item">
							<span>도움 시간</span> <strong>${helpPost.requestTime}</strong>
						</div>

						<div class="info-item">
							<span>신고 상태</span> <strong>${helpPost.deleted}</strong>
						</div>

					</div>

					<c:url value='/help-posts/${helpPost.helpPostNo}/edit'
						var="editHelpPost" />

					<div class="form-actions">
						<a href="${editHelpPost}" class="btn-basic"> 게시글 수정 </a>

						<button type="button" class="btn-blue">도우미 지원</button>
					</div>

				</section>

				<aside class="side-area">

					<section class="side-box">
						<h3>게시글 정보</h3>

						<div class="profile-box">
							<p class="profile-main">${helpPost.postStatus}</p>

							<p class="profile-sub">지원 ${helpPost.appliedHelperCount}명 ·
								수락 ${helpPost.acceptedHelperCount}명</p>
						</div>
					</section>

				</aside>

			</div>

			<section class="content-panel" style="margin-top: 24px;">

				<div class="section-head">
					<h2>댓글</h2>
				</div>

				<div id="commentArea" class="comment-list">

					<c:forEach var="comment" items="${commentList}">
						<div class="comment-card" data-comment-no="${comment.commentNo}">

							<strong>${comment.userId}</strong>

							<p class="commentContent">${comment.commentContent}</p>

							<p>작성 : ${comment.commentCreatedAt}</p>

							<p>
								수정 : <span class="commentUpdatedAt">
									${comment.commentUpdatedAt} </span>
							</p>

							<div class="form-actions">
								<button type="button" id="editCommentBtn" class="btn-basic">
									수정</button>

								<button type="button" id="deleteCommentBtn" class="btn-red">
									삭제</button>
							</div>

							<div class="editFormArea"></div>

						</div>
					</c:forEach>

				</div>

				<div class="form-row" style="margin-top: 24px;">
					<label>댓글 작성</label> <input type="text" id="newCommentContent"
						placeholder="댓글을 입력하세요">
				</div>

				<div class="form-actions">
					<button type="button" id="newCommentBtn" class="btn-dark">
						댓글 등록</button>
				</div>

			</section>

		</div>
	</main>

	<footer class="footer">
		<p>© TownHelper. 우리 동네 생활 도움 매칭 플랫폼</p>
	</footer>

	<c:url value='/help-posts/${helpPost.helpPostNo}/comments'
		var="submitNewComment" />
	<c:url value='/help-posts/${helpPost.helpPostNo}/comments'
		var="submitEditCommentBase" />

	<script>
	const newCommentBtn = document.getElementById("newCommentBtn");
	const newCommentContent = document.getElementById("newCommentContent");
	const commentArea = document.getElementById("commentArea");

	newCommentBtn.addEventListener("click", function() {
		$.ajax({
			url: "${submitNewComment}",
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify({
				helpPostNo: ${helpPost.helpPostNo},
				commentContent: newCommentContent.value
			}),

			success: function(newComment) {
				commentArea.innerHTML +=
					"<div class='comment-card' data-comment-no='" + newComment.commentNo + "'>"
					+ "<strong>" + newComment.userId + "</strong>"
					+ "<p class='commentContent'>" + newComment.commentContent + "</p>"
					+ "<p>작성 : " + newComment.commentCreatedAt + "</p>"
					+ "<p>수정 : <span class='commentUpdatedAt'>" + newComment.commentUpdatedAt + "</span></p>"
					+ "<div class='form-actions'>"
					+ "<button type='button' id='editCommentBtn' class='btn-basic'>수정</button>"
					+ "<button type='button' id='deleteCommentBtn' class='btn-red'>삭제</button>"
					+ "</div>"
					+ "<div class='editFormArea'></div>"
					+ "</div>";

				newCommentContent.value = "";
			}
		});
	});

	commentArea.addEventListener("click", function(event) {

		if (event.target.id === "editCommentBtn") {
			const commentDiv = event.target.closest("[data-comment-no]");
			const commentContentSpan = commentDiv.querySelector(".commentContent");
			const editFormArea = commentDiv.querySelector(".editFormArea");

			if (editFormArea.innerHTML.trim() !== "") {
				return;
			}

			editFormArea.innerHTML =
				"<div class='form-row' style='margin-top:14px;'>"
				+ "<input type='text' class='editCommentContent' value='" + commentContentSpan.innerText.trim() + "'>"
				+ "</div>"
				+ "<div class='form-actions'>"
				+ "<button type='button' class='saveCommentBtn btn-blue'>저장</button>"
				+ "<button type='button' class='cancelEditBtn btn-light'>취소</button>"
				+ "</div>";
		}

		if (event.target.classList.contains("saveCommentBtn")) {
			const commentDiv = event.target.closest("[data-comment-no]");
			const commentNo = commentDiv.dataset.commentNo;
			const editCommentContent = commentDiv.querySelector(".editCommentContent").value;
			const commentContentSpan = commentDiv.querySelector(".commentContent");
			const commentUpdatedAtSpan = commentDiv.querySelector(".commentUpdatedAt");
			const editFormArea = commentDiv.querySelector(".editFormArea");

			$.ajax({
				url: "${submitEditCommentBase}/" + commentNo,
				type: "PUT",
				contentType: "application/json",
				data: JSON.stringify({
					commentNo: commentNo,
					helpPostNo: ${helpPost.helpPostNo},
					commentContent: editCommentContent
				}),

				success: function(editComment) {
					commentContentSpan.innerText = editComment.commentContent;
					commentUpdatedAtSpan.innerText = editComment.commentUpdatedAt;
					editFormArea.innerHTML = "";
				}
			});
		}

		if (event.target.classList.contains("cancelEditBtn")) {
			const commentDiv = event.target.closest("[data-comment-no]");
			const editFormArea = commentDiv.querySelector(".editFormArea");

			editFormArea.innerHTML = "";
		}

		if (event.target.id === "deleteCommentBtn") {
			const commentDiv = event.target.closest("[data-comment-no]");
			const commentNo = commentDiv.dataset.commentNo;

			if (!confirm("댓글을 삭제하시겠습니까?")) {
				return;
			}

			$.ajax({
				url: "${submitEditCommentBase}/" + commentNo,
				type: "DELETE",

				success: function() {
					commentDiv.remove();
				}
			});
		}
	});
</script>

</body>
</html>