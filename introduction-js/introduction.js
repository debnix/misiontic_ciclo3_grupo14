// Constante
const n1 = 10
// Variables
let n2 = 20
n2 = 8
var n3 = 10
n3 = 50

const suma = n1 + n2 + n3
console.log("Suma = " + suma)
// Arreglos
let array = [10, 20, 30, 40, 50, 60]
// Obtener el tamaño
console.log(array.length)
// Recorrer arreglo 
for (let i = 0; i < array.length; i++) {
  // console.log("array["+i+"] -> "+array[i])
  console.log(`array[${i}] -> ${array[i]}`)
}

// Objetos
let persona = {
  nombre: "Alejandra",
  apellido: "Hernandez",
  edad: 28,
  celular: "3123456789"
}
console.log(persona)

// Obtener las llaves del objeto
console.log(Object.keys(persona))
// Obtener los valores del objeto
console.log(Object.values(persona))
