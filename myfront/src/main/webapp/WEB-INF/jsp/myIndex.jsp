<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AsmallSite</title>
</head>
<body>
	NOTHINGS---INDEX<br/>
	<%-- <sf:form method="POST" modelAttribute="testModel">
		Name:<sf:input path="name"/><br/>
		Age:<sf:input path="age"/><br/>
		<input type="submit" value="post!"/>
	</sf:form> --%>
	Hello! ${ name }!
</body>
</html>