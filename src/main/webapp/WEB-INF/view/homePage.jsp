<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
</head>
<body>
    <h1>Welcome!</h1>

    <p><a href="<c:url value='/cookies' />">Cookies</a></p>
    <p><a href="<c:url value='/cookie-orders' />">Cookie Orders</a></p>
    <p><a href="<c:url value='/sellers' />">Sellers</a></p>
    <p><a href="<c:url value='/stores' />">Stores</a></p>
</body>
</html>
