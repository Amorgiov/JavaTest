<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Cookie</title>
</head>
<body>
    <h1>Edit Cookie</h1>
    <form:form method="post" action="/cookies/${cookieItem.cookieId}/edit" modelAttribute="cookieItem">
        <form:label path="title">Title:</form:label>
        <form:input path="title" required="true"/>

        <form:errors path="title" cssClass="error"/>

        <button type="submit">Update</button>
    </form:form>
    <br>
    <a href="/cookies">Back to List</a>
</body>
</html>
