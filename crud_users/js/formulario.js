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
  sendData(persona)
  clearInputs(form)
}

async function sendData (persona) {
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

function clearInputs (form) {
  form.nombre.value = ""
  form.apellido.value = ""
  form.email.value = ""
  form.fecha_nacimiento.value = ""
  form.foto.value = ""
}

function getDataUrl () {
  const url = new URLSearchParams()
  const persona = url.getAll("persona")
  console.log(persona)
}

getDataUrl()