<%--
  Created by IntelliJ IDEA.
  User: bouquetf
  Date: 18/06/12
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Evaluer la criticité</title>
</head>

<body>
<g:form action="soumettre_resoudre">
    <g:hiddenField name="id" value="${issue.id}"/>
    <fieldset>
        <div id="demandeur">
            <label for="demandeur">Demandeur</label>
            <g:textField name="email" readonly="true" value="${issue.demandeur}"/>
        </div>

        <div id="titre">
            <label for="titre">Titre</label>
            <g:textField name="titre" readonly="true" value="${issue.titre}"/>
        </div>

        <div id="description">
            <label for="description">Description</label>
            <g:textArea name="description" readonly="true" value="${issue.description}" cols="80" rows="5"/>
        </div>
    </fieldset>

    <fieldset class="buttons">
        <g:submitButton name="Résolue"/>
    </fieldset>
</g:form>

</body>
</html>