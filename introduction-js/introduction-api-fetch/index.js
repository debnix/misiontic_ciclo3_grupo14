

// Obtener los usuarios
async function obtener_usuarios (uri_users) {
  // Enviar petición de tipo Get
  const resp = await fetch(uri_users)
  //console.log(resp)
  const data = await resp.json()
  console.log(data)
  return data
}

// Mostrar los usuarios
function mostrar_usuarios (users) {
  // Referenciar tabla
  const tabla = document.getElementById('tabla')
  //Variable que representa el body de la tabla
  let tbody = `<tbody>`
  for (let i = 0; i < users.length; i++) {
    // Obtener la dirección
    let address = users[i].address.street
    address += `, ${users[i].address.suite}`
    address += `,  ${users[i].address.city}`
    // Variable que representa el cuerpo de la tabla
    tbody += `
      <tr>
      <td>${users[i].id}</td>
      <td>${users[i].name}</td>
      <td>${users[i].username}</td>
      <td>${users[i].email}</td>
      <td>${address}</td>
      <td>${users[i].phone}</td>
      <td>${users[i].website}</td>
      </tr>
    `
  }
  tbody += `</tbody>`
  tabla.innerHTML += tbody
}

// Función principal
async function main () {
  const uri_users = 'https://jsonplaceholder.typicode.com/users'
  const users = await obtener_usuarios(uri_users)
  mostrar_usuarios(users)
}

main()