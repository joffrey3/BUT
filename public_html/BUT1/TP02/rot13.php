 <!DOCTYPE html>
       <html>
           <body>
       
                <?php
               		echo str_rot13($_GET["clair"]);
                	echo "<br>";
                	if($_GET["clair"]==str_rot13($_GET["chiffre"])){
                  		echo str_rot13($_GET["chiffre"]);
              		}else{
              			echo "???";
              		}
               ?>
       
          </body>
       </html>