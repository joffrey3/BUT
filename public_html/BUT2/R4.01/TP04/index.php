<?php

require 'flight/Flight.php';
require 'model/model.php';

Flight::route('GET /todo(/@id)','get_contacts');
Flight::route('POST /todo','add_contacts');
Flight::route('DELETE /todo/@id','delete_contacts');
Flight::route('PUT /todo/@id','update_contacts');

function update_contacts($id)
{
	//TODO

}

function delete_contacts($id)
{
	//TODO

	if (!isset($id)){
		Flight::json(
			[
				"results" => R::findAndExport('todo',"$filter"),
			]			
		);
	}else{
		$todo = R::load( 'todo', $id  );
		if ($todo->id)
			Flight::json($todo->export());
		else
			Flight::halt(404);
	}
}

function get_contacts($id = null)
{
	$filter = Flight::request()->query->filter ?? "all";
	if ($filter == "all")
		$filter = "";
	else if ($filter == "done")
		$filter = "done = '1'";
	else if ($filter == "active")
		$filter = "done = '0'";


	if (!isset($id)){
		Flight::json(
			[
				"results" => R::findAndExport('todo',"$filter"),
			]			
		);
	}else{
		$todo = R::load( 'todo', $id  );
		if ($todo->id)
			Flight::json($todo->export());
		else
			Flight::halt(404);
	}
}

function add_contacts()
{
	//TODO
}

Flight::start();
