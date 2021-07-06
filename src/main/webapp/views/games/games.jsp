<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Games</title>
</head>
<body>
    <c:set var="games" value="${requestScope.games}"/>

    <c:forEach items="${games}" var="game">
        <li>
            Red team Player 1: <c:out value="${game.redTeamPlayer1}" />
            Red team Player 2: <c:out value="${game.redTeamPlayer2}" />
            Red team Score: <c:out value="${game.redTeamScore}" />
            blue team Player 1: <c:out value="${game.blueTeamPlayer1}" />
            blue team Player 2: <c:out value="${game.blueTeamPlayer2}" />
            blue team Score: <c:out value="${game.blueTeamScore}" />

            <c:if test="${game.redTeamScore < game.blueTeamScore}" >
                <c:out value="Blue Team Wins!" />
            </c:if>
            <c:if test="${game.redTeamScore > game.blueTeamScore}" >
                <c:out value="Red Team Wins!" />
            </c:if>
        </li>
    </c:forEach>
</body>
</html>