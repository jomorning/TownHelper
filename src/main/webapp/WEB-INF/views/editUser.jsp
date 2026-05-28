<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 수정</title>
</head>
<body>

	<img src="<c:url value='/upload/user/${editUser.profileImgName}'/>"
		style="width: 20%" />
	<br>

	<h2>사용자 정보 수정</h2>

	<c:url value="/users/${editUser.userNo}" var="submitEditUser"/>
	<form:form modelAttribute="editUser" action="${submitEditUser}" method="PUT" enctype="multipart/form-data">

		<div>
			<label>아이디</label>
			<form:input path="userId" />
		</div>

		<div>
			<label>비밀번호</label>
			<form:password path="userPw" />
		</div>

		<div>
			<label>이름</label>
			<form:input path="userName" />
		</div>

		${editUser.userGender}<br>

		${editUser.userBirth}<br>

		<div>
			<label>구</label>
			<form:input path="userAddrGu" placeholder="예: 진해구" />
		</div>

		<div>
			<label>동</label>
			<form:input path="userAddrDong" placeholder="예: 석동" />
		</div>

		<div>
			<label>나만의 스킬</label>
			<form:input path="userSkill" placeholder="예: 과외 잘 할 자신 있습니다" />
		</div>

		<div>
			<label>프로필 이미지</label>
			<form:input type="file" path="profileImgFile" />
		</div>

		<button>수정</button>
		<button type="reset">초기화</button>
	</form:form>

</body>
</html>