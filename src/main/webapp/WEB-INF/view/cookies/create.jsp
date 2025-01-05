<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Create Cookie</title>
    <style>
        .error {
            color: red;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <h1>Create a New Cookie</h1>
    <form:form method="post" action="${pageContext.request.contextPath}/cookies/create" modelAttribute="cookie">
        <div class="form-group">
            <form:label path="title">Title:</form:label>
            <form:input path="title" class="form-control"/>
            <form:errors path="title" cssClass="error"/>
        </div>
        <br>
        <button type="submit">Create</button>

    </form:form>
    <br>
    <a href="JavaTest/cookies">Back to List</a>
</body>
</html>
