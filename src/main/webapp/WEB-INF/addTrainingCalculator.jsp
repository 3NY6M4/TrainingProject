<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Kalkulator Treningowy</title>
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
<form:form method="post" modelAttribute="trainingCalculator" action="/trainingCalculators/addTrainingCalculator">
    <form:hidden path="id"/>
    <label>Nazwa Planu</label>
    <div>${databaseValidationError}</div>
    <form:input path="namePlan" placeholder="Wpisz Nazwe Planu"/>
    <form:errors path="namePlan"/><br/>
    <label>Rodzaj Progresji: </label><br/>
    <div>${errorRadioButton}</div>
    <form:radiobutton path="progresion" value="1.25" label=" Liniowa "></form:radiobutton>
    <form:radiobutton path="progresion" value="2.5" label=" Piramidalna "></form:radiobutton>
    <form:radiobutton path="progresion" value="5.0" label=" wg. Wendlera "></form:radiobutton>
    <br/>
    </div>
    <div>${checkoboxError}</div>
    <label>Boje Treningowe: </label><br/>
    <label>BenchPress</label>
    <form:checkbox path="benchPress" data-toggle="collapse" data-target="#bp" aria-expanded="false"
                   aria-controls="collapseExample"/>
    <form:errors path="benchPress"/>
    <div id="bp" class="collapse">
        <label>Ciężar</label>
        <form:input path="weightBp" placeholder="Wpisz ciezar"/>
        <form:errors path="weightBp"/><br/>
        <label>Liczba Powtórzeń</label>
        <form:select path="repsBp">
            <form:option  value="1.0"  label="1"/>
            <form:option  value="1.07" label="2"/>
            <form:option  value="1.12" label="3"/>
            <form:option  value="1.15" label="4"/>
            <form:option  value="1.18" label="5"/>
            <form:option  value="1.21" label="6"/>
            <form:option  value="1.24" label="7"/>
            <form:option  value="1.27" label="8"/>
            <form:option  value="1.30" label="9"/>
            <form:option  value="1.33" label="10"/>
            <form:option  value="1.36" label="11"/>
            <form:option  value="1.39" label="12"/>
            <form:errors path="repsBp"/>
        </form:select><br/>
    </div>
    <label>Deadlift</label>
    <form:checkbox path="deadlift" data-toggle="collapse" data-target="#dl" aria-expanded="false"
                   aria-controls="collapseExample"/>
    <form:errors path="deadlift"/>
    <div id="dl" class="collapse">
        <label>Ciężar</label>
        <form:input path="weightDl" placeholder="Wpisz ciezar"/>
        <form:errors path="weightDl"/><br/>
        <label>Liczba Powtórzeń</label>
        <form:select path="repsDl">
            <form:option  value="1.0"  label="1"/>
            <form:option  value="1.07" label="2"/>
            <form:option  value="1.12" label="3"/>
            <form:option  value="1.15" label="4"/>
            <form:option  value="1.18" label="5"/>
            <form:option  value="1.21" label="6"/>
            <form:option  value="1.24" label="7"/>
            <form:option  value="1.27" label="8"/>
            <form:option  value="1.30" label="9"/>
            <form:option  value="1.33" label="10"/>
            <form:option  value="1.36" label="11"/>
            <form:option  value="1.39" label="12"/>
            <form:errors path="repsDl"/>
        </form:select><br/>
    </div>
    <label>Squat</label>
    <form:checkbox path="squat" data-toggle="collapse" data-target="#sq" aria-expanded="false"
                   aria-controls="collapseExample"/>
    <form:errors path="squat"/><br/>
    <div id="sq" class="collapse">
        <label>Ciężar</label>
        <form:input path="weightSq" placeholder="Wpisz ciezar"/>
        <form:errors path="weightSq"/><br/>
        <label>Liczba Powtórzeń</label>
        <form:select path="repsSq">
            <form:option  value="1.0"  label="1"/>
            <form:option  value="1.07" label="2"/>
            <form:option  value="1.12" label="3"/>
            <form:option  value="1.15" label="4"/>
            <form:option  value="1.18" label="5"/>
            <form:option  value="1.21" label="6"/>
            <form:option  value="1.24" label="7"/>
            <form:option  value="1.27" label="8"/>
            <form:option  value="1.30" label="9"/>
            <form:option  value="1.33" label="10"/>
            <form:option  value="1.36" label="11"/>
            <form:option  value="1.39" label="12"/>
            <form:errors path="repsSq"/>
        </form:select><br/>
    </div>
    <label>Okres Czasu</label>
    <form:select path="weeks">
        <form:option value="1" label="4"/>
        <form:option value="2" label="5"/>
        <form:option value="3" label="6"/>
        <form:option value="4" label="7"/>
        <form:option value="5" label="8"/>
    </form:select><br/>
    <input type="submit" value="Dodaj Plan">
</form:form>

</body>
</html>