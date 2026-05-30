<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	요청 상태: ${helpPost.postStatus}
	<br> 작성자 : ${helpPost.userId}
	<br> 도움 카테고리: ${helpPost.helpCategory}
	<br> 도움 요청 지역: ${helpPost.postAddrGu} ${helpPost.postAddrDong}
	<br> 제목: ${helpPost.postTitle}
	<br> 본문: ${helpPost.postContent}
	<br> 예상 보수: ${helpPost.expectedPay}
	<br> 확정 보수: ${helpPost.finalPay}
	<br> 예상 도우미 인원: ${helpPost.expectedHelperCount}
	<br> 지원 도우미 인원: ${helpPost.appliedHelperCount}
	<br> 수락 도우미 인원: ${helpPost.acceptedHelperCount}
	<br> 원하는 도우미 스킬: ${helpPost.wantedSkill}
	<br> 도움 시간: ${helpPost.requestTime}
	<br> 게시글 생성: ${helpPost.postCreatedAt}
	<br> 게시글 수정: ${helpPost.postUpdatedAt}
	<br> 게시글 신고 상태: ${helpPost.deleted}
	<br>

	<hr>

	<form>
		<button type="button">도우미 지원</button>
	</form>

	<hr>

	<div id="commentArea">
		<c:forEach var="comment" items="${commentList}">
			<div data-comment-no="${comment.commentNo}">
				${comment.userId}<br> <span class="commentContent">${comment.commentContent}</span><br>

				${comment.commentCreatedAt}<br> <span class="commentUpdatedAt">
					${comment.commentUpdatedAt} </span><br>

				<button type="button" id="editCommentBtn">수정</button>
				<button type="button" id="deleteCommentBtn">삭제</button>

				<div class="editFormArea"></div>
				<hr>
			</div>
		</c:forEach>
	</div>

	<hr>

	<form>
		<input type="text" id="newCommentContent" placeholder="댓글을 입력하세요">
		<button type="button" id="newCommentBtn">댓글 등록</button>
	</form>

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
					"<div data-comment-no='" + newComment.commentNo + "'>"
					+ newComment.userId + "<br>"
					+ "<span class='commentContent'>" + newComment.commentContent + "</span><br>"
					+ newComment.commentCreatedAt + "<br>"
					+ "<span class='commentUpdatedAt'>" + newComment.commentUpdatedAt + "</span><br>"
					+ "<button type='button' id='editCommentBtn'>수정</button>"
					+ "<button type='button' id='deleteCommentBtn'>삭제</button>"
					+ "<div class='editFormArea'></div>"
					+ "<hr>"
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
				"<input type='text' class='editCommentContent' value='" + commentContentSpan.innerText.trim() + "'>"
				+ "<button type='button' class='saveCommentBtn'>저장</button>"
				+ "<button type='button' class='cancelEditBtn'>취소</button>";
		}

		if (event.target.className === "saveCommentBtn") {
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

		if (event.target.className === "cancelEditBtn") {
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