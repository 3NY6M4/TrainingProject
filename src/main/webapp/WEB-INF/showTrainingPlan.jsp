<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>TrainingPlans List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
</head>
<body>
<table border="1">
    <thead>
    <th>Nazwa Planu</th>
    <th>Data Startu</th>
    <th>Data Zakonczenia</th>
    <th>Tydzien 1</th>
    <th>WL</th>
    <th>DL</th>
    <th>SQ</th>
    <th>Tydzien 2</th>
    <th>WL</th>
    <th>DL</th>
    <th>SQ</th>
    <th>Tydzien 3</th>
    <th>WL</th>
    <th>DL</th>
    <th>SQ</th>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${trainingPlan.namePlan}"/></td>
        <td><fmt:formatDate pattern="dd-MM-yyyy" value="${trainingPlan.createDate}"/></td>
        <td><fmt:formatDate pattern="dd-MM-yyyy" value="${trainingPlan.finishDate}"/></td>
        <td><c:out value="${trainingPlan.weeks}"/></td>
        <td><fmt:formatNumber value="${trainingPlan.weightBp}" maxFractionDigits="1"/></td>
        <td><fmt:formatNumber value="${trainingPlan.weightDl}" maxFractionDigits="1"/></td>
        <td><fmt:formatNumber value="${trainingPlan.weightSq}" maxFractionDigits="1"/></td>
        <td>
        </td>
    </tr>

    </tbody>
</table>
<a href = "/trainingPlans/allTrainingPlan">Wroc do Listy Planow</a>
</body>
</html>