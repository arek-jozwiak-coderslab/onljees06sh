<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Publisher</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.publisher.name}</td>
            <td>
                <a href="/book-form/delete?id=${book.id}">Usuń</a>
                <a href="/book-form/edit?id=${book.id}">Edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
