<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>CaloricPlan List</title>
</head>
<body>
<a href="/logout">Wyloguj</a>
<table border="1">
    <thead>
    <th>Nazwa Planu</th>
    <th>Cel</th>
    <th>Zapotrzebowanie Kaloryczne</th>
    <th>Data Startu</th>
    </thead>
    <tbody>
    <c:forEach items="${caloricPlans}" var="caloricPlan">
        <tr>
            <td><c:out value="${caloricPlan.namePlan}"/></td>
            <td><c:out value="${caloricPlan.goal}"/></td>
            <td><fmt:formatNumber value="${caloricPlan.caloriesTarget}" maxFractionDigits="2"/></td>
            <td><fmt:formatDate pattern="dd-MM-yyyy" value="${caloricPlan.createDate}"/></td>
            <td><a href="/caloricPlans/editCaloricPlan/<c:out value="${caloricPlan.id}"/>">Edytuj</a></td>
            <td><a href="/caloricPlans/delete/<c:out value="${caloricPlan.id}"/>">Usun</a></td>
            <td><a href="/caloricPlans/showCaloricPlan/<c:out value="${caloricPlan.id}"/>">Szczegoly</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/caloricCalculators/addCaloricCalculator">Dodaj Nowy Plan</a>
</body>
</html>