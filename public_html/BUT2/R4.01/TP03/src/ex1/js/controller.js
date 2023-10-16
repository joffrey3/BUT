class   Controller  {
	constructor(view,model){
		this.view = view
		this.model = model

		this.loading = false
		this.lastSearch = null
		this.error = null
		this.results = []

		this.view.setLoading(false)
		this.view.bindSearch(this.search.bind(this))
	}
	reset() {
		this.loading = false
		this.error = null
		this.results = []
	}

	async search(searchMovie) {
		// TODO
		console.log(searchMovie)
		let p
		let promesse=await this.model.getMovies(searchMovie)
		/*promesse.then((response)=>{
			console.log(response)
		})*/
		console.log("nonnnnn")

		console.log(await promesse)
		return promesse
	}
} 

export default Controller

