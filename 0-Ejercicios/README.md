# Ejercicios de Repaso

## Ejercicio 4

Crear un proyecto Spring Boot con las dependencias:
* H2
* Spring Data JPA
* Spring Web
* Spring Boot dev tools

## Ejercicio 5

Dentro de la misma app crear las clases necesarias para trabajar con "ordenadores":

* Laptop (entidad)
* LaptopRepository (repositorio)
* LaptopController (controlador)

Desde LaptopController crear un método que devuelva una lista de objetos Laptop.

Probar que funciona desde Postman.

Los objetos Laptop se pueden insertar desde el método main de la clase principal.

## Ejercicio 6

Crear un método en LaptopController que reciba un objeto Laptop enviado en formato JSON desde Postman y persistirlo en la base de datos.

Comprobar que al obtener de nuevo los laptops aparece el nuevo ordenador creado.

## Ejercicio 7

Implementar los métodos CRUD en el API REST de Laptop creada en ejercicios anteriores.

Los métodos CRUD:

* findAll()
* findOneById()
* create()
* update()
* delete()
* deleteAll()

## Ejercicio 8

Implementar swagger sobre el API REST de Laptop y verificar que funciona en la URL: http://localhost:8080/swagger-ui/index.html#/
