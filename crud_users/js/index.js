
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
    tbody += `
    <tr>
      <td>
      <img width="120" src="${obj.foto}"/>
      </td>
      <td>${obj.nombre}</td>
      <td>${obj.apellido}</td>
      <td>${obj.email}</td>
      <td>${obj.fecha_nacimiento}</td>
    </tr>
  `
  }
  tbody += '</tbody>'
  tabla.innerHTML += tbody;
}

mostrar_usuarios(users)
