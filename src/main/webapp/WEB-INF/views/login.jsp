<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

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
            <a href="${main}help-posts">도움 찾기</a>
            <a href="${main}help-posts/new">요청하기</a>
            <a href="${main}login">로그인</a>
            <a href="${main}users/register" class="join-btn">회원가입</a>
        </nav>

    </div>
</header>

<main class="page-area">
    <div class="container">

        <section class="content-panel" style="max-width: 520px; margin: 0 auto;">

            <div class="section-head">
                <h2>로그인</h2>
            </div>

            <form action="${pageContext.request.contextPath}/login"
                  method="POST">

                <div class="form-row">
                    <label>아이디</label>
                    <input type="text"
                           name="userId"
                           placeholder="아이디를 입력하세요"
                           required>
                </div>

                <div class="form-row">
                    <label>비밀번호</label>
                    <input type="password"
                           name="userPw"
                           placeholder="비밀번호를 입력하세요"
                           required>
                </div>

                <div class="form-actions">
                    <button type="submit" class="btn-dark">
                        로그인
                    </button>

                    <a href="${main}users/register" class="btn-basic">
                        회원가입
                    </a>
                </div>

            </form>

        </section>

    </div>
</main>

<footer class="footer">
    <p>© TownHelper. 우리 동네 생활 도움 매칭 플랫폼</p>
</footer>

</body>
</html>