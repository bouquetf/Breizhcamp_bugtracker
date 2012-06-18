<%--
  Created by IntelliJ IDEA.
  User: bouquetf
  Date: 18/06/12
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Issues à assigner</title>
</head>

<body>
<ul>
    <g:each in="${issueList}" var="issue">
        <li><g:link action="assigner" params="${[id: issue.id]}">${issue.titre}</g:link></li>
    </g:each>
</ul>
</body>
</html>