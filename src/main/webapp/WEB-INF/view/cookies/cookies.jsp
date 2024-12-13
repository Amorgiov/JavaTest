<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cookie List</title>
</head>
<body>
    <h1>Cookie List</h1>

    <a href="<c:url value='/cookies/create' />">
        <button type="button">Add New Cookie</button>
    </a>
    <br><br>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="coo" items="${cookies}">
                <tr>
                    <td><c:out value="${coo.cookieId}" /></td>
                    <td><c:out value="${coo.title}" /></td>
                    <td>
                        <a href="<c:url value='/cookies/${coo.cookieId}/edit' />">
                            <button type="button">Edit</button>
                        </a>
                        <a href="<c:url value='/cookies/${coo.cookieId}/delete' />" onclick="return confirm('Are you sure you want to delete this cookie?');">
                            <button type="button" style="color: red;">Delete</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
