// TODO

const BTN_POS_ID='sort'
const ZONE_INPUT_ID='myInput'
const TBODY_ID='body'

function affichage(donnee,sens) {
	let inverse=donnee.length
	let zone=document.getElementById(TBODY_ID)
    for(let i=0;i<donnee.length;i++,inverse--){
		let j=i
		if(sens==1){
			j=inverse-1
		}
		let colonne,info
		let ligne=document.createElement("tr")

		colonne=document.createElement("td")
		info=document.createTextNode(donnee[j].intRank)
		colonne.appendChild(info)
		ligne.appendChild(colonne)

		colonne=document.createElement("td")
		let img=document.createElement("img")
		img.src=donnee[j].strTeamBadge
		colonne.appendChild(img)
		ligne.appendChild(colonne)

		colonne=document.createElement("td")
		info=document.createTextNode(donnee[j].strTeam)
		colonne.appendChild(info)
		ligne.appendChild(colonne)

		colonne=document.createElement("td")
		info=document.createTextNode(donnee[j].intPlayed)
		colonne.appendChild(info)
		ligne.appendChild(colonne)

		colonne=document.createElement("td")
		info=document.createTextNode(donnee[j].intWin)
		colonne.appendChild(info)
		ligne.appendChild(colonne)

		colonne=document.createElement("td")
		info=document.createTextNode(donnee[j].intDraw)
		colonne.appendChild(info)
		ligne.appendChild(colonne)

		colonne=document.createElement("td")
		info=document.createTextNode(donnee[j].intLoss)
		colonne.appendChild(info)
		ligne.appendChild(colonne)

		colonne=document.createElement("td")
		info=document.createTextNode(donnee[j].intGoalsFor)
		colonne.appendChild(info)
		ligne.appendChild(colonne)

		colonne=document.createElement("td")
		info=document.createTextNode(donnee[j].intGoalsAgainst)
		colonne.appendChild(info)
		ligne.appendChild(colonne)

		colonne=document.createElement("td")
		info=document.createTextNode(donnee[j].intGoalDifference)
		colonne.appendChild(info)
		ligne.appendChild(colonne)

		colonne=document.createElement("td")
		info=document.createTextNode(donnee[j].intPoints)
		colonne.appendChild(info)
		ligne.appendChild(colonne)

		zone.appendChild(ligne)
	}
}

function enlever(){
	let zone=document.getElementById(TBODY_ID)
	for(;zone.lastChild;){
		zone.removeChild(zone.lastChild)
	}

}

function filtrer(donnee,chaine){
	let resultat=new Array()
	let compte=0
	for(let i=0;i<donnee.length;i++){
		if(donnee[i].strTeam.indexOf(chaine)!=-1){
			resultat[compte]=donnee[i]
			compte++	
		}
	}		
	return resultat
}
function main(){
	let donnee=data
	let sens=0
	let chaine=""
	this.affichage(donnee,sens)
	document.getElementById(BTN_POS_ID).addEventListener('click', () => {
		sens=(sens+1)%2
		this.enlever()
		this.affichage(donnee,sens)
	})
	document.getElementById(ZONE_INPUT_ID).addEventListener('keypress',(event) => {
		chaine=chaine+event.key
		//document.writeln(chaine)
		this.enlever()
		donnee=this.filtrer(donnee,chaine)
		this.affichage(donnee,sens)
	});
}

// La simulation  est démarrée ici

main()