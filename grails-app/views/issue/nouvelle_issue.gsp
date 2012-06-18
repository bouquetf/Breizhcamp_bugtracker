<%--
  Created by IntelliJ IDEA.
  User: bouquetf
  Date: 16/06/12
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Nouvelle issue</title>
</head>

<body>
<g:form action="soumettre_nouvelle_issue">
    <fieldset>
        <div class="fieldcontain">
            <label for="demandeur">Email</label>
            <g:textField name="demandeur"/>
        </div>

        <div class="fieldcontain">
            <label for="titre">Titre</label>
            <g:textField name="titre"/>
        </div>

        <div class="fieldcontain">
            <label for="description">Description</label>
            <g:textArea name="description" rows="5" cols="80"/>
        </div>
    </fieldset>
    <fieldset class="bouton">
        <g:submitButton name="Ok"/>
    </fieldset>
</g:form>

</body>
</html>