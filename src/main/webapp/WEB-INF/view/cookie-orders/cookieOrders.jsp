<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cookie Order List</title>
</head>
<body>
    <h1>Cookie Order List</h1>

    <a href="<c:url value='/cookie-orders/create' />">
        <button type="button">Add New Cookie Order</button>
    </a>
    <br><br>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Store ID</th>
                <th>Weight</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cookieOrder" items="${cookieOrders}">
                <tr>
                    <td><c:out value="${cookieOrder.cookieOrderId}" /></td>
                    <td><c:out value="${cookieOrder.storeId}" /></td>
                    <td><c:out value="${cookieOrder.weight}" /></td>
                    <td>
                        <a href="<c:url value='/cookie-orders/${cookieOrder.cookieOrderId}/edit' />">
                            <button type="button">Edit</button>
                        </a>
                        <a href="<c:url value='/cookie-orders/${cookieOrder.cookieOrderId}/delete' />" onclick="return confirm('Are you sure you want to delete this order?');">
                            <button type="button" style="color: red;">Delete</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
