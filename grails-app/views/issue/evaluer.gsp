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
    <title>Evaluer la criticité de l'issue : ${issue.ident}</title>
</head>

<body>
<g:form class="well span7">
    <fieldset class="span6">
    <legend>Evaluer l'issue ${issue.ident}</legend>
    <g:hiddenField name="id" value="${issue.id}"/>

        <div class="control-group">
            <label for="email">Demandeur</label>
            <g:textField name="email" class="input-xxlarge" readonly="true" value="${issue.demandeur}"/>
        </div>

        <div class="control-group">
            <label for="titre">Titre</label>
            <g:textField name="titre" class="input-xxlarge" readonly="true" value="${issue.titre}"/>
        </div>

        <div class="control-group">
            <label for="description">Description</label>
            <g:textArea name="description" class="input-xxlarge" readonly="true" value="${issue.description}"
            rows="5" cols="80"/>
        </div>

        <g:actionSubmit value="Valider" action="valider_evaluation" class="btn btn-primary"/>
        <g:actionSubmit value="Refuser" action="refuser_evaluation" class="btn"/>
    </fieldset>
</g:form>

</body>
</html>