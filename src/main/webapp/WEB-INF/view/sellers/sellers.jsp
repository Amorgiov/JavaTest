<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seller List</title>
</head>
<body>
    <h1>Seller List</h1>

    <c:if test="${not empty message}">
        <p><c:out value="${message}" /></p>
    </c:if>

    <a href="<c:url value='/sellers/create' />">
        <button type="button">Add New Seller</button>
    </a>
    <br><br>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="seller" items="${sellers}">
                <tr>
                    <td><c:out value="${seller.sellerId}" /></td>
                    <td><c:out value="${seller.name}" /></td>
                    <td><c:out value="${seller.surname}" /></td>
                    <td><c:out value="${seller.phone}" /></td>
                    <td>
                        <a href="<c:url value='/sellers/${seller.sellerId}/edit' />">
                            <button type="button">Edit</button>
                        </a>
                        <a href="<c:url value='/sellers/${seller.sellerId}/delete' />" onclick="return confirm('Are you sure you want to delete this seller?');">
                            <button type="button">Delete</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <p>
        <a href="<c:url value='/' />">
            <button type="button">Go to Cookie Guide</button>
        </a>
    </p>
</body>
</html>
