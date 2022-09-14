
const users = [
  { foto: "https://avatars.dicebear.com/api/adventurer/:seed.svg?eyes=variant18&mouth=variant10&skinColor=variant03", nombre: "Andrés", apellido: "Quintero", email: "andres@gmail.com", fecha_nacimiento: "10/08/1993" },
  { foto: "https://avatars.dicebear.com/api/micah/:seed.svg", nombre: "Alejandra", apellido: "Perea", email: "alejandra@gmail.com", fecha_nacimiento: "120/10/1992" },
  { foto: "https://avatars.dicebear.com/api/adventurer/:seed.svg", nombre: "Daniel", apellido: "Perez", email: "daniel@gmail.com", fecha_nacimiento: "15/09/1990" },
  { foto: "https://avatars.dicebear.com/api/micah/:seed.svg?mouth=smile&baseColor=apricot&hair=full", nombre: "Laura", apellido: "Hernandez", email: "laura@gmail.com", fecha_nacimiento: "25/11/1995" }
]


function mostrar_usuarios (users) {
  // Referenciar tabla
  const tabla = document.getElementById('table-users')
  let tbody = '<tbody>'
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
      <td> <button class="btn btn-warning">Actualizar</button> <button class="btn btn-danger">Eliminar</button> </td>
    </tr>
  `
  }
  tbody += '</tbody>'
  tabla.innerHTML += tbody;
}

async function get_all_users (url) {
  // Enviar petición al servidor
  const resp = await fetch(url)
  const users = await resp.json()
  return users
}

async function main () {
  const url = "http://localhost:8080/personas"
  const users = await get_all_users(url)
  mostrar_usuarios(users)
}

main()
