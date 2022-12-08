# HotelEstruD

Grupo 2


- Binjie Liang
- Julian Samuel Rojas Saenz
- Nazareth Noelia Murillo Villalobos
- Javir Andres Tapia Alvarez



El proposito de este proyecto es crear un sistema para la administracion de reservas de un hotel


Se implemento la utilizacion de sockets para hacer una comunicacion de cliente y servidor


Para que?


Bueno, para la parte de clientes, el cliente pide una ficha y el servidor le va a tirar un numero


De esta forma se utiliza lo que seria la estructura de Colas


En la parte del servidor o mas bien el Hotel en si, va atendiendo las fichas de la cola


Al atender a un cliente, le preguntamos su nombre, identificacion, tipo de habitacion, cant de personas, cant de noches, monto


Toda esa informacion del cliente se guardara en la estructura de Lista Enlazada Simple


Para luego guardar una factura con el monto en la estructura de una Lista Circular


Luego, usando recursividad obtenemos el ingreso total realizado en un dia
