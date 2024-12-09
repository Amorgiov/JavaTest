<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Cookie</title>
</head>
<body>
    <h1>Create New Cookie</h1>

    <form action="/JavaTest/cookies/create" method="POST">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>
        <br><br>

        <button type="submit">Create Cookie</button>
    </form>
</body>
</html>
