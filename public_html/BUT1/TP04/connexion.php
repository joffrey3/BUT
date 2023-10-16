<?php
$alea=$_COOKIE['alea'] ?? NULL;
if($alea==NULL){
$n=0;
$m=100;
$alea=rand($n,$m);
}
echo "$alea";
echo "<br>";
setcookie('alea',$alea,time()+3600);
$nb=$_POST['mdp'] ?? NULL;
echo "$nb";
echo "<br>";
if($nb>$alea){
	echo "plus grand";
	echo "<br>";
}if($nb<$alea){
	echo "plus petit";
	echo "<br>";
}
if($nb==$alea){
	echo "gagné";
	echo "<br>";
}
$souvenir=$_POST['souvenir'] ?? NULL;
$login=$_POST['login'] ?? NULL;
$mdp=$_POST['mdp'] ?? NULL;
include "info.php";
$sql = "SELECT mdp FROM user WHERE login = '$login';";
$res = mysqli_query ($conn,$sql);
$row=mysqli_fetch_assoc($res);
if ($row != null){
	$hashed_mdp=$row['mdp'];
	if(password_verify($mdp,$hashed_mdp)){
		echo "Succès";
		echo "<br>";
	}else{
		echo "échec";
		echo "<br>";
	}
}else{
	echo "échec";
	echo "<br>";
}

if($souvenir != NULL){
	setcookie('login',$login,time()+3600);
	setcookie('mdp',$mdp,time()+3600);
	echo "Cookie enregistré";
}else{
	setcookie('login',$login,0);
	setcookie('mdp',$mdp,0);
	echo "Cookie non enregistré";
}
?>