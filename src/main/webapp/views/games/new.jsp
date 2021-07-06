
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add a new game</title>
</head>
<body>

<form action="/games" method="post">
    <div>
        <label>Red Team Player 1</label>
        <input type="text" id="redTeamPlayer1" name="redTeamPlayer1" value="">
    </div>
    <div>
        <label>Red Team Player 2</label>
        <input type="text" id="redTeamPlayer2" name="redTeamPlayer2" value="">
    </div>
    <div>
        <label>Red Team Score</label>
        <input type="text" id="redTeamScore" name="redTeamScore" value="">
    </div>
    <div>
        <label>Blue Team Player 1</label>
        <input type="text" id="blueTeamPlayer1" name="blueTeamPlayer1" value="">
    </div>
    <div>
        <label>Blue Team Player 2</label>
        <input type="text" id="blueTeamPlayer2" name="blueTeamPlayer2" value="">
    </div>
    <div>
        <label>Blue Team Score</label>
        <input type="text" id="blueTeamScore" name="blueTeamScore" value="">
    </div>
    <input type="submit" id="submit" name="submit">
</form>

</body>
</html>