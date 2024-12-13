<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Cookie Order</title>
</head>
<body>
    <h1>Edit Cookie Order</h1>

    <form action="<c:url value='/cookie-orders/${cookieOrder.cookieOrderId}/edit' />" method="POST">
        <input type="hidden" id="cookieOrderId" name="cookieOrderId" value="${cookieOrder.cookieOrderId}" required>

        <label for="storeId">Store ID:</label>
        <input type="number" id="storeId" name="storeId" value="${cookieOrder.storeId}" required>
        <br><br>

        <label for="weight">Weight:</label>
        <input type="number" step="0.01" id="weight" name="weight" value="${cookieOrder.weight}" required>
        <br><br>

        <button type="submit">Update Cookie Order</button>
    </form>

    <br>
    <a href="<c:url value='/cookie-orders' />">
        <button type="button">Back to List</button>
    </a>
</body>
</html>
