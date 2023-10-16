import debounce from "./helpers.js"

class View {
	constructor(){
		this.listMovies = document.querySelector("#list-movies")
		this.inputSearch = document.querySelector("input")
		this.loader = document.querySelector(".loader")
		this.message = document.querySelector("p.error")
	}

	_getInput(){
		return this.inputSearch.value
	}

	setLoading(loading){
		if (loading)
			this.loader.style.display = "block"
		else
			this.loader.style.display = "none"
	}

	renderMessage(error){
		this.message.style.display = "block"
		this.message.textContent = error
	}

	renderList(movies){
		let ul = document.createElement("ul")
		movies.forEach((movie)=>{
			let li = document.createElement("li")
			let a = document.createElement("a")
			let span = document.createElement("span")
			a.href = `http://www.imdb.com/title/${movie.imdbID}`
			a.target="_blank"
			a.textContent = movie.Title
			span.textContent = movie.Year


			li.appendChild(a)
			li.appendChild(span)
			ul.appendChild(li)
		})

		this.listMovies.replaceChildren(ul)
	}

	bindSearch(handler){
		this.inputSearch.addEventListener("input",debounce((e)=>{
			handler(this._getInput())	
		},500))
	}
}

export default View
