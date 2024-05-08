# language: es
Característica:Inicio de sesión de usuario

  Escenario: Inicio de sesión exitoso
    Dado que "bechtelar.net" con email "bechtelar.net@example.com" y contrasena "m06bjgkjl4iq5"
    Cuando se realiza una solicitud POST a "/sesion" con el email y contrasena validos
    Entonces la respuesta debe tener un codigo de estado 200
    Y la respuesta debe incluir el mensaje "Inicio de sesión exitoso"
