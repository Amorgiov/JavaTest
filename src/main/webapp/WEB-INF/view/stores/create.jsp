<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Store</title>
</head>
<body>
    <h1>Create New Store</h1>

    <form action="/JavaTest/stores/create" method="POST">
        <label for="cookie">Cookie ID:</label>
        <input type="number" id="cookie" name="cookie" required>
        <br><br>

        <label for="seller">Seller ID:</label>
        <input type="number" id="seller" name="seller" required>
        <br><br>

        <label for="price">Price:</label>
        <input type="number" step="0.01" id="price" name="price" required>
        <br><br>

        <label for="weight">Weight:</label>
        <input type="number" step="0.01" id="weight" name="weight" required>
        <br><br>

        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required>
        <br><br>

        <button type="submit">Create Store</button>
    </form>
</body>
</html>
