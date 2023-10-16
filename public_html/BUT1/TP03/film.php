<?php
$login=$_POST['titre'] ?? NULL;
$mdp=$_POST['année'] ?? NULL;
include "info.php";
$hashed_mdp=password_hash("$mdp",PASSWORD_DEFAULT);
$sql2 = "SELECT Titre,Année,Genre FROM Film NATURAL JOIN Artiste;";
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