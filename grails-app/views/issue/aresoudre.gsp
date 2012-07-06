<%--
  Created by IntelliJ IDEA.
  User: bouquetf
  Date: 16/06/12
  Time: 11:54
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Issues à résoudre</title>
</head>

<body>
<table class="table span8">
    <thead>
    <tr>
        <th class="span2">Id</th>
        <th class="span6">Title</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${issueList}" var="issue">
        <tr>
            <td><g:link action="resoudre" params="${[id: issue.id]}">${issue.ident}</g:link></td>
            <td>${issue.titre}</td>
        </tr>
    </g:each>
    </tbody>
</table>

</body>
</html>