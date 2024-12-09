<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Seller</title>
</head>
<body>
    <h1>Edit Seller</h1>

    <form action="<c:url value='/sellers/${seller.sellerId}/edit' />" method="POST">
        <input type="hidden" id="sellerId" name="sellerId" value="${seller.sellerId}" required>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${seller.name}" required>
        <br><br>

        <label for="surname">Surname:</label>
        <input type="text" id="surname" name="surname" value="${seller.surname}" required>
        <br><br>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" value="${seller.phone}" required>
        <br><br>

        <button type="submit">Update Seller</button>
    </form>

    <br>
    <a href="<c:url value='/sellers' />">
        <button type="button">Back to List</button>
    </a>
</body>
</html>
