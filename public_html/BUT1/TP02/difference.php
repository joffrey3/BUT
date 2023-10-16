<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<h1>Difference</h1>

    <?php
        $a1=explode(" ","le la les de du au à quel quelle il elle tu je nous vous ils mais ou et donc or ni car zouave étudiant athlète");
        $a2=explode(" ","bien bien bien bien");
        $result=array_diff($a2,$a1);
        $chaine="";
        $tableau=[""];
        foreach ($result as $c=>$v){
            $flag=0;
            foreach ($tableau as $cle=>$valeur){
                print_r($valeur);
                if ($result[$c]==$tableau[$cle]){
                    $flag=1;
                }
            }
            if ($flag==0) {
                $chaine=$chaine." $result[$c]";
            }
        }
        print_r($chaine);
    ?>
</body>
</html>
