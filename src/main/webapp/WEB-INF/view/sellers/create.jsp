<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Seller</title>
</head>
<body>
    <h1>Create New Seller</h1>

    <!-- Форма для добавления продавца -->
    <form action="/JavaTest/sellers/create" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br><br>

        <label for="surname">Surname:</label>
        <input type="text" id="surname" name="surname" required>
        <br><br>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" required>
        <br><br>

        <button type="submit">Create Seller</button>
    </form>

</body>
</html>
