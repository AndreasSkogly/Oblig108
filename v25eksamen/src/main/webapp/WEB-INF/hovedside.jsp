<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>


    <title>Title</title>
</head>
<body>
    <h1>Våre populære buttons!</h1>
    <div>
        <table>
            <tr>
                <th><img src="${pageContext.request.contextPath}/resources/bilder/knapp1.png" alt="bilde1"></th>
                <th><img src="${pageContext.request.contextPath}/resources/bilder/knapp2.png" alt="bilde2"></th>
                <th><img src="${pageContext.request.contextPath}/resources/bilder/knapp3.png" alt="bilde3"></th>
            </tr>
            <tr>
                <th>${knapp1.navn} navn1</th>
                <th>${knapp2.navn} navn2</th>
                <th>${knapp3.navn} navn3</th>
            </tr>
            <tr>
                <th>${knapp1.pris}1</th>
                <th>${knapp2.pris}2</th>
                <th>${knapp3.pris}3</th>
            </tr>
            <tr>
                <th>Antall: <input type="number"> <button type="submit">Legg til i handlekurv</button></th>
                <th>Antall: <input type="number"> <button type="submit">Legg til i handlekurv</button></th>
                <th>Antall: <input type="number"> <button type="submit">Legg til i handlekurv</button></th>
            </tr>
        </table>
    </div>

</body>
</html>