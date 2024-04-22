

# Descripción General
GolosinasApp es una aplicación Java para la gestión de pedidos de golosinas. Permite a los usuarios crear, aprobar y administrar pedidos a través de una interfaz de consola. La aplicación controla el flujo de estados de los pedidos y ofrece funcionalidades para verificar las transiciones de estado legales antes de efectuarlas.

# Diagrama de Clases

[![Diagrama-de-clases.jpg](https://i.postimg.cc/2jBYc84d/Diagrama-de-clases.jpg)](https://postimg.cc/14Pb4S74)

# Diagrama de flujo de cambio de estados:

[![Diagrama-de-flujo-de-cambio-de-estados.jpg](https://i.postimg.cc/gkFWfFDC/Diagrama-de-flujo-de-cambio-de-estados.jpg)](https://postimg.cc/QVbwTzvm)

# Tecnologías Utilizadas
- Java: Todo el backend está escrito en Java, aprovechando características de orientación a objetos y manejo de estados.
- Maven: Para la gestión de dependencias y construcción del proyecto (asumiendo su uso, típico en proyectos Java).
- Simple HTTP Server: Implementado con com.sun.net.httpserver.HttpHandler para manejar peticiones HTTP.

# Cómo Correr la Aplicación
1. Compilación: Asegúrate de que Maven esté instalado y corre mvn clean install en el directorio raíz del proyecto para compilar.
2. Ejecución: Ejecuta el comando java -jar target/GolosinasApp.jar (ajusta el nombre del archivo JAR según tu configuración de Maven).

# Interacción con la Aplicación
* Consola de Comandos:
    - Al iniciar, la aplicación solicita el nombre del usuario para crear un nuevo usuario.
    - Luego, pide especificar si el pedido es mayorista o minorista.
    - Se pueden aprobar o rechazar pedidos según el flujo establecido de estados (BORRADOR, PENDIENTE_APROBACION, APROBADO, RECHAZADO).



# Pruebas con Postman
* Endpoint para Cambio de Estado:
    - URL: http://localhost:8000/cambioEstado
    - Método: POST
    - Body (ejemplo):

```
{
  "pedidoId": 1,
  "nuevoEstado": "APROBADO"
}
```

    - URL Ejemplo: http://localhost:8000/cambiarEstado?pedidoId=1&estado=APROBADO
    
    - Asegúrate de que el servidor esté corriendo antes de enviar peticiones desde Postman.
    - Utiliza el método POST para enviar el ID del pedido y el nuevo estado deseado.

# Documentación de la API
* Clases y Métodos Importantes:
    - PedidoService.java: Gestiona la creación y el estado de los pedidos.
    - UsuarioService.java: Administra la creación y el almacenamiento de usuarios.
    - EstadoPedidoChecker.java: Verifica si es posible cambiar de un estado a otro.
    - SimpleHttpServer.java: Configura el servidor HTTP y maneja las rutas.

# Conclusiones y Observaciones
* Manejo de Estados: La aplicación asegura que los cambios de estado se realicen solo si son válidos, manteniendo la integridad del flujo de trabajo.
* Extensibilidad: El diseño permite agregar más funcionalidades como autenticación de usuarios o una interfaz gráfica de usuario.
