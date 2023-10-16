<?php

$redis = new Redis();
$redis->connect('tp4-redis-1', 6379);
$code = $redis->get('code');

echo "
	<table>
		<tr>
			<td>SERVERNAME</td>
			<td><b>".$_SERVER['SERVER_NAME']."</b></td>
		</tr>
                <tr>
                        <td>HOSTNAME</td>
                        <td><b>".gethostname()."</b></td>
                </tr>
                <tr>
                        <td>ETUDIANT</td>
                        <td><b>".$_ENV['NOM']." / ".$_ENV['PRENOM']."</b></td>
		</tr>
               <tr>
                        <td>CODE</td>
                        <td><b>$code</b></td>
                </tr>


	</table>";
