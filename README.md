# Microservices vs Monolithic Architecture
![img.png](img.png)

# Rest services and crud operations
- para crear un servicio rest necestiamos con controlador con las siguientes anotacones:
# @RestController
se utiliza para marcar la clase como controlador de una app web
se encargan de manejar las solicitudes http y enviar formatos de respuesta json xml entre otros.
# @GetMapping("/nombre de la ruta")
Se usa para mapear metodos a solicitudes http get 
# @PostMapping("/")
Se utiliza para mapear metodos a solicitudes post (creacion)
# @PutMapping("/")
mapea a solicitudes put (Autualización)
# @DeleteMapping("/")
mapea a solicitudes delete (borrar)
# PathVariable 
@GetMapping("/hello/{name}")
public String sayHello(@PathVariable String name) {
return "Hello, " + name + "!";}
- se utiliza para vincular una variable de método a una variable de una parte de la URL
en una solicitud HTTP.


