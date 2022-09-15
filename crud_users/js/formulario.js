const URL_API = "http://localhost:8080/personas"

let UPDATE_PERSON = {
  update: false,
  id: null
}

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
  if (UPDATE_PERSON.update) {
    sendDataUpdate(persona)
  } else {
    sendDataCreate(persona)
  }

  clearInputs(form)
}

async function sendDataUpdate (persona) {
  // Adicionar id al objeto
  persona.id = UPDATE_PERSON.id
  // Enviar petición
  const resp = await fetch(URL_API, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(persona)
  })

  const text = await resp.text()
  alert(text)
  window.location.href = "index.html"
}

async function sendDataCreate (persona) {
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
  const search = window.location.search
  const url = new URLSearchParams(search)
  const persona = url.get("persona")
  if (persona) {
    const objPersona = JSON.parse(persona)
    const arrayDate = objPersona.fecha_nacimiento.split("T")

    document.getElementById("input_nombre").setAttribute("value", objPersona.nombres)
    document.getElementById("input_apellido").setAttribute("value", objPersona.apellidos)
    document.getElementById("input_email").setAttribute("value", objPersona.email)
    document.getElementById("input_fecha_nacimiento").setAttribute("value", arrayDate[0])
    document.getElementById("input_foto").setAttribute("value", objPersona.foto)

    UPDATE_PERSON.update = true
    UPDATE_PERSON.id = objPersona.id

    document.getElementById('boton-crear-user').innerText = 'Actualizar'
  }

}

getDataUrl()