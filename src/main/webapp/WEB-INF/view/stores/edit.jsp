<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Store</title>
</head>
<body>
    <h1>Edit Store</h1>

    <form action="<c:url value='/stores/${store.storeId}/edit' />" method="POST">
        <input type="hidden" id="storeId" name="storeId" value="${store.storeId}" required>

        <label for="cookie">Cookie ID:</label>
        <input type="number" id="cookie" name="cookie" value="${store.cookie}" required>
        <br><br>

        <label for="seller">Seller ID:</label>
        <input type="number" id="seller" name="seller" value="${store.seller}" required>
        <br><br>

        <label for="price">Price:</label>
        <input type="number" step="0.01" id="price" name="price" value="${store.price}" required>
        <br><br>

        <label for="weight">Weight:</label>
        <input type="number" step="0.01" id="weight" name="weight" value="${store.weight}" required>
        <br><br>

        <label for="date">Date:</label>
        <input type="date" id="date" name="date" value="${store.date}" required>
        <br><br>

        <button type="submit">Update Store</button>
    </form>

    <br>
    <a href="<c:url value='/stores' />">
        <button type="button">Back to List</button>
    </a>
</body>
</html>
