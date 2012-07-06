<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Nouvelle issue</title>
</head>

<body>
<g:form action="soumettre_nouvelle_issue" class="well span7">
    <fieldset class="span6">
        <legend>Nouvelle issue</legend>

        <div class="control-group">
            <label for="demandeur">Email</label>
            <g:textField name="demandeur" class="input-xxlarge" placeholder="Votre email..." />
        </div>

        <div class="control-group">
            <label for="titre">Titre</label>
            <g:textField name="titre" class="input-xxlarge" placeholder="Entrez un titre pour l'issue" />
        </div>

        <div class="control-group">
            <label for="description">Description</label>
            <g:textArea name="description" class="input-xxlarge" rows="5" cols="80" />
        </div>

        <div class="control-group">
            <g:submitButton class="btn btn-primary" name="Ok" />
        </div>
    </fieldset>
</g:form>

</body>
</html>