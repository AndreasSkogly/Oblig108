<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <title>Title</title>
</head>
<body>
    <h1>Våre populære buttons!</h1>
    <class>
        <table>
            <tr>
                <th placeholder="bilde1" src=""></th>
                <th placeholder="bilde2"></th>
                <th placeholder="bilde3"></th>
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
    </class>

</body>
</html>