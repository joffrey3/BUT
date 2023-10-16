<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>calculette</title>
</head>
<body>
<h3>Table de 7</h3>
<?php
$multiple=10;
$resultat=0
if ($_GET["operande"]=="+") {
	if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]+$_GET["nombre2"]+$_GET["nombre3"];
	}
	if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]+$_GET["nombre2"]-$_GET["nombre3"];
	}
	if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]+$_GET["nombre2"]*$_GET["nombre3"];
	}
	if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]+$_GET["nombre2"]/$_GET["nombre3"];
	}
}
if ($_GET["operande"]=="-") {
		if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]-$_GET["nombre2"]+$_GET["nombre3"];
	}
	if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]-$_GET["nombre2"]-$_GET["nombre3"];
	}
	if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]-$_GET["nombre2"]*$_GET["nombre3"];
	}
	if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]-$_GET["nombre2"]/$_GET["nombre3"];
	}
}
if ($_GET["operande"]=="*") {
		if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]*$_GET["nombre2"]+$_GET["nombre3"];
	}
	if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]*$_GET["nombre2"]-$_GET["nombre3"];
	}
	if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]*$_GET["nombre2"]*$_GET["nombre3"];
	}
	if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]*$_GET["nombre2"]/$_GET["nombre3"];
	}
}
if ($_GET["operande"]=="/") {
		if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]/$_GET["nombre2"]+$_GET["nombre3"];
	}
	if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]/$_GET["nombre2"]-$_GET["nombre3"];
	}
	if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]/$_GET["nombre2"]*$_GET["nombre3"];
	}
	if ($_GET["operande"]=="+") {
		$resultat=$_GET["nombre1"]/$_GET["nombre2"]/$_GET["nombre3"];
	}
}

$resultat=$_GET["nombre1"]
echo        "<p> ".$_GET["nombre1"]." ".$_GET["operande"]." ".$_GET["nombre2"]." ".$_GET["operande2"]." ".$_GET["nombre3"]." = ".$resultat."</p>";

?>
<h4>Table de multiplication</h4>
<form method="GET">
<input type="number" name="nombre1" placeholder="nombre1">
<input type="text" name="operande" placeholder="operande">
<input type="number" name="nombre2" placeholder="nombre2">
<input type="text" name="operande2" placeholder="operande2">
<input type="number" name="nombre3" placeholder="nombre3">
<button type="submit">ENVOYER</button>
</form>
</body>
</html>