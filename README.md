# ListaApi

API REST desarrollado con Spring, Maven y Java 11, que va a recibir como dato de entrada una lista de números del 1 al 100 y devolverá un endpoint con la suma de todos los elementos de la lista.
### Features

![app](/img/Api.gif)
### Built With
[![spring](https://img.shields.io/badge/Springboot-FFFFFF?style=for-the-badge&logo=springboot&logoColor=33FF64
)](https://spring.io/)
[![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://es.vitejs.dev/)
[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white
)](https://www.java.com/)
[![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)](https://swagger.io/)

### Local installation

```sh
git clone https://github.com/josekadeveloper/ListaApi.git

cd api.rest.lista

Una vez sincronizadas las dependencias nos vamos al fichero Application.java donde esta el
método main() que es desde donde arranca nuestra app y le damos click izquierdo a la opción RUN
para ejecutar la app
```

#### API Test
  * USE API [swagger](http://localhost:8080/swagger-ui.html)

  * SHOW DATABASE:  (http://localhost:8080/h2-console/)
```sh
Para ver la base de datos de la API tendremos que poner la URL que se encuentra en el fichero
de configuración application.yml situado en la carpeta resources, donde tambien aparecen el
usuario y contraseña para acceder a la base de datos
```