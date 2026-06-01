<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심글 목록</title>

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
            <a href="#">도움 찾기</a>
            <a href="${main}help-posts/new">요청하기</a>
            <a href="${main}users/${userNo}/interestHelpPosts">관심글</a>
            <a href="${main}users/${userNo}">마이페이지</a>
        </nav>

    </div>
</header>

<main class="page-area">
    <div class="container">

        <section class="content-panel">

            <div class="section-head">
                <h2>관심글 목록</h2>
            </div>

            <div id="interestHelpPostArea" class="comment-list">

                <c:forEach var="interest" items="${interestHelpPostList}">
                    <div class="comment-card"
                         data-help-post-no="${interest.helpPostNo}">

                        <strong>${interest.helpPostTitle}</strong>

                        <p>카테고리: ${interest.helpCategory}</p>

                        <div class="form-actions">
                            <a href="${pageContext.request.contextPath}/help-posts/${interest.helpPostNo}"
                               class="btn-basic">
                                게시글 보기
                            </a>

                            <button type="button"
                                    class="deleteInterestBtn btn-red">
                                관심글 삭제
                            </button>
                        </div>

                    </div>
                </c:forEach>

            </div>

        </section>

    </div>
</main>

<footer class="footer">
    <p>© TownHelper. 우리 동네 생활 도움 매칭 플랫폼</p>
</footer>

<script>
const interestHelpPostArea = document.getElementById("interestHelpPostArea");
const interestBaseUrl =
    "${pageContext.request.contextPath}/interestHelpPosts";

function renderInterestHelpPostList(list) {
    interestHelpPostArea.innerHTML = "";

    list.forEach(function(interest) {
        interestHelpPostArea.innerHTML +=
            "<div class='comment-card' data-help-post-no='" + interest.helpPostNo + "'>"
            + "<strong>" + interest.helpPostTitle + "</strong>"
            + "<p>카테고리: " + interest.helpCategory + "</p>"
            + "<div class='form-actions'>"
            + "<a href='${pageContext.request.contextPath}/help-posts/"
            + interest.helpPostNo
            + "' class='btn-basic'>게시글 보기</a>"
            + "<button type='button' class='deleteInterestBtn btn-red'>관심글 삭제</button>"
            + "</div>"
            + "</div>";
    });
}

interestHelpPostArea.addEventListener("click", function(event) {
    if (!event.target.classList.contains("deleteInterestBtn")) {
        return;
    }

    const card = event.target.closest("[data-help-post-no]");
    const helpPostNo = card.dataset.helpPostNo;

    if (!confirm("관심글에서 삭제하시겠습니까?")) {
        return;
    }

    $.ajax({
        url: interestBaseUrl + "/" + helpPostNo,
        type: "DELETE",
        success: function(list) {
            renderInterestHelpPostList(list);
        },
        error: function(xhr) {
            alert(xhr.responseText || "관심글 삭제에 실패했습니다.");
        }
    });
});
</script>

</body>
</html>