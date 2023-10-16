<?php
$login=$_COOKIE['login'] ?? NULL;
$mdp=$_COOKIE['mdp'] ?? NULL;
?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>connexion</title>
</head>
<body>
<form method="POST" action="connexion.php">
	<label for="login">Login <br>
	<input type="text" id="login" name="login" value="<?php echo "$login";?>"> <br>
	</label>
	<label for="mdp">Password <br>
	<input type="password"  id="mdp" name="mdp" value="<?php echo "$mdp";?>"> <br>
	</label>
	<label for="mdp">entier <br>
	<input type="text"  id="nombre" name="nombre"> <br>
	</label>
	<label>
	<input type="checkbox"  id="souvenir" name="souvenir"> 
	Se souvenir de moi<br>
	</label>
	<button type="submit">ENVOYER</button>
</form>
<?php
	echo "<p> $login </p>";
	echo "<p> $mdp </p>";
	echo "<p> test </p>";
?>
</body>
</html>