<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>multiplication</title>
</head>
<body>
<h3>Table de 7</h3>
<?php
$multiple=10;
echo    "<ul>";
for($i=0;$i<=$multiple;$i++){
echo        "<li> $i x ".$_GET["table"]." = ".$i*$_GET["table"]."</li>";
}

?>
</ul>
<h4>Table de multiplication</h4>
<form method="GET">
<input type="number" name="table" placeholder="table">
<button type="submit">ENVOYER</button>
</form>
</body>
</html>