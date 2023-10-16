<?php
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
	}else{
		echo "échec";
	}
}else{
	echo "échec";
}
?>