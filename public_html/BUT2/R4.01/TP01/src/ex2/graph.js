"use strict";

const colors = [
	'#00429d', '#204fa3', '#325da9', '#406aaf', '#4e78b5', '#5a86bb', 
	'#6694c1', '#73a2c6', '#80b1cc', '#8ebfd1', '#9dced6', '#addcda', 
	'#c0eade', '#d8f6e1', '#ffffe0'
]

function graph(canvasId, array) {
	if (array.length == 0) {
		throw "array.length == 0"
	}

	var min = array.reduce(function(a, b) { return (a < b)? a: b; })
	var max = array.reduce(function(a, b) { return (a < b)? b: a; })

	var canvas = document.getElementById(canvasId)
	var context = canvas.getContext("2d")
	context.clearRect(0, 0, canvas.width, canvas.height)

	context.beginPath()
	context.strokeStyle = "black"
	context.moveTo(0, canvas.height / 2)
	context.lineTo(canvas.width, canvas.height / 2)
	context.stroke()

	array.forEach(function(v, i) {

		context.fillStyle = colors[(i) % colors.length]
		context.fillRect((i + 0.1) * canvas.width / array.length, canvas.height / 2, 0.8 * canvas.width / array.length, v * canvas.height / (min - max) / 2)
		context.strokeText(v, (i + 0.4)* canvas.width / array.length, canvas.height /10)
	})
}

