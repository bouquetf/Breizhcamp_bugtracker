<%--
  Created by IntelliJ IDEA.
  User: bouquetf
  Date: 16/06/12
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Breizhcamp Issue Tracker - <g:layoutTitle/></title>
    <g:layoutHead/>
</head>

<body>

<div id="menu">
    <ul>
        <li><g:link action="nouvelle_issue">Nouvelle issue</g:link></li>
        <li><g:link action="aresoudre">A résoudre</g:link></li>
        <li><g:link action="aevaluer">A évaluer</g:link></li>
        <li><g:link action="aassigner">A assigner</g:link></li>
        <li><g:link action="list">Admin</g:link></li>
    </ul>

</div>

<div id="content">
    <g:layoutBody/>
</div>

</body>
</html>