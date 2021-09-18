<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>

<form:form method="post" modelAttribute="user">
    <label>Imie</label>
    <form:input path="name" placeholder="Imie"/>
    <form:errors path="name"/><br/>
    <label>Nazwisko</label>
    <form:input path="surname" placeholder="Nazwisko"/>
    <form:errors path="surname"/><br/>
    <label>Login</label>
    <form:input path="login" placeholder="Login"/>
    <form:errors path="login"/><br/>
    <label>Email</label>
    <form:input path="email" placeholder="Email"/>
    <form:errors path="email"/><br/>
    <label>Haslo</label>
    <form:input path="password" type="password" placeholder="Haslo"/>
    <form:errors path="password"/><br/>
    <input type="submit" value="Utworz Konto">
</form:form>

</body>
</html>