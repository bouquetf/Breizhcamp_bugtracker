<%--
  Created by IntelliJ IDEA.
  User: bouquetf
  Date: 18/06/12
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Assigner issue : ${issue.titre}</title>
</head>

<body>
<g:form action="soumettre_assigner" class="well span7">
    <fieldset class="span6">
        <legend>Assigner un développeur à l'issue ${issue.ident}</legend>
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
            <g:textArea name="description" class="input-xxlarge" readonly="true" value="${issue.description}" cols="80" rows="5"/>
        </div>

        <div class="control-group">
            <label for="developpeur">Développeur assigné :</label>
            <g:textField name="developpeur" class="input-xxlarge" />
        </div>
        <g:submitButton name="Assigner" class="btn btn-primary" />
    </fieldset>

</g:form>
</body>
</html>