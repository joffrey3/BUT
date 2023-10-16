function makeServiceAjax(){
	let url = "/todos"
	let service = {
		getTodos:getTodos,
		deleteTodos:deleteTodos,
		addTodo:addTodo
	}
	function addTodo(todo){
		return fetch(url, {
			method: 'POST',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(todo)

		}).then(data=>data.json()).then(data=>data)
	}


	function getTodos(){
		return fetch(url).then(data=>data.json()).then(data=>data)
	}

	function deleteTodos(todos){
		console.log(todos)
		return fetch(url, {
			method: 'DELETE',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(todos)

		}).then(data=>data.json()).then(data=>data)
	}
	return service 
}
