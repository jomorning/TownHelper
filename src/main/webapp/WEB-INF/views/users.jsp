<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사옹자 목록</title>
</head>
<body>

	<c:forEach var="user" items="${userList}">
	<img src="<c:url value='/upload/user/${user.profileImgName}'/>" style="width: 20%"/><br>
	${user.userId}<br>
	${user.userGender}<br>
	${user.userBirth}<br>
	${user.userAddrGu} | ${user.userAddrDong}<br>
	${user.userCreatedAt}<br>
	<hr>
	</c:forEach>

</body>
</html>