<!DOCTYPE html>
<?php
$tab_etu=array(array("0","Bernard","Torna"),array('1','Jean','Caloch'),array('2','Julie','Botu'),array('3','Hugo','Harne'),array('4','Perséphone','Manne'),array('5','Bhavana','Hyve'),array('6','Paul','Henry'),array('7','Terrence','Janeau'),array('8','Will','Smith'),array('9','Stéphane','Bern'),array("10","Christian","Bale"),array('11','Hugh','Jackman'),array('12','Tom','Holland'),array('13','Bernard','Tapis'),array('14','Tom','Pepin'),array('15','Laeticia','Zala'),array('16','Melyssa','Kirna'),array('17','Karine','Justin'),array('18','Richard','Ricard'),array('19','Nathalie','Portman'),array("20","Solène","Pluie"),array('21','Corentin','Pastèque'),array('22','Victor','Salimor'),array('23','Hélène','Chartra'),array('24','Nora','Tholane'),array('25','Viviane','Pimana'),array('26','Yvette','Ralette'),array('27','Luc','Besson'),array('28','Brigitte','Jostin'),array('29','Nina','Parsec'),array("30","Armèle","Atlas"),array('31','Gerard','Mopin'),array('32','Fabrice','Ytamine'),array('33','Yannis','Paulin'),array('34','Mat','Damon'),array('35','Trevor','Greg'),array('36','Romane','Kilmar'),array('37','Yun','Pan'),array('38','Fabio','Rolac'),array('39','Maggie','Smith'));
//$tab_grp=array(array("0","groupe0","10","0","10"),array("1","groupe1","10","0","10"),array("2","groupe2","10","0","10"),array("3","groupe3","10","0","10"),array("4","groupe4","10","0","10"),array("5","groupe5","10","0","10"),array("6","groupe6","10","0","10"),array("7","groupe7","10","0","10"),array("8","groupe8","10","0","10"),array("9","groupe9","10","0","10"));
//$tab_grp=array(array("0","groupe0","10","0","10"),array("0","groupe0","10","0","10"),array("1","groupe1","10","0","10"),array("2","groupe2","10","0","10"),array("3","groupe3","10","0","10"),array("4","groupe4","10","0","10"),array("5","groupe5","10","0","10"),array("6","groupe6","10","0","10"),array("7","groupe7","10","0","10"),array("8","groupe8","10","0","10"),array("9","groupe9","10","0","10"));
?>
<html>
    <head>
        <meta charset="UTF-8" />
		<meta name="viewport" content="initial-scale=1,witdh=device-width">  
		<title>RechercheEnseignant</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
    </head>
    <body>

    <header>
  <!-- Sidebar -->
<div class="w3-sidebar w3-bar-block w3-border-right" style="display:none" id="mySidebar">
  <button onclick="w3_close()" class="w3-bar-item w3-large">Close &times;</button>
  <a href="../../../~nevejans/projet_gestion_de_groupes/Admin/admin.html" class="w3-bar-item w3-button">Administrateur</a>
  <a href="../../../~brinet/eleveChangerGroupe.php" class="w3-bar-item w3-button">Eleve</a>
  <a href="../../../~fouche/projetWilliam/RechercheProf.php" class="w3-bar-item w3-button">Professeur</a>
</div>

<!-- Page Content -->
<div class="w3-row">
    <div class="w3-center w3-padding w3-border w3-rest w3-teal">
    <div class="w3-col" style="width:150px"><button class="w3-button w3-teal w3-xlarge" onclick="w3_open()">☰</button></div>
  <div class="w3-rest w3-teal"><p>Professeur</p></div>
</div> 

</header>
		<section>
        <div class="w3-display-container w3-container w3-green " style="width:100%;height: 50px;">
            <div class="w3-container w3-display-middle">
                <article>
                    <label><h2>Barre de recherche</h2></label>
                </article>
            </div>    
        </div>
        <div>
            <form>
                <div class=" w3-container w3-yellow" style="width:100%;height: 50px;">
                    <article>
                        <input class=" w3-border w3-input" name="first" type="text" style="width:100%;">
                    </article>
                </div>
                <article>
                    <table class="w3-border" style="width:100%;">
                        <tr class="w3-border">
                            <th class="w3-border">id</th>
                            <th class="w3-border">nom</th>
                            <th class="w3-border">prenom</th>
                            <!--<th class="w3-border">Voir les groupes</th>-->
                        </tr>
<?php
for ($i=0;$i<count($tab_etu);$i++){
    echo '<tr class="w3-border">';
        echo '<td class="w3-border"> '.$tab_etu[$i][0].'</td>';
        echo '<td class="w3-border"> '.$tab_etu[$i][1].'</td>';
        echo '<td class="w3-border"> '.$tab_etu[$i][2].'</td>';
        //echo '<td class="w3-border"> '.'<input onclick="OnOff()" type="button" class="w3-btn w3-block w3-black w3-left-align"></td>';
    echo '</tr>';
    /*echo '<span id="texte" style="visibility: hidden;">';
    echo '<tr>';
    echo '<div id="Demo'.$i.'" class="w3-container w3-hide">';
    echo '<tr id="Demo'.$i.'" class="w3-border w3-hide">';
    echo '<th class="w3-border">id</th>';
    echo '<th class="w3-border">nom</th>';
    echo '<th class="w3-border">taille</th>';
    echo '<th class="w3-border"minimum</th>';
    echo '<th class="w3-border"maximum</th>';
    echo '</tr>';                    
    for($j=0;$j<count($tab_grp);$j++){
        echo '<tr id="Demo'.$i.'" class="w3-border">';
        echo '<td id="Demo'.$i.'" class="w3-border ">';
        echo $tab_grp[$j][0].'';
        echo '</td>';
        echo '<td id="Demo'.$i.'" class="w3-border ">';
        echo $tab_grp[$j][1].'';
        echo '</td>';
        echo '<td id="Demo'.$i.'" class="w3-border ">';
        echo $tab_grp[$j][2].'';
        echo '</td>';
        echo '<td id="Demo'.$i.'" class="w3-border ">';
        echo $tab_grp[$j][3].'';
        echo '</td>';
        echo '<td id="Demo'.$i.'" class="w3-border ">';
        echo $tab_grp[$j][4].'';
        echo '</td>';
        echo '</tr>';
    }
    echo '</tr>';
    echo '</div>';
    echo '</span>';*/
}
?>
                    </table>
                </article>
            </div>
		</section>
        <script>
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
}

function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}
</script>
    <footer class="w3-container w3-teal w3-center w3-margin-top">
    <p class="fa w3-hover-opacity">Conditions d'utilisation|</p>
    <p class="fa w3-hover-opacity">Politique de confidentialité|</p>
    <p class="fa w3-hover-opacity">UPEC Tous droits réservés|</p>
    <p class="fa w3-hover-opacity">France / Français</p>
</footer>
    </body>
</html> 