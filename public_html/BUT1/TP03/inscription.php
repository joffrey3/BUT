<?php
$login=$_POST['login'] ?? NULL;
$mdp=$_POST['mdp'] ?? NULL;
include "info.php";
$hashed_mdp=password_hash("$mdp",PASSWORD_DEFAULT);
$sql2 = "SELECT login FROM user WHERE login = '$login';";
$sql = "INSERT INTO user VALUES ('$login','$hashed_mdp');";
$res=mysqli_query($conn,$sql2);
$row=mysqli_fetch_assoc($res);
if ($row==null){
	mysqli_query($conn,$sql);
	echo "Inscription réussi! Nouveau Utilisateur";
}else{
	echo "Inscription raté! Utilisateur déjà existant";
}
?>