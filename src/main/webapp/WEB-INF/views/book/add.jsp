<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .error{
            color: red;
        }
    </style>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <form:hidden path="id"/>
    <label>publisher
        <form:select itemValue="id" itemLabel="name" path="publisher" items="${publishers}"/>
    </label><br/>
    <label>title
        <form:input path="title"/>
        <form:errors cssClass="error" path="title"/>
    </label><br/>
    <label>rating
        <form:input path="rating"/>
        <form:errors path="rating"/>
    </label><br/>
    <label>rating
        <form:input path="pages"/>
        <form:errors path="pages"/>
    </label><br/>
    <label>description
        <form:input path="description"/>
        <form:errors path="description"/>
    </label><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
