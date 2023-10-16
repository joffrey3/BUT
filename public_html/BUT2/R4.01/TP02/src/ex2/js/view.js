class View {
	constructor() {
		this.form   = document.querySelector("#add_form")
		this.input  = document.querySelector("#input_todo")
		this.list   = document.querySelector("#todos_list")
		this.tabs   = document.querySelector("#todos_filter")
		this.loader = document.querySelector("#loader")
	}

	_getTodo() {
		return this.input.value
	}

	_resetInput() {
		this.input.value = ''
	}

	_getNewTodoElement(todo){
		let div = document.createElement("div")
		div.classList.add("box","is-flex","is-align-items-center","m-2")
		div.dataset.id = todo.id

		let input = document.createElement("input")
		input.type = "checkbox"
		input.classList.add("mr-3")

		let span = document.createElement("p")
		span.classList.add("mb-0","is-size-3","mr-auto")
		span.textContent = todo.text
		span.setAttribute("contenteditable",true)


		let button = document.createElement("button")
		button.classList.add("delete","is-large")


		if (todo.done){
			span.classList.add("strike")
			input.checked = true
		}

		div.append(input,span,button)

		return div

	}

	setLoader(){
		this.loader.classList.add("is-loading")
	}
	unsetLoader(){
		this.loader.classList.remove("is-loading")
	}

	setFilterTabs(filter){
		let li = this.tabs.querySelectorAll("li")
		li.forEach( tab => {
			tab.classList.remove("is-active")
		})
		let active = this.tabs.querySelector(`#${filter}`)
		active.parentNode.classList.add("is-active")
	}

	renderTodoList(todos) {
		let list = new DocumentFragment()
		for (let todo of todos){
			list.appendChild(this._getNewTodoElement(todo))
		}
		this.list.replaceChildren(list)
	}

	/** Abonnements événements **/

	bindAddTodo(handler) {
		this.form.addEventListener("submit", (e=>{
			e.preventDefault()
			let text = this._getTodo()
			handler(text)
			this._resetInput()
		}))
	}


	bindDeleteTodo(handler) {
		// TODO
		this.list.addEventListener("click", (e=>{
			if(e.target.classList.contains("delete")){
				let id = e.target.parentNode.dataset.id
				handler(id)

			}
		}))
	}

	bindEditTodo(handler) {
		// TODO
		this.list.addEventListener("focus-out", (e=>{
			if(e.target.classList.contains("mb-0")){
				let id=e.target.parentNode.dataset.id
				let text = e.target.textContent
				console.log(id)
				console.log(text)
				handler(id,text)
				console.log(id)
				console.log(text)
				console.log(e.target.classList.contains("mb-0"))
			}
		}))
		this.list.addEventListener("click", (e=>{
			if(e.target.classList.contains("mb-0")){
				let id=e.target.parentNode.dataset.id
				let text = e.target.textContent
				//handler((id,text))
				console.log(id)
				console.log(text)
			}
		}))
	}

	bindToggleTodo(handler) {
		// TODO
		this.list.addEventListener("click", (e=>{
			if(e.target.classList.contains("mr-3")){
				let id=e.target.parentNode.dataset.id
				handler(id)
			}
		}))
	}
}
