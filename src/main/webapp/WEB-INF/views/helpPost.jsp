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
	요청 상태: ${helpPost.postStatus}<br>
	작성자 : ${helpPost.userId}<br>
	도움 카테고리: ${helpPost.helpCategory}<br>
	도움 요청 지역: ${helpPost.postAddrGu} ${helpPost.postAddrDong}<br>
	제목: ${helpPost.postTitle}<br>
	본문: ${helpPost.postContent}<br>
	예상 보수: ${helpPost.expectedPay}<br>
	확정 보수: ${helpPost.finalPay}<br>
	예상 도우미 인원: ${helpPost.expectedHelperCount}<br>
	지원 도우미 인원: ${helpPost.appliedHelperCount}<br>
	수락 도우미 인원: ${helpPost.acceptedHelperCount}<br>
	원하는 도우미 스킬: ${helpPost.wantedSkill}<br>
	도움 시간: ${helpPost.requestTime}<br>
	게시글 생성: ${helpPost.postCreatedAt}<br>
	게시글 수정: ${helpPost.postUpdatedAt}<br>
	게시글 신고 상태: ${helpPost.deleted}<br>
	
	<input type="hidden" id="helpPostNo" value="${helpPost.helpPostNo}">
	<c:url value="/help-posts/${helpPost.helpPostNo}/comments" var="getAllCommentsByPost"/>
	
	<script>
	
	const helpPostNo = document.getElementById("helpPostNo");
	
	function loadComments(helpPostNo) {
		$.ajax({
			url: "${getAllCommentsByPost}",
			type: "GET",
			data: {
				helpPostNo: helpPostNo,
				commentContent: $("#commentContent").val()
			},
			success: function (comments) {
				$("#commentList").empty();

				comments.forEach(function (comment) {
					appendComment(comment);
				});
			}
		});
	}
	
	
	
	
	</script>
</body>
</html>