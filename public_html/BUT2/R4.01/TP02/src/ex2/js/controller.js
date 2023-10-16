class Controller {
	constructor(model, view) {
		this.model = model
		this.view = view
		this.filter = "all"
		this.view.bindAddTodo(this.addTodo.bind(this))
		this.view.bindDeleteTodo(this.deleteTodo.bind(this))
		this.view.bindToggleTodo(this.toggleTodo.bind(this))
		this.view.bindEditTodo(this.editTodo.bind(this))

		/** Routage **/

		window.addEventListener("load",()=>{
			this.filter = window.location.hash.replace(/^#\//,'')
				if (!this.filter)
				this.filter = "all"
				this.filterTodoList()
			})

			window.addEventListener("hashchange",()=>{
				this.filter = window.location.hash.replace(/^#\//,'')
					if (!this.filter)
					this.filter = "all"
					this.filterTodoList()
				})
	}



	filterTodoList () {
		let todos = this.model.getTodos(this.filter)
		this.view.renderTodoList(todos)
		this.view.setFilterTabs(this.filter)
	}

	addTodo(text)  {
		let todo = this.model.add(text)
		this.filterTodoList()
	}

	deleteTodo(id)  {
		this.model.delete(parseInt(id))
		this.filterTodoList()
	}

	toggleTodo(id)  {
		this.model.toggle(parseInt(id))
		this.filterTodoList()
	}

	editTodo(id, text)  {
		this.model.edit(id,text)
		this.filterTodoList()
	}
}

const model = new Model()
const view = new View()
const app = new Controller(model, view)

