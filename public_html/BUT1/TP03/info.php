<?php
$host="dwarves.iut-fbleau.fr";
$user="fouche";
$password="FOUCHE Jojo 0103";
$bd="fouche";
$conn=mysqli_connect($host,$user,$password,$bd);
if (!$conn){
	die("PB BD");
}
?>