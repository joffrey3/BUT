<?php

function encodep($text) {
     $data = mb_convert_encoding($text, "UTF-8", mb_detect_encoding($text));
     $compressed = gzdeflate($data, 9);
     return encode64($compressed);
}

function encode6bit($b) {
     if ($b < 10) {
          return chr(48 + $b);
     }
     $b -= 10;
     if ($b < 26) {
          return chr(65 + $b);
     }
     $b -= 26;
     if ($b < 26) {
          return chr(97 + $b);
     }
     $b -= 26;
     if ($b == 0) {
          return '-';
     }
     if ($b == 1) {
          return '_';
     }
     return '?';
}

function append3bytes($b1, $b2, $b3) {
     $c1 = $b1 >> 2;
     $c2 = (($b1 & 0x3) << 4) | ($b2 >> 4);
     $c3 = (($b2 & 0xF) << 2) | ($b3 >> 6);
     $c4 = $b3 & 0x3F;
     $r = "";
     $r .= encode6bit($c1 & 0x3F);
     $r .= encode6bit($c2 & 0x3F);
     $r .= encode6bit($c3 & 0x3F);
     $r .= encode6bit($c4 & 0x3F);
     return $r;
}

function encode64($c) {
     $str = "";
     $len = strlen($c);
     for ($i = 0; $i < $len; $i+=3) {
            if ($i+2==$len) {
                  $str .= append3bytes(ord(substr($c, $i, 1)), ord(substr($c, $i+1, 1)), 0);
            } else if ($i+1==$len) {
                  $str .= append3bytes(ord(substr($c, $i, 1)), 0, 0);
            } else {
                  $str .= append3bytes(ord(substr($c, $i, 1)), ord(substr($c, $i+1, 1)),
                      ord(substr($c, $i+2, 1)));
            }
     }
     return $str;
}



$encode = encodep("
@startgantt
<style>
ganttDiagram {
  task {
    BackGroundColor GreenYellow
    LineColor Green 
    unstarted {
      BackGroundColor Fuchsia 
      LineColor FireBrick
    }
  }
}
</style>
language fr
Project starts ".date('Y-m-d')."
[Tache1] lasts 4 days
then [Tache1.1] lasts 4 days
[Tache1.2] starts at [Tache1]'s end and lasts 7 days

[Tache2] lasts 5 days
then [Tache2.1] lasts 4 days

[MaxTacheEnd] happens at [Tache1.1]'s end
[MaxTacheEnd] happens at [Tache1.2]'s end
[MaxTacheEnd] happens at [Tache2.1]'s end

[Tache1.1] is ".$_ENV["POURCENTAGE_TACHE11"]."% complete
[Tache1.2] is ".$_ENV["POURCENTAGE_TACHE12"]."% complete
[Tache2.1] is ".$_ENV["POURCENTAGE_TACHE21"]."% complete

@endgantt
");
echo "<p align='center'>
<b>Mon premier Diagramme de Gantt</b>.<br/><br/>

Etudiant :<br/>
NOM : <b>".$_ENV["NOM"]."</b> - PRENOM : <b>".$_ENV["PRENOM"]."</b>

<br/><br/><img src='http://localhost:8080/png/{$encode}' alt='Erreur de liaison avec le conteneur plantuml'>

<br/><br/><br/>
SERVEUR PHP : <br/><b>".gethostname()."</b>";
?>
