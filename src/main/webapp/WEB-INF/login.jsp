<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>

<form:form method="post" modelAttribute="user">
    <label>Login/Email</label>
    <form:input path="login" placeholder="Podaj Email/Login"/>
    <form:errors path="login" /><br/>
    <label>Haslo</label>
    <form:input path="password" type="password" placeholder="Podaj Haslo"/>
    <form:errors path="password"/><br/>
    <input type="submit" value="Zaloguj sie"> <a href="/register">Zarejestruj</a>
</form:form>


</body>
</html>