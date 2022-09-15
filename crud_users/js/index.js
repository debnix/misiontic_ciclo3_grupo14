const url = "http://localhost:8080/personas"

function mostrar_usuarios (users) {
  // Referenciar tabla
  const tabla = document.getElementById('tbody')
  let tbody = ''
  for (let i = 0; i < users.length; i++) {
    const obj = users[i]
    const arrayDate = obj.fecha_nacimiento.split("T")
    tbody += `
    <tr>
      <td>
      <img width="120" src="${obj.foto}"/>
      </td>
      <td>${obj.nombres}</td>
      <td>${obj.apellidos}</td>
      <td>${obj.email}</td>
      <td>${arrayDate[0]}</td>
      <td> 
        <button class="btn btn-warning" onclick='update(${JSON.stringify(obj)})'>Actualizar</button> 
        <button class="btn btn-danger" onclick='deletePerson(${obj.id})'>Eliminar</button> 
      </td>
    </tr>
  `
  }
  tbody += ''
  tabla.innerHTML = tbody;
}

function update (persona) {
  window.location.href = "formulario.html?persona=" + JSON.stringify(persona)
}

async function get_all_users (url) {
  // Enviar petición al servidor
  const resp = await fetch(url)
  const users = await resp.json()
  return users
}

async function deletePerson (id) {
  // Enviar petición
  const resp = await fetch(`${url}/${id}`, {
    method: 'DELETE'
  })
  const text = await resp.text()
  alert(text)
  main()
}

async function main () {
  const users = await get_all_users(url)
  mostrar_usuarios(users)
}

main()
