<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="bilgeadam" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Abone sayfası</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<h2 class="text-primary">Abone Sayfasına Hoşgeldiniz</h2>

private int ;
private String ;
private String ;
private String ;
private String ;
private Date creationDate;

<div class="container bg-dark  text-white mt-5">
    <h2 class="text-danger text-center display-2">Writer Form</h2>
    <bilgeadam:form method="post" modelAttribute="validation_key">
        <fieldset class="form-group">
            <bilgeadam:label path="subScriberId">Writer ID</bilgeadam:label>
            <bilgeadam:input cssClass="form-control" path="subScriberId" disabled="false"/>
        </fieldset>

        <fieldset class="form-group">
            <bilgeadam:input cssClass="form-control" path="subScriberName"/>

        </fieldset>

        <fieldset class="form-group">
            <bilgeadam:input cssClass="form-control" path="subScriberSurname"/>

        </fieldset>

        <fieldset class="form-group">
            <bilgeadam:input cssClass="form-control" path="subScriberAddress"/>

        </fieldset>

        <fieldset class="form-group">
            <bilgeadam:input cssClass="form-control" path="subScriberEmailAddress"/>
<%--            <form:errors path=""/>--%>
        </fieldset>

        <input type="reset" class="btn btn-danger mb-5" value="Temizle"/>
        <input type="submit" class="btn btn-primary mb-5" value="Gönder"/>
    </bilgeadam:form>
</div>
<br><br><br><br>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
</body>
</html>