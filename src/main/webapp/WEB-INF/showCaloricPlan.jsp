<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>CaloricPlans List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
</head>
</head>
<body>
<table border="1">
    <thead>
    <th>Nazwa Planu</th>
    <th>Cel</th>
    <th>Waga Poczatkowa</th>
    <th>Zapotrzebowanie Kaloryczne</th>
    <th>Bialko</th>
    <th>Weglowodany</th>
    <th>Tluszcze</th>
    <th>Data Startu</th>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${caloricPlan.namePlan}"/></td>
        <td><c:out value="${caloricPlan.goal}"/></td>
        <td><c:out value="${caloricPlan.weight}"/></td>
        <td><fmt:formatNumber value="${caloricPlan.caloriesTarget}" maxFractionDigits="0"/></td>
        <td><c:out value="${(caloricPlan.caloriesTarget * 0.15) / 4}g - ${(caloricPlan.caloriesTarget * 0.30) / 4}g"/></td>
        <td><c:out value="${caloricPlan.weight * 3.0 }g - ${caloricPlan.weight * 5.0}g"/></td>
        <td><c:out value="${caloricPlan.weight * 0.8}g - ${caloricPlan.weight * 1.5}g"/></td>
        <td><fmt:formatDate pattern="dd-MM-yyyy" value="${caloricPlan.createDate}"/></td>
        </td>
    </tr>

    </tbody>
</table>
</table>
<a href = "/caloricPlans/allCaloricPlan">Wroc do Listy Planow</a>
<a href = "/allCalculaotrs">Listy Kalkulatorow</a>
</body>
</body>
</html>