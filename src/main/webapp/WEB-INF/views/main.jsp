<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TownHelper</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

<header class="top-header">
  <div class="container header-inner">
  	
  	<c:url value="/" var="main"/>  	
  
    <h1 class="logo"><a href="${main}">TownHelper</a></h1>

    <nav class="top-nav">
      <a href="#">도움 찾기</a>
      <a href="#">요청하기</a>
      <a href="#">관심글</a>
      <a href="${main}users/{userNo}">마이페이지</a>
      <a href="${main}login">로그인</a>
      <a href="${main}users/register" class="join-btn">회원가입</a>
    </nav>
  </div>
</header>

<section class="hero">
  <div class="container hero-inner">
    <p class="eyebrow">동네 생활 서비스 매칭 플랫폼</p>
    <h2>필요한 도움을 올리면<br>가까운 이웃이 지원합니다</h2>
    <p class="hero-desc">
      청소, 과외, 펫시터, 짐 옮기기, 간단 수리까지<br>
      우리 동네에서 필요한 도움을 요청하고 매칭해보세요.
    </p>

    <form class="search-box">
      <input type="text" placeholder="제목 또는 내용으로 검색">
      <button type="submit">검색</button>
    </form>
  </div>
</section>

<section class="category-section">
  <div class="container">
    <div class="category-list">
      <a href="#" class="active">전체</a>
      <a href="#">청소</a>
      <a href="#">펫시터</a>
      <a href="#">과외</a>
      <a href="#">짐 옮기기</a>
      <a href="#">수리</a>
      <a href="#">직접입력</a>
    </div>
  </div>
</section>

<main class="main-area">
  <div class="container main-grid">

    <section class="feed-section">
      <div class="section-head">
        <h2>오늘 올라온 도움요청</h2>
        <a href="#">전체보기</a>
      </div>

      <div class="post-list">

        <article class="post-card">
          <div class="post-thumb clean-thumb">
            <span>청소</span>
          </div>

          <div class="post-content">
            <div class="post-top">
              <span class="status open">OPEN</span>
              <span class="location">서울 관악구</span>
            </div>

            <h3>원룸 청소 도와주실 분 구합니다</h3>
            <p>오늘 오후 4시 이후, 2시간 정도 원룸 청소 도움 요청합니다.</p>

            <div class="post-tags">
              <span>희망 인원 1명</span>
              <span>꼼꼼한 분 선호</span>
            </div>

            <div class="post-bottom">
              <strong>30,000원</strong>
              <div class="post-actions">
                <span>도와주기 3</span>
                <span>댓글 5</span>
                <span>관심 12</span>
              </div>
            </div>
          </div>
        </article>

        <article class="post-card">
          <div class="post-thumb pet-thumb">
            <span>펫시터</span>
          </div>

          <div class="post-content">
            <div class="post-top">
              <span class="status open">OPEN</span>
              <span class="location">서울 동작구</span>
            </div>

            <h3>강아지 산책 맡아주실 분 찾습니다</h3>
            <p>저녁 시간대에 30분 정도 산책 도와주실 분을 찾습니다.</p>

            <div class="post-tags">
              <span>희망 인원 1명</span>
              <span>반려견 경험자 선호</span>
            </div>

            <div class="post-bottom">
              <strong>15,000원</strong>
              <div class="post-actions">
                <span>도와주기 4</span>
                <span>댓글 2</span>
                <span>관심 8</span>
              </div>
            </div>
          </div>
        </article>

        <article class="post-card">
          <div class="post-thumb study-thumb">
            <span>과외</span>
          </div>

          <div class="post-content">
            <div class="post-top">
              <span class="status closed">CLOSED</span>
              <span class="location">서울 서초구</span>
            </div>

            <h3>중학생 수학 기초 과외 도움 구합니다</h3>
            <p>기초 개념 설명과 문제 풀이를 도와주실 대학생 분을 찾습니다.</p>

            <div class="post-tags">
              <span>희망 인원 1명</span>
              <span>수학 가능자 선호</span>
            </div>

            <div class="post-bottom">
              <strong>40,000원</strong>
              <div class="post-actions">
                <span>선정 완료</span>
                <span>댓글 6</span>
                <span>관심 14</span>
              </div>
            </div>
          </div>
        </article>

        <article class="post-card">
          <div class="post-thumb move-thumb">
            <span>짐 옮기기</span>
          </div>

          <div class="post-content">
            <div class="post-top">
              <span class="status complete">COMPLETE</span>
              <span class="location">서울 마포구</span>
            </div>

            <h3>이사 박스 옮기는 것 도와주실 분</h3>
            <p>거래가 완료되어 후기 작성이 가능한 요청글입니다.</p>

            <div class="post-tags">
              <span>희망 인원 2명</span>
              <span>힘 잘 쓰는 분 선호</span>
            </div>

            <div class="post-bottom">
              <strong>50,000원</strong>
              <div class="post-actions">
                <span>후기 가능</span>
                <span>별점 5.0</span>
              </div>
            </div>
          </div>
        </article>

      </div>
    </section>

    <aside class="side-area">

      <section class="side-box">
        <h3>최근 관심글</h3>
        <ul class="interest-list">
          <li><a href="#">고양이 돌봄 가능하신 분</a><span>OPEN</span></li>
          <li><a href="#">싱크대 수리 도움 요청</a><span>OPEN</span></li>
          <li><a href="#">주말 청소 도와주실 분</a><span>CLOSED</span></li>
        </ul>
      </section>

      <section class="side-box">
        <h3>내 프로필</h3>
        <div class="profile-box">
          <p class="profile-main">짐 옮기기: 저 짐 잘 옮겨요</p>
          <p class="profile-sub">도우미 활동 3건 · 건별 별점 표시</p>
        </div>
      </section>

      <section class="side-box">
        <h3>바로가기</h3>
        <div class="quick-menu">
          <a href="#">요청글 작성</a>
          <a href="#">내 요청글</a>
          <a href="#">채팅</a>
          <a href="#">신고하기</a>
        </div>
      </section>

    </aside>

  </div>
</main>

<footer class="footer">
  <p>© TownHelper. 우리 동네 생활 도움 매칭 플랫폼</p>
</footer>

</body>
</html>