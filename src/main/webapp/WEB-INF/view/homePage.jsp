<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <title>Печеньковый_путеводитель</title>
    </head>
    <body>
        <h1>Добро пожаловать путник, выбирай с умом куда дальше путь держать будешь:</h1>
        <h3>
            <p>
                К <a href="<c:url value='/cookies' />">Cookies</a> потопаешь — печеньками тебя так затрамбуют, что и рта не открыть!
                <span style="font-size: 20px;"⇛</span>
            </p>
        </h3>
        <h3>
            <p>
                К <a href="<c:url value='/cookie-orders' />">CookieOrder</a> завернёшь — подписывать приказы да накладные будешь до посинения, а вместо чернил — варенье липкое!
                <span style="font-size: 20px;"⇛</span>
            </p>
        </h3>
        <h3>
            <p>
                К <a href="<c:url value='/sellers' />">Seller</a> вломишься — хитрый торгаш сдерёт с тебя три шкуры и заставит купить три тонны просроченных пряников!
                <span style="font-size: 20px;"⇛</span>
            </p>
        </h3>
        <h3>
            <p>
                А в <a href="<c:url value='/stores' />">Store</a> сунешься — сторож этот, дубиной размахивая, башку тебе так протрясёт, что из ушей крошки полетят!
                <span style="font-size: 20px;"⇛</span>
            </p>
        </h3>
    </body>
</html>