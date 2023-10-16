<!DOCTYPE html>
<html>
<body>
<?php 
	for($i=1;$i<=50;$i++){
		if($i%2==0){
			echo "<p><b>$i</b></p>";
		}
		if($i%2==1){
			echo "<p><i>$i</i></p>";
		}
	}
?>
</body>
</html>