class Element {
	constructor(x,y,vx,vy,tx,ty){
		this.x = x   // position (x,y)
		this.y = y   
		this.vx = vx // vitesse (vx,vy)
		this.vy = vy
		this.tx = tx  // taille (tx,ty)
		this.ty = ty
	}
	update(){
		if (this.x + this.tx + this.vx > innerWidth || this.x + this.vx <0)
			this.vx = -this.vx

		if ((this.y + this.ty +this.vy) > innerHeight || this.y + this.vy < 0)
			this.vy=-this.vy

		this.x += this.vx
		this.y += this.vy
	}
	setVitesse(vx,vy){
		this.vx = vx
		this.vy = vy
	}
	collision(el){
		//
		// completer => detecter l'intersection 
		// des rectangles de this avec el
	}

}
class Sprite extends Element{
	constructor(x,y,vx,vy,tx,ty,img){
		// completer
		// un sprite est représenté
		// par une image
	}
	draw(ctx){
		//
		// completer
		//
	}
}

class Missile extends Element {
	constructor(x,y,vx,vy,tx,ty,color){
		//
		// completer
		//
	}
	draw(ctx){
		//
		// completer
		// un missile est un rectangle
		//
	}
	update(){
		//
		// completer
		// un missile ne rebondit pas
		// update renvoie true ou false
		// suivant que le missile est tjs 
		// dans la scène
	}
}

