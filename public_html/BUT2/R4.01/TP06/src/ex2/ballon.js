const canvas = document.querySelector('canvas')
canvas.width = window.innerWidth
canvas.height = window.innerHeight
const c = canvas.getContext('2d')

const circlesCount = 300
const maxRadius = 40
const circleArray = []

const colorArray = [
	'#046975',
	'#2EA1D4',
	'#3BCC2A',
	'#FFDF59',
	'#FF1D47'
]

const init = () => {
	circleArray.length = 0
	for (let i = 0; i < circlesCount; i++) {
		const radius = Math.random() *maxRadius +1 ; 
		const x = Math.random() * (innerWidth - radius  * 2) + radius
		const y = Math.random() * (innerHeight - radius  * 2) + radius
		const dx = (Math.random() - 0.5) * 2
		const dy = (Math.random() - 0.5) * 2

		circleArray.push(new Circle(x, y, dx, dy, radius))
	}

}

const Circle = function(x, y, dx, dy, radius) {
	this.x = x
	this.y = y
	this.dx = dx
	this.dy = dy
	this.radius = radius
	this.minRadius = radius
	this.color = colorArray[Math.floor(Math.random() * colorArray.length)]

	this.draw = function() {
		// A completer
	}

	this.update = function() {
		// A completer

		this.draw()
	}
}

const animate = () => {
	c.clearRect(0, 0, innerWidth, innerHeight)

	for (let i = 0; i < circleArray.length; i++) {
		circleArray[i].update() 
	}
	requestAnimationFrame(animate)
}

init()
animate()
