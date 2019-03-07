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
	NOTHINGS--LOGIN--Using:${theme}<br/>
	<%-- <sf:form method="POST" modelAttribute="testModel">
		Name:<sf:input path="name"/><br/>
		Age:<sf:input path="age"/><br/>
		<input type="submit" value="post!"/>
	</sf:form> --%>
	<form method="POST" action="/myfront/">
		<input type="text" name="name"/><br/>
		<input type="text" name="age"/><br/>
		<input type="submit" value="post!"/>
	</form>
</body>
</html>