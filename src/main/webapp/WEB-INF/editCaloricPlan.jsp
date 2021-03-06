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

<form:form method="post" modelAttribute="caloricCalculator" action="/caloricPlans/editCaloricPlan">
<form:hidden path="id"/>
<label>Nazwa Planu</label>
<form:input path="namePlan"/>
<form:errors path="namePlan"/><br/>
<label>Cel</label>
<form:select path="goal">
    <form:option value="" label=""/>
    <form:option value="Schudnac" label="Schudnac"/>
    <form:option value="Utrzymac Wage" label="Utrzymac Wage"/>
    <form:option value="Przytyc" label="Przytyc"/>
</form:select>
    <br/>
<label>Plec: </label>
<form:radiobutton path="gender" value="0" label="Mezczyzna"></form:radiobutton>
<form:radiobutton path="gender" value="1" label="Kobieta"></form:radiobutton>
<br/>
<label>Typ Budowy Ciala / Aktywnosc Fizyczna</label>
    <form:select path="type">
        <form:option value="0" label=""/>
    <optgroup label="Ektomorfik">
    <form:option value="700" label="Niska 700KCAL"/>
    <form:option value="800" label="Srednia 800KCAL"/>
    <form:option value="900" label="Wysoka 900KCAL"/>
    </optgroup>
    <optgroup label="Mezomorfik">
        <form:option value="400" label="Niska 400KCAL"/>
        <form:option value="450" label="Sredna 550KCAL"/>
        <form:option value="500" label="Wysoka 500KCAL"/>
    </optgroup>
    <optgroup label="Enodmorfik">
        <form:option value="200" label="Niska 200KCAL"/>
        <form:option value="300" label="Sredna 300KCAL"/>
        <form:option value="400" label="Wysoka 400KCAL"/>
    </optgroup>
</form:select><br/>
<label>Endomorfik ??? osoba charakteryzuj??ca si?? ci????k?? budow?? cia??a, roz??o??ystym i grubym szkieletem, wolnym metabolizmem, a wi??c du???? mas?? zar??wno mi????niow??, jak i t??uszczow??, z tendencj?? do tycia.</label></br>

<label>Mezomorfik ??? osoba o cechach sylwetki i metabolizmu po??rednich mi??dzy ektomorfikiem, a endomorfikiem, o proporcjonalnej budowie, ??rednim tempie przemiany materii i tendencji do ??atwego zwi??kszania masy mi????niowej.</label></br>

<label>Ektomorfik ??? osoba charakteryzuj??ca si?? bardzo szczup???? budow?? cia??a (chud?? szyj??, w??t???? klatk?? piersiow??), ma??o roz??o??ystym i lekko zbudowanym szkieletem, brakiem ot??uszczenia oraz szybkim metabolizmem.</label></br>
<label>Waga</label>
<form:input path="weight"/>
<form:errors path="weight"/><br/>
<label>Wzrost</label>
<form:input path="height"/>
<form:errors path="height"/><br/>
<label>Wiek</label>
<form:input path="age"/>
<form:errors path="age"/><br/>
<label>Aktywno???? Fizyczna</label>
    <form:select path="activity">
        <form:option value="0" label=""/>
        <form:option value="31" label="Niska"/>
        <form:option value="33" label="??rednia"/>
        <form:option value="35" label="Wysoka"/>
    </form:select><br/>
    <input type="submit" value="Aktualizuj Plan">
    </form:form>
</body>
</html>