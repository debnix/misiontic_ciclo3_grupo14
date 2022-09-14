const URL_API = "http://localhost:8080/personas"

function getDataForm (e) {
  // Indicar al evento que no recargue página
  e.preventDefault()
  const form = e.target
  const persona = {
    nombres: form.nombre.value,
    apellidos: form.apellido.value,
    email: form.email.value,
    fecha_nacimiento: form.fecha_nacimiento.value,
    foto: form.foto.value
  }
  send_data(persona)
}

async function send_data (persona) {
  // Enviar petición
  const resp = await fetch(URL_API, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(persona)
  })
  const text = await resp.text()
  alert(text)
}