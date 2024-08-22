# Gustavo_Camargo_VerbosHttp

## Hecho por:

- Gustavo Adolfo Camargo Pineda

- Cod: 86521

- Correo: camargogustavoa@gmail.com

## Descripción del Proyecto

Este proyecto tiene como objetivo mostrar ejemplos prácticos del uso de los **verbos HTTP** en un servicio REST que interactúa con una base de datos **NoSQL** (MongoDB). A lo largo de esta actividad, se implementaron los verbos HTTP **GET**, **POST**, **PUT**, **PATCH**, **DELETE**, y **HEAD** para comprender cómo se utilizan estos verbos en la comunicación entre servicios web.

El servicio expone diferentes métodos para interactuar con la base de datos MongoDB, utilizando un modelo de datos sencillo (`GroceryItem`) que representa un artículo de supermercado. La base de datos se encuentra alojada en MongoDB Atlas, y el servicio corre en el puerto 8090.

## Modelo de Datos

El modelo `GroceryItem` representa los artículos en la base de datos MongoDB con los siguientes campos:
- `id`: Identificador único del artículo.
- `name`: Nombre del artículo.
- `quantity`: Cantidad disponible del artículo.
- `category`: Categoría a la que pertenece el artículo.

## Verbos HTTP Implementados

A continuación, se describen los verbos HTTP utilizados en este proyecto y los métodos correspondientes implementados en el controlador.

### 1. GET

El verbo **GET** se utiliza para **obtener recursos** desde el servidor. En este proyecto, se implementaron dos métodos para obtener todos los artículos o un artículo específico.

- **Obtener todos los artículos**:
  
  ```http
  GET /item/getAll
    ```

- **Obtener un artículo por ID**:
    
    ```http
    GET /item/getById/{id}
    ```

### 2. POST

El verbo **POST** se utiliza para **crear un nuevo recurso** en el servidor. En este proyecto, se implementó un método para agregar un nuevo artículo a la base de datos.

- **Agregar un nuevo artículo**:
  
  ```http
  POST /item/insert
  ```
  El cuerpo de la solicitud debe contener los datos del nuevo artículo en formato JSON. El servicio guarda el nuevo artículo en la base de datos.
  
  Ejemplo de cuerpo de la petición:
    ```json
    {
        "name": "Leche",
        "quantity": 2,
        "category": "Lácteos"
    }
    ```

### 3. PUT

El verbo **PUT** se utiliza para **actualizar completamente un recurso existente**. Este método sobrescribe todos los campos del recurso con los valores proporcionados en la solicitud.

- **Actualizar un artículo por ID**:
  
  ```http
  PUT /item/update/{id}
  ```
  El cuerpo de la solicitud debe contener los nuevos datos del artículo en formato JSON. El servicio actualiza el artículo con el ID especificado en la base de datos.
  
  Ejemplo de cuerpo de la petición:
    ```json
    {
        "name": "Leche Deslactosada",
        "quantity": 3,
        "category": "Lácteos"
    }
    ```

### 4. PATCH

El verbo **PATCH** se utiliza para **actualizar parcialmente un recurso existente**. Este método actualiza solo los campos proporcionados en la solicitud, manteniendo los valores anteriores para los campos no proporcionados.

- **Actualizar parcialmente un artículo por ID**:
  
  ```http
  PATCH /item/update/{id}
  ```
  El cuerpo de la solicitud debe contener los campos a actualizar en formato JSON. El servicio actualiza el artículo con el ID especificado en la base de datos.
  
  Ejemplo de cuerpo de la petición:
    ```json
    {
        "quantity": 4
    }
    ```

### 5. DELETE

El verbo **DELETE** se utiliza para **eliminar un recurso existente** en el servidor.

- **Eliminar un artículo por ID**:
  
  ```http
  DELETE /item/delete/{id}
  ```
  El servicio elimina el artículo con el ID especificado de la base de datos.

### 6. HEAD

El verbo **HEAD** se utiliza para **obtener los headers de una respuesta sin el cuerpo de la misma**. Es útil para verificar la existencia de un recurso o sus metadatos sin necesidad de descargar todo el contenido.

- **Obtener los headers de todos los artículos**:
  
  ```http
  HEAD /item/getAll
  ```
  Este método retorna solo los headers, incluyendo el tipo de contenido (Content-Type: application/json) y el código de estado (200 OK), sin devolver el cuerpo de la respuesta.

## Arquitectura del Proyecto


El proyecto se estructura en las siguientes capas:

- **Model**: Contiene la clase `GroceryItem` que representa la estructura del objeto a guardar en MongoDB.

- **Repository**: La interfaz `ItemRepository` extiende de `MongoRepository` y proporciona las operaciones CRUD para interactuar con la base de datos MongoDB.

- **Service**: La clase `ItemService` contiene la lógica del negocio y utiliza el repositorio para realizar operaciones con la base de datos.

- **Controller**: La clase `ItemController` expone los endpoints que responden a las diferentes solicitudes HTTP (GET, POST, PUT, PATCH, DELETE, HEAD).

## Configuración del Proyecto

El proyecto utiliza las siguientes configuraciones:

- **Base de datos MongoDB**: La base de datos está alojada en MongoDB Atlas, y la conexión se realiza mediante la URI:

  ```properties
  spring.data.mongodb.uri=mongodb+srv://camargogustavoa:<password>@servicios.cj74o.mongodb.net/Services
  ```

- **Puerto del servidor**: El servidor está configurado para ejecutarse en el puerto 8090.

  ```properties
    server.port=8090
    ```


## Instalación y Ejecución

Para ejecutar este proyecto en tu entorno local, sigue los siguientes pasos:

1. Clonar el repositorio.

2. Configurar la conexión a MongoDB en el archivo `application.properties`.

3. Ejecutar el servicio utilizando Maven o tu IDE preferido.

4. Acceder a los endpoints utilizando herramientas como Postman o curl.
