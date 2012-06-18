<%--
  Created by IntelliJ IDEA.
  User: bouquetf
  Date: 16/06/12
  Time: 11:54
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Issues à évaluer</title>
</head>

<body>
<ul>
    <g:each in="${issueList}" var="issue">
        <li><g:link action="evaluer" params="${[id: issue.id]}">${issue.titre}</g:link></li>
    </g:each>
</ul>

</body>
</html>