<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>TrainingPlan List</title>
</head>
<body>
<a href="/logout">Wyloguj</a>
<table border="1">
    <thead>
    <th>Nazwa Planu</th>
    <th>Data Startu</th>
    <th>Data Zakonczenia</th>
    <th>Beanch Press CM</th>
    <th>Deadlift CM</th>
    <th>Squat CM</th>
    </thead>
    <tbody>
    <c:forEach items="${trainingPlans}" var="trainingPlan">
        <tr>
            <td><c:out value="${trainingPlan.namePlan}"/></td>
            <td><fmt:formatDate pattern="dd-MM-yyyy" value="${trainingPlan.createDate}"/></td>
            <td><fmt:formatDate pattern="dd-MM-yyyy" value="${trainingPlan.finishDate}"/></td>
            <td><fmt:formatNumber value="${(trainingPlan.weightBp * trainingPlan.repsBp) * 0.9}" maxFractionDigits="1"/></td>
            <td><fmt:formatNumber value="${(trainingPlan.weightDl * trainingPlan.repsDl) * 0.9}" maxFractionDigits="1"/></td>
            <td><fmt:formatNumber value="${(trainingPlan.weightSq * trainingPlan.repsSq) * 0.9}" maxFractionDigits="1"/></td>
            <td><a href = "/trainingPlans/editTrainingPlan/<c:out value="${trainingPlan.id}"/>">Edytuj</a></td>
            <td><a href = "/trainingPlans/delete/<c:out value="${trainingPlan.id}"/>">Usun</a></td>
            <td><a href = "/trainingPlans/showTrainingPlan/<c:out value="${trainingPlan.id}"/>">Szczegoly</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/trainingCalculators/addTrainingCalculator">Dodaj Nowy Plan</a>
</body>
</html>