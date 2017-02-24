## JWT Demo con Spring Framework
Ejemplo de una aplicacion Spring Boot que ofrece una API REST y autenticacion con JWT.

Incluye la parte front end con autenticacion contra el servicio JWT y acceso a recursos utilizando token jwt

Referencia: (http://sdqali.in/blog/2016/07/02/jwt-authentication-with-spring-web---part-1/).

### Dependencias

* Gradle
* Spring Boot
* Spring Security
* [jjwt](jjwt)
* Bower
* Angular JS

### Despliegue del proyecto
* Instalar las dependencias del front end utilizando bower
```bash
bower install
```
* Correr la aplicacion
```bash
gradle bootRun
```

```bash
./gradlew bootRun
```

### Acceso
Puedes acceder a la aplicacion desde el link [http://localhost:8080](http://localhost:8080) en un navegador.
Para autenticarte echa un vistazo al fichero de perfiles: `src/main/resources/profiles.json`


### API
* Obtener un token JWT:
```bash
curl -v -X POST "http://localhost:8080/login" -d '{"username":"greenrabbit948", "password":"celeste"}' --header "Content-Type: application/json"
```
* Autenticarse con el token JWT obtenido:
```bash
curl -s "http://localhost:8080/profile/details/greenrabbit948" --header "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncmVlbnJhYmJpdDk0OCIsImV4cCI6MTQ2ODE0MDg1MiwiaXNzIjoiaW4uc2RxYWxpLmp3dCJ9.t9pqrOmYfaVkzuAQgo4D4VbN2PibQuHPuPA6RKYU-keTzbFAX58l77hQTc4Cq28HpjFOeiDvNpNEgilNHFOfVA"
```

### Documentacion API REST
Para consultar la documentacion del api no tienes mas que acceder a la siguiente url en tu navegador:
[http://localhost:8080/jsondoc-ui.html?url=http://localhost:8080/jsondoc](http://localhost:8080/jsondoc-ui.html?url=http://localhost:8080/jsondoc)

