<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Cookie Order</title>
</head>
<body>
    <h1>Create New Cookie Order</h1>

    <form action="/JavaTest/cookie-orders/create" method="POST">
        <label for="store_id">Store ID:</label>
        <input type="number" id="storeId" name="storeId" required>
        <br><br>

        <label for="weight">Weight:</label>
        <input type="number" step="0.01" id="weight" name="weight" required>
        <br><br>

        <button type="submit">Create Cookie Order</button>
    </form>
</body>
</html>
