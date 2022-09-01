
// Obtener personajes
async function obtener_personajes (url_api) {
  const resp = await fetch(url_api)
  // Obtener datos de la petición
  const personajes = await resp.json()
  return personajes
}

function listar_personajes (personas) {
  let card = `
  <div class="card">
				<img
					width="200"
					src="https://rickandmortyapi.com/api/character/avatar/1.jpeg"
				/>
	</div>
  `
}

// Función principal
async function main () {
  const url_api = 'https://rickandmortyapi.com/api/character'
  const personajes = await obtener_personajes(url_api)
  console.log(personajes)
}

main()