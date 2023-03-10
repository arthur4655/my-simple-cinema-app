# 🎥 Simple-cinema-app
## 📝 Project description 
This project is a simple Spring web application for the cinema.
It implements the main functionality of any cinema application such as displaying movies that
are currently in the box office, searching for available movie session by date or a shopping cart with the ability to
add tickets to it and create an order based on the added tickets.

## 🔎 Endpoints description and security features

| Endpoint                              | Description                                                                                                     | Required access level |
|---------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------|
| `POST: /register - all`               | Registration as a new user                                                                                      | Any                   |
| `GET: /users/by-email`                | Find user by email                                                                                              | `ADMIN`               |
| `GET: /cinema-halls`                  | Get all cinema halls                                                                                            | `ADMIN`               |
| `POST: /cinema-halls`                 | Add new cinema hall                                                                                             | `ADMIN`               |
| `GET: /movies`                        | Get all movies                                                                                                  | `USER`/`ADMIN`        |
| `POST: /movies`                       | Add new movie                                                                                                   | `ADMIN`               |
| `GET: /movie-sessions/available`      | Find all available movie sessions, for example (/movie-sessions/available?movieId=1&date=22.12.2022)            | `USER`/`ADMIN`        |
| `POST: /movie-sessions`               | Add new movie session                                                                                           | `ADMIN`               |
| `DELETE: /movie-sessions/{id}`        | Delete movie session by id                                                                                      | `ADMIN`               |
| `PUT: /movie-sessions/{id}`           | Update movie session                                                                                            | `ADMIN`               |
| `PUT: /shopping-carts/movie-sessions` | Add movie session to shopping cart of current user, for example (/shopping-carts/movie-sessions?movieSessionId) | `USER`                |
| `GET: /shopping-carts/by-user`        | Find shopping cart belongs to current user                                                                      | `USER`                |
| `GET: /orders`                        | Get list of orders of current authenticated user                                                                | `USER`                |
| `POST: /orders/complete`              | Complete order with added tickets                                                                               | `USER`                |

By default, all new users have access level as `USER`
and also by default user with `ADMIN` role already injected in DB.

## 📚 Project structure
Project structure designed in accordance with N-tier architecture and endpoints follows REST API rules.
<p>💠Controllers are used for processing HTTP request</p>
<p>💠Services contains main business logic of the application and work with DB through DAO layer</p>
<p>💠DAO layer responsible for CRUD operations with database entities</p>
<p>💠DTO classes is used on controllers layer and responsible for representing models on UI layer</p>
<p>💠Models represent tables in a database</p>

## 🌐Technologies
* JDK 11
* Maven 4.0
* Hibernate ORM 5.4.27
* Spring Framework (Core, Web, Security) 5.2.2
* MySQL 8.0.22
* TomCat 9.0.68

## 🎇 Heroku 
Feel free to visit <a href = "https://cinema-app-v1.herokuapp.com/login">cinema app</a> on Heroku ( username = `admin@i.ua`, password = `admin123`).


## 🚀Instructions for launching the project
<h4>To run this project locally, follow these steps:</h4>

1️⃣ Install TomCat version 9.0.50 or 9.0.68  and MySQL

2️⃣  Clone this project from GitHub

3️⃣  Create a schema in your MySQL DB.
You can run the following query:<br>
```
CREATE SCHEMA IF NOT EXISTS `cinema-app` DEFAULT CHARACTER SET utf8;
```

4️⃣  Configure [db.properties](src/main/resources/db.properties)


5️⃣  Configure TomCat for this project and run it

6️⃣  You can log in as `ADMIN` using username = `admin@i.ua` and password = `admin123` or register new user


## Scheme of relations between entities in database

<img src="Hibernate_Cinema_Uml.png" alt="UML DB Scheme">
