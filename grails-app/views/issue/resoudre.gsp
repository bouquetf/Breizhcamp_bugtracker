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
<g:form action="soumettre_resoudre" class="well span7">
    <fieldset class="span6">
        <legend>Résoudre l'issue ${issue.ident}</legend>
        <g:hiddenField name="id" value="${issue.id}"/>

        <div>
            <label for="email">Demandeur</label>
            <g:textField name="email" class="input-xxlarge" readonly="true" value="${issue.demandeur}"/>
        </div>

        <div>
            <label for="titre">Titre</label>
            <g:textField name="titre" class="input-xxlarge" readonly="true" value="${issue.titre}"/>
        </div>

        <div>
            <label for="description">Description</label>
            <g:textArea name="description" class="input-xxlarge" readonly="true"
                        value="${issue.description}" cols="80" rows="5"/>
        </div>

        <g:submitButton name="Résolue" class="btn btn-primary" />
    </fieldset>
</g:form>

</body>
</html>