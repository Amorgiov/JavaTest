<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Store List</title>
</head>
<body>
    <h1>Store List</h1>

    <a href="<c:url value='/stores/create' />">
        <button type="button">Add New Store</button>
    </a>
    <br><br>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Cookie ID</th>
                <th>Seller ID</th>
                <th>Price</th>
                <th>Weight</th>
                <th>Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="store" items="${stores}">
                <tr>
                    <td><c:out value="${store.storeId}" /></td>
                    <td><c:out value="${store.cookie}" /></td>
                    <td><c:out value="${store.seller}" /></td>
                    <td><c:out value="${store.price}" /></td>
                    <td><c:out value="${store.weight}" /></td>
                    <td><c:out value="${store.date}" /></td>
                    <td>
                        <a href="<c:url value='/stores/${store.storeId}/edit' />">
                            <button type="button">Edit</button>
                        </a>
                        <a href="<c:url value='/stores/${store.storeId}/delete' />" onclick="return confirm('Are you sure you want to delete this store?');">
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
