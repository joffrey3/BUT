<!DOCTYPE html>
<html>
<body>
<?php 
	$tab=scandir("../TP01");
	foreach($tab as $cle => $valeur){
		if($cle>=2){
			$lien="./".$valeur;
			$nom=$valeur;
			echo "<p><a href=".$lien."> $nom </a></p>";
		}
	}
?>
</body>
</html>