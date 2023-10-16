class Model {
	constructor() {
		this.todos = JSON.parse(localStorage.getItem('todos')) || []
	}

	_commit(todos) {
		localStorage.setItem('todos', JSON.stringify(todos))
	}

	getTodos(filter){
		if (filter == "active")
			return this.todos.filter(todo => !todo.done)
		if (filter == "done")
			return this.todos.filter(todo => todo.done)

		return this.todos
	}

	add(todoText) {
		const todo = {
			id: this.todos.length > 0 ? this.todos[this.todos.length - 1].id + 1 : 1,
			text: todoText,
			done : false,
		}

		this.todos.push(todo)
		this._commit(this.todos)
		return todo 
	}

	edit(id, updatedText) {
		this.todos = this.todos.map(todo =>
			todo.id === id ? { id: todo.id, text: updatedText, done: todo.done} : todo
		)

		this._commit(this.todos)
	}

	delete(id) {
		this.todos = this.todos.filter(todo => todo.id !== id)

		this._commit(this.todos)
	}

	toggle(id) {
		this.todos = this.todos.map(todo =>
			todo.id === id ? { id: todo.id, text: todo.text, done: !todo.done } : todo
		)
		this._commit(this.todos)
	}
}

