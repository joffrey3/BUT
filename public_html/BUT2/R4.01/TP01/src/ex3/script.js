
class GridManager {
  ACTIVE_COLOR = 'black'
  INACTIVE_COLOR = 'grey'

  gridContainerId
  gridSize
  grid = []

  constructor(gridSize, gridContainerId) {
    if (!gridSize || gridSize < 30) {
      throw new Error('The grid size must be at least 30')
    }

    if (!gridContainerId) {
      throw new Error('gridContainerId must be set')
    }

    this.gridSize = gridSize
    this.gridContainerId = gridContainerId
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
	  // TODO
    let chaine=''
    let x=NaN,y=NaN
    while(initialState.length!=0){
      let unique=''
      unique=initialState.substring(0,1)
      if(unique==','){
        x=parseInt(chaine)
        chaine=''
      }
      else if(unique==';'){
        y=parseInt(chaine)
        chaine=''
      }else{
        chaine=chaine+unique
      }
      if((x && y) || x==0 || y==0){
        this.activeCell(x,y)
        x=NaN
        y=NaN
      }
      initialState=initialState.substring(1)
    }
    y=chaine
    if(x && y){
      this.activeCell(x,y)
      x=NaN
      y=NaN
    }
    //document.write(this.getNumberActiveNeighbourCells(0,0))
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
    
    this.grid[y][x].style.backgroundColor = this.INACTIVE_COLOR;
  }
  
  getNumberActiveNeighbourCells(x, y) {
	  // TODO
    let compteur=0
    for(let i=-1;i<2;i++){
      for(let j=-1;j<2;j++){
        if(this.isInGridRange(x+i,y+j)){
          if(this.isActiveCell(x+i,y+j)){
            if(i!=0 || j!=0){
              compteur++
            }
          }
        }
      }
    }
    /*document.write(x)
    document.write(',')
    document.write(y)
    document.write('=')
    document.write(compteur)
    document.write(' ')*/
    return compteur
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


const INITIAL_STATE = '11,1;12,1;10,2;9,3;9,4;9,5;10,6;11,7;12,7;2,4;1,5;2,5;18,28;17,28;19,27;20,26;20,25;20,24;19,23;18,22;17,22;27,25;28,24;27,24;11,28;12,28;10,27;9,26;9,25;9,24;10,23;11,22;12,22;2,25;1,24;2,24;18,1;17,1;19,2;20,3;20,4;20,5;19,6;18,7;17,7;27,4;28,5;27,5'
const GENERATION_INTERVAL = 1000 // 1 seconde
const DIV_CONTAINER_ID = 'container'
const BTN_AUTOPLAY_ID = 'autoplay'
const BTN_NEXT_GEN_ID = 'next-gen'
const BTN_RESET_ID = 'reset'
const BTN_TAILLE_ID = 'taille'
const GENERATION_VAL_ID = 'generation-value'
const GRID_SIZE_VAL_ID = 'grid-size-value'

function computeNextGeneration(gridManager, generation) {
  // incrémenter la valeur de la génération et l'afficher à côté de 'Génération numéro:'
  generation++
  document.getElementById(GENERATION_VAL_ID).textContent=generation
	// TODO
  let initialiseur=""
  for(let i=0;i<gridManager.gridSize;i++){
    for(let j=0;j<gridManager.gridSize;j++){
      if(gridManager.isActiveCell(j,i)){
        if(gridManager.getNumberActiveNeighbourCells(j,i)==2 || gridManager.getNumberActiveNeighbourCells(j,i)==3){
          initialiseur=initialiseur+String(j)+","+String(i)+";"
        }
      }
      else if(!gridManager.isActiveCell(j,i)){
        if(gridManager.getNumberActiveNeighbourCells(j,i)==3){
          initialiseur=initialiseur+String(j)+","+String(i)+";"
        }
      }
    }
  }
  for(let i=0;i<gridManager.gridSize;i++){
    for(let j=0;j<gridManager.gridSize;j++){
      gridManager.deactiveCell(j,i)
    }
  }
  gridManager.setInitialState(initialiseur)
  return generation
}

function computePreviousGeneration(gridManager, generation) {
  for(let i=0;i<gridManager.gridSize;i++){
    for(let j=0;j<gridManager.gridSize;j++){
      gridManager.deactiveCell(j,i)
    }
  }
  gridManager.setInitialState(INITIAL_STATE)
  return generation
}

// Fonction principale du jeu
function main() {
  let autoplayInterval
  let gridSize = 30
  let generation = 0

  let gridManager = new GridManager(gridSize, DIV_CONTAINER_ID)

  // exemple
  gridManager.setInitialState(INITIAL_STATE)

  document.getElementById(GRID_SIZE_VAL_ID).textContent=gridSize
  // Lorsqu'un utilisateur clique sur 'Auto Play'
  document.getElementById(BTN_AUTOPLAY_ID).addEventListener('click', () => {
    if (autoplayInterval) {
      return
    }
  
    autoplayInterval = setInterval(() => {
      generation = computeNextGeneration(gridManager,generation)
    }, GENERATION_INTERVAL);
  })

  // Lorsqu'un utilisateur clique sur 'Prochaine Génération'
	document.getElementById(BTN_NEXT_GEN_ID).addEventListener('click', () => {
		if (autoplayInterval) {
			clearInterval(autoplayInterval)
			autoplayInterval = null
		}

		generation=computeNextGeneration(gridManager,generation)
	})

  document.getElementById(BTN_RESET_ID).addEventListener('click', () => {
			computePreviousGeneration(gridManager)
		generation=0
		document.getElementById(GENERATION_VAL_ID).textContent=generation
	})

  document.getElementById(BTN_TAILLE_ID).addEventListener('click', () => {
    computePreviousGeneration(gridManager)
  generation=0
  document.getElementById(GENERATION_VAL_ID).textContent=generation

  let person = prompt("Choisissez la taille de la grille : minimum 100", "100");
		
		if (person != null) {
      //document.write(person)
			taille=parseInt(person)
			gridManager.destroyGrid()
			gridSize=taille
      gridManager.gridSize=gridSize
			gridManager.createGrid()
      gridManager.setInitialState(INITIAL_STATE)
		}
})
}


// Le jeu est démarré ici

main()
