<!DOCTYPE html>
<html>
<?php
echo "<head>";
		echo "<meta charset='UTF-8' />";
		echo "<meta name='viewport' content='initial-scale=1,witdh=device-width'>";
		echo "<title>exercice 4</title>";
		echo "<link rel='stylesheet' type='text/css' href='afficher.css'>";
	echo "</head>";
?>
<body>

<?php 
	function Afficher(Array $tab){
		echo "<thead><tr>";
		foreach($tab as $cle => $valeur){
			echo "<th>$cle :</th>";
		}
		echo "</tr></thead>";
		echo "<tbody><tr>";
		foreach($tab as $cle => $valeur){
			echo "<td>$valeur</td>";
		}
		echo "</tr></tbody>";
	}

	$tab=[0,0,1,6,7,8,9,10,54,87,96,87,54];
	Afficher($tab);
?>
</body>
</html>