let express = require('express');
let app = express();
let todos = require('./todos.json')


app.get('/', function(req, res){
	res.sendFile(__dirname+"/html/index.html");
});

//app.use('/html',express.static('html'));
app.use('/css',express.static('css'));
app.use('/js',express.static('js'));
app.use('/img',express.static('img'));
app.use('/tags',express.static('tags'));
app.use(express.json())





// Routes 
//
app.get('/todos', (req,res) => {
	res.status(200).json(todos)
}) 

app.get('/todos/:id', (req,res) => {
	const id = parseInt(req.params.id)

	// TODO
	//
	console.log(id)
	if(todos.id==id){
		res.status(200).json(todos.id)
	}
}) 

app.put('/todos/:id', (req,res) => {
	const id = parseInt(req.params.id)

	// TODO
	//
	res.status(200).json(todos)
})


app.post('/todos', (req,res) => {                                                                                                                                                                                                           
	let id = todos.length > 0 ? todos[todos.length - 1].id + 1 : 1

	// TODO
	//
	res.status(200).json(todos)
})

app.delete('/todos/:id', (req,res) => {
	const id = parseInt(req.params.id)

	// TODO
	//
})

app.delete('/todos', (req,res) => {

	// TODO
	//
	res.status(200).json(todos)
})



app.listen( 3000,()=>{
	console.log('listening on *:3000');
})

