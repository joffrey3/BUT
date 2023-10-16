<!DOCTYPE html>
<html>
<body>
<?php 

	$tab=scandir("../TP01");
	foreach($tab as $cle => $valeur){
		$lien="./".$valeur;
		$nom=$valeur;
		//print_r($nom[strlen($nom)-3]."".$nom[strlen($nom)-2]."".$nom[strlen($nom)-1]." ");
		//print_r(substr_compare($nom,"php",-3));
		if(substr_compare($nom,"php",-3)==0){
			echo "<p><a href=".$lien."> $nom </a></p>";
		}
	}
?>
</body>
</html>