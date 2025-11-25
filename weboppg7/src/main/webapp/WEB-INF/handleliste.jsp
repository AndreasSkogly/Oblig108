<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <title>Handleliste</title>
</head>
<body>

<h1>Handleliste</h1>

<form action="${pageContext.request.contextPath}/handleliste/leggTil" method="post">
    <input type="text" name="vare" placeholder="Legg til vare" required>
    <button type="submit">Legg til</button>
</form>

<ul>
    <c:forEach var="vare" items="${handleliste}">
        <li>
                ${vare}
            <form style="display:inline" action="${pageContext.request.contextPath}/handleliste/slett" method="post">
                <input type="hidden" name="vare" value="${vare}">
                <button type="submit">Slett</button>
            </form>
        </li>
    </c:forEach>
</ul>

</body>
</html>
