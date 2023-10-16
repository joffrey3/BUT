<!DOCTYPE html>
<html>
<body>
<?php 
	for($i=0;$i<50;$i=$i+10){
	echo "<p>";
		for($j=1;$j<=10;$j++){
			echo " ".($i + $j)." ";
		}
	echo "</p>";
	}
?>
</body>
</html>