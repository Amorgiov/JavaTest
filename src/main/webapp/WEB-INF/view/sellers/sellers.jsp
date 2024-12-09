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

    <!-- Сообщение об успешном добавлении, обновлении или удалении -->
    <c:if test="${not empty message}">
        <p style="color: green;"><c:out value="${message}" /></p>
    </c:if>

    <!-- Кнопка для добавления нового продавца -->
    <a href="<c:url value='/sellers/create' />">
        <button type="button">Add New Seller</button>
    </a>
    <br>

    <!-- Таблица с продавцами -->
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
                        <!-- Кнопка Изменить -->
                        <a href="<c:url value='/sellers/${seller.sellerId}/edit' />">
                            <button type="button">Edit</button>
                        </a>

                        <!-- Кнопка Удалить -->
                        <a href="<c:url value='/sellers/${seller.sellerId}/delete' />" onclick="return confirm('Are you sure you want to delete this seller?');">
                            <button type="button" style="color: red;">Delete</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>



</body>
</html>
