# language: es
Característica:Agregar un nuevo usuario

  Escenario: Agregar un nuevo usuario exitosamente
    Dado que se tiene un nuevo usuario con nombre aleatorio, contrasena aleatoria y correo electronico aleatorio
    Cuando se realiza una solicitud POST a "/usuarios" con los datos del nuevo usuario
    Entonces la respuesta debe tener un codigo de estado 200 de salida
    Y la respuesta debe incluir un mensaje de exito "Usuario agregado con éxito" de la prueba