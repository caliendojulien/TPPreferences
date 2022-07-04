<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<style>
    * {
        color: ${couleur}
    }
</style>
<form action="/TPPreferences/affichage" method="post">
    <label for="couleur">Couleur : </label>
    <select name="couleur" id="couleur">
        <option value="red">Rouge</option>
        <option value="green">Vert</option>
        <option value="crimson">Violet</option>
        <option value="yellow">Jaune</option>
    </select>
    <input type="submit" value="Envoyyyyyyyye">
</form>
<p>
    Vous êtes venu ${compteur} fois.
</p>
</body>
</html>
