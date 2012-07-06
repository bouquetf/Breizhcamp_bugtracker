<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="fr">
<head>
    <title>Breizhcamp Issue Tracker - <g:layoutTitle/></title>
    <r:require modules="bootstrap"/>
    <g:layoutHead/>
    <r:layoutResources/>
</head>

<body>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span2" style="margin-top:70px;">
            <ul class="nav nav-tabs nav-stacked">
                <li><g:link action="nouvelle_issue">Nouvelle issue</g:link></li>
                <li><g:link action="aresoudre">A résoudre</g:link></li>
                <li><g:link action="aevaluer">A évaluer</g:link></li>
                <li><g:link action="aassigner">A assigner</g:link></li>
                <li><g:link action="list">Admin</g:link></li>
            </ul>
        </div>

        <div class="span10" style="margin-top: 70px">
            <g:layoutBody/>
            <r:layoutResources/>
        </div>
    </div>
</div>
</body>
</html>