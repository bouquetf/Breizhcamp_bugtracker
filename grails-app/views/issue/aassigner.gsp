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
            <td><g:link action="assigner" params="${[id: issue.id]}">${issue.ident}</g:link></td>
            <td>${issue.titre}</td>
        </tr>
    </g:each>
    </tbody>
</table>

</body>
</html>