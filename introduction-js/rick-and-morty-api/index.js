
// Obtener personajes
async function obtener_personajes (url_api) {
  const resp = await fetch(url_api)
  // Obtener datos de la petición
  const personajes = await resp.json()
  return personajes.results
}

function listar_personajes (personajes) {
  // Referenciar contenedor de las tarjetas
  const section = document.getElementById('section-characters')
  let cards = ''
  // Iterar personajes
  for (let i = 0; i < personajes.length; i++) {
    cards += `
      <div class="card">
            <img
              src="${personajes[i].image}"
            />
            <div class="body-card">
              <h5>${personajes[i].name}</h5>
              <span>Specie: ${personajes[i].species}</span>
              <br/>
              <span>Location: ${personajes[i].location.name}</span>
              <br/>
              <span>Origin: ${personajes[i].origin.name}</span>
            </div>
      </div>
    `
  }
  section.innerHTML = cards

}

// Función principal
async function main () {
  const url_api = 'https://rickandmortyapi.com/api/character'
  const personajes = await obtener_personajes(url_api)
  console.log(personajes)
  listar_personajes(personajes)
}

main()