<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Cookie</title>
</head>
<body>
    <h1>Edit Cookie</h1>

    <form action="<c:url value='/cookies/${cookie.cookiesId}/edit' />" method="POST">
        <input type="hidden" id="cookieId" name="cookieId" value="${cookie.cookiesId}" required>

        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${cookie.title}" required>
        <br><br>

        <button type="submit">Update Cookie</button>
    </form>

    <br>
    <a href="<c:url value='/cookies' />">
        <button type="button">Back to List</button>
    </a>
</body>
</html>
