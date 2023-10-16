<?php
$login=$_COOKIE['login'] ?? NULL;
$mdp=$_COOKIE['mdp'] ?? NULL;
?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>entier</title>
</head>
<body>
<?php
$n=0;
$m=100;
$alea=rand($n,$m);
echo "$alea";
setcookie('alea',$alea,time()+3600);
?>
</body>
</html>