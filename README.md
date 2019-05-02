## About

Simple Maven multi module REST application with H2 database and Spring Security configuration for dev and prod profile.

In dev profile all routes are not protected. Prod profile allows access to endpoints only for specific roles with use of custom filter.

## Usage

There are two users initially loaded to database:

- firstuser with user role
- seconduser with admin role

#### Development profile
To run application with dev profile just run `./mvnw clean install && ./mvnw spring-boot:run -pl app`

Then you can use curl below requests

- find all movies in database

```
curl http://localhost:8080/api/movie
``` 

- find movie by title (i.e. Forret Gump)
```
curl http://localhost:8080/api/movie/Forrest%20Gump
```

- find user by username (i.e. firstuser)
```
curl http://localhost:8080/api/user/firstuser
```

#### Production profile

To run application with production profile run `./mvnw clean install && ./mvnw spring-boot:run -pl app -Dspring-boot.run.profiles=prod`

Then you can curl requests which were posted above but you have to add header which will allow to authenticate user.

```
curl -H "Bearer: firstuser" http://localhost:8080/api/movie
```

```
curl -H "Bearer: seconduser" http://localhost:8080/api/user/firstuser
```