<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="student">
    <form:input path="firstName"/>

    <form:input path="lastName"/>
    <input type="submit" value="Save">
</form:form>

<c:forEach items="${languages}" var="lang">
    ${lang}<br>
</c:forEach>

</body>
</html>
