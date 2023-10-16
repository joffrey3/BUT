let apiKey = '2fcb2848'

let model = {
	async getMovies(search){
		// TODO
		let p
		console.log(search)
		let promesse = fetch('http://www.omdbapi.com/?apikey=2fcb2848&s=avatar')
		promesse.then((response)=>{
			console.log(response.status)
			if(response.ok){
				console.log(response.url)
			}
			//console.log(response.json())
			return response.json()
			/*.then((response)=>{
				p=JSON.stringify(response)
				console.log(p)
				console.log("oui")
				return p
			})*/
		})
		promesse.catch(()=>{
			console.log('error')
		})
		/*const promesse = new Promise((resolve,reject)=>{
			resolve('We did it')
		})*/



		/*const promesse = new Promise((resolve,reject)=>{
			var xhr = new XMLHttpRequest()
			xhr.open('2fcb2848','http://www.omdbapi.com/?apikey=[yourkey]&')
			xhr.onload=()=>{
				console.log(xhr.status)
				if (xhr.status == 200)
				resolve(xhr.response)
				else
				reject("Erreur : "+xhr.statusText)
			}
			xhr.onerror = () => reject("Erreur reseau")
			xhr.send()
			console.log('super')
			//resolve('We did it')
		})
		return promesse*/

		/*console.log('ouiiii')
		const promesse = fetch('2fcb2848','http://www.omdbapi.com')
		console.log('super')
		return promesse*/

		/*
		const promesse = new Promise((resolve,reject)=>{
			resolve('We did it')
		})
		*/

	}
}

export default model