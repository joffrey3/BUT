<!DOCTYPE html>
<html>
<?php
echo "<head>";
		echo "<meta charset='UTF-8' />";
		echo "<meta name='viewport' content='initial-scale=1,witdh=device-width'>";
		echo "<title>exercice 4</title>";
		echo "<link rel='stylesheet' type='text/css' href='afficher.css'>";
	echo "</head>"
?>
<body>

<?php 
	function Afficher(Array $tab){
		foreach($tab as $cle => $valeur){
			echo "<p class='afficher' > $valeur </p>";
		}
	}
	function Ranger(Array $tab){
		foreach($tab as $cle => $valeur){
			foreach($tab as $cle2 => $valeur2){
				if ($cle<$cle+1){
					$temp=$cle+1
					$cle+1=$cle
					$cle=$temp
				}
		}
	}

	$tab=[0,0,1,6,7,8,9,10,54,87,96,87,54];
	Ranger($tab);
	Afficher($tab);
?>
</body>
</html>