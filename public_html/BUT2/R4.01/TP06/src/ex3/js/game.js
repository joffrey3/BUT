loader.init()

let cs = document.querySelector('canvas')
let ctx = cs.getContext('2d')

let fps = 60 
let time = 0 ;
let dt = 1000/fps

let alien = null
let ship = null
let missile = null
// let missile = [] => on autorise un nombre de missile quelconque
let explosion = null


const valien = 20 // vitesse horizontale 

const animate = (t) => {
	requestAnimationFrame(animate);
	if (t-time > dt){
		ctx.clearRect(0, 0, innerWidth, innerHeight)

		//
		// update position
		//

		//
		// collision
		//

		//
		// draw
		//
		time = t
	}
}

window.addEventListener("keydown",function(ev){
	if (ev.key == "ArrowLeft"){
		// completer
	}
	if (ev.key == "ArrowRight"){
		// completer
	}

	if (ev.key == " "){
		// completer
	}
})

window.onload = ()=>{
	cs.width = window.innerWidth
	cs.height = window.innerHeight

	alien = new Sprite(
		cs.width/2-72/2,10,
		valien,0,
		72,72,
		loader.images.alien)

	ship = new Sprite(
		cs.width/2-72/2,cs.height-100 ,
		10,0,
		72,72,
		loader.images.ship)

	animate()
}


