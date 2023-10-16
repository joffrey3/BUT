const ANTUP    = 0
const ANTRIGHT = 1
const ANTDOWN  = 2
const ANTLEFT  = 3

class Ant {
	x = 0
	y = 0

	direction = ANTRIGHT

	moveForward(width, height) {
		// TODO
		this.x=width
		this.y=height
	}

	rotateRight() {
		// TODO
		this.direction=(this.direction+1)%4
	}

	rotateLeft() {
		// TODO
		this.direction=(this.direction+3)%4
	}
}

class GridManager {
	ACTIVE_COLOR = 'black'
	INACTIVE_COLOR = 'white'

	gridContainerId
	gridSize
	grid = []
	ant  // la fourmi

	constructor(gridSize, gridContainerId,ant) {
		if (!gridSize || gridSize < 30) {
			throw new Error('The grid size must be at least 30')
		}

		if (!gridContainerId) {
			throw new Error('gridContainerId must be set')
		}

		this.gridSize = gridSize
		this.gridContainerId = gridContainerId
		this.ant = ant
		this.ant.x = this.ant.y = gridSize/2
		this.createGrid()
	}

	createGrid() {
		const container = document.getElementById(this.gridContainerId)

		for (let i = 0; i < this.gridSize; i++) {
			const row = document.createElement('div')
			row.className = 'row'

			const gridRow = []

			for (let j = 0; j < this.gridSize; j++) {
				const cell = document.createElement('div')
				cell.className = 'cell'
				cell.style.backgroundColor = this.INACTIVE_COLOR
				row.appendChild(cell)

				gridRow.push(cell)
			}

			container.appendChild(row)
			this.grid.push(gridRow)
		}
	}

	destroyGrid() {
		const container = document.getElementById(this.gridContainerId)
		container.replaceChildren()
		this.grid = []
	}

	setInitialState(initialState) {
		const coords = initialState.split(';').map(coord => coord.split(','))
		coords.forEach((coord) => this.activeCell(+coord[0], +coord[1]))
	}

	isInGridRange(x, y) {
		return x >= 0 && x < this.gridSize && y >= 0 && y < this.gridSize
	}

	isActiveCell(x, y) {
		return this.isInGridRange(x, y) && this.grid[y][x].style.backgroundColor === this.ACTIVE_COLOR
	}

	activeCell(x, y) {
		if (!this.isInGridRange(x, y)) {
			return
		}

		this.grid[y][x].style.backgroundColor = this.ACTIVE_COLOR
	}

	deactiveCell(x, y) {
		if (!this.isInGridRange(x, y)) {
			return
		}

		this.grid[y][x].style.backgroundColor = this.INACTIVE_COLOR
	}

	logCurrentGridState() {
		const activeCells = []

		for (let x = 0; x < this.gridSize; x++) {
			for (let y = 0; y < this.gridSize; y++) {
				if (this.isActiveCell(x, y)) {
					activeCells.push(`${x},${y}`)
				}
			}
		}

		console.log(activeCells.join(';'))
	}
}
// -----------------------------------------------------------------------------------------------------------------


const INITIAL_STATE = ''
const STEP_INTERVAL = 5 
const DIV_CONTAINER_ID = 'container'
const BTN_AUTOPLAY_ID = 'autoplay'
const BTN_NEXT_MOVE_ID = 'next-move'
const MOVE_VAL_ID = 'move-value'
const GRID_SIZE_VAL_ID = 'grid-size-value'
const BTN_PLUS_100_ID = 'plus-100'
const BTN_RESET_ID = 'reset'
const BTN_TAILLE_ID = 'taille'

function computeNextPosition(gridManager)
{
	// TODO
	width=gridManager.ant.x
	height=gridManager.ant.y
	//document.write(width)
	//document.write(height)
	//document.write(gridManager.ant.direction)
	if(!gridManager.isActiveCell(width,height)){
		gridManager.activeCell(width,height)
		gridManager.ant.rotateRight()
	}
	else if(gridManager.isActiveCell(width,height)){
		gridManager.deactiveCell(width,height)
		gridManager.ant.rotateLeft()
	}
	if(gridManager.ant.direction==ANTUP){
		height--
		if(!gridManager.isInGridRange(width, height)){
			height=gridManager.gridSize/2
		}
	}
	else if(gridManager.ant.direction==ANTRIGHT){
		width++
		if(!gridManager.isInGridRange(width, height)){
			width=-gridManager.gridSize/2+1
		}
	}
	else if(gridManager.ant.direction==ANTDOWN){
		height++
		if(!gridManager.isInGridRange(width, height)){
			height=-gridManager.gridSize/2+1
		}
	}
	else if(gridManager.ant.direction==ANTLEFT){
		width--
		if(!gridManager.isInGridRange(width, height)){
			width=gridManager.gridSize/2
		}
	}
	gridManager.ant.moveForward(width,height)
}

function computePreviousPosition(gridManager)
{
	// TODO
	width=gridManager.ant.x
	height=gridManager.ant.y
	if(gridManager.ant.direction==ANTUP){
		height--
		if(!gridManager.isInGridRange(width, height)){
			height=gridManager.gridSize-1
		}
	}
	else if(gridManager.ant.direction==ANTRIGHT){
		width++
		if(!gridManager.isInGridRange(width, height)){
			width=0
		}
	}
	else if(gridManager.ant.direction==ANTDOWN){
		height++
		if(!gridManager.isInGridRange(width, height)){
			height=0
		}
	}
	else if(gridManager.ant.direction==ANTLEFT){
		width--
		if(!gridManager.isInGridRange(width, height)){
			width=gridManager.gridSize-1
		}
	}
	gridManager.ant.moveForward(width,height)
	//document.write(gridManager.ant.direction)
	if(!gridManager.isActiveCell(width,height)){
		gridManager.ant.rotateRight()
		gridManager.activeCell(width,height)
	}
	else if(gridManager.isActiveCell(width,height)){
		gridManager.ant.rotateLeft()
		gridManager.deactiveCell(width,height)
	}
}


// Fonction principale de la simulation
function main() {
	let autoplayInterval
	let gridSize = 60
	let generation = 0
	let nbMove = 0
	let ant = new Ant()
	let gridManager = new GridManager(gridSize, DIV_CONTAINER_ID,ant)
	gridManager.setInitialState(INITIAL_STATE)

	// Lorsqu'un utilisateur clique sur 'Auto Play'
	document.getElementById(BTN_AUTOPLAY_ID).addEventListener('click', () => {
		if (autoplayInterval) {
			return
		}
		autoplayInterval = setInterval(() => {
			computeNextPosition(gridManager)
			nbMove++
			document.getElementById(MOVE_VAL_ID).textContent=nbMove
		}, STEP_INTERVAL)
	})
	document.getElementById(BTN_NEXT_MOVE_ID).addEventListener('click', () => {
		computeNextPosition(gridManager)
		nbMove++
		document.getElementById(MOVE_VAL_ID).textContent=nbMove
	})
	document.getElementById(BTN_PLUS_100_ID).addEventListener('click', () => {
		for(let x = 0; x < 100; x++){
			computeNextPosition(gridManager)
			nbMove++
			document.getElementById(MOVE_VAL_ID).textContent=nbMove
		}
	})
	document.getElementById(BTN_RESET_ID).addEventListener('click', () => {
		gridManager.ant.rotateRight()
		gridManager.ant.rotateRight()
		for(let i=0;i<nbMove;i++){
			computePreviousPosition(gridManager)
		}
		nbMove=0
		document.getElementById(MOVE_VAL_ID).textContent=nbMove
		gridManager.ant.rotateLeft()
		gridManager.ant.rotateLeft()
	})
	document.getElementById(BTN_TAILLE_ID).addEventListener('click', () => {
		gridManager.ant.rotateRight()
		gridManager.ant.rotateRight()
		for(let i=0;i<nbMove;i++){
			computePreviousPosition(gridManager)
		}
		nbMove=0
		document.getElementById(MOVE_VAL_ID).textContent=nbMove
		gridManager.ant.rotateLeft()
		gridManager.ant.rotateLeft()
		let person = prompt("Choisissez la taille de la grille : minimum 100", "100");
		
		if (person != null) {
			taille=parseInt(person)
			if(taille>=100){
				gridManager.destroyGrid()
				gridSize=taille
				gridManager = new GridManager(gridSize, DIV_CONTAINER_ID,ant)
				gridManager.setInitialState(INITIAL_STATE)
			}
		}
	})
}


// La simulation  est démarrée ici

main()
