# 🎥 Simple-cinema-app
## 📝 Project description 
This project is a simple Spring web application for the cinema.
It implements the main functionality of any cinema application such as displaying movies that
are currently in the box office, searching for available movie session by date or a shopping cart with the ability to
add tickets to it and create an order based on the added tickets.

## 🔎 Endpoints description
* `POST: /register - all` - registration as a new user
* `GET: /users/by-email` - find user by email
* `GET: /cinema-halls` - get all cinema halls
* `POST: /cinema-halls` - add new cinema hall
* `GET: /movies` - get all movies
* `POST: /movies` - add new movie
* `GET: /movie-sessions/available` - find all available movie sessions, for example (/movie-sessions/available?movieId=1&date=22.12.2022)
* `POST: /movie-sessions` - add new movie session
* `PUT: /movie-sessions/{id}` - update movie session
* `PUT: /shopping-carts/movie-sessions` - add movie session to shopping cart of current user, for example (/shopping-carts/movie-sessions?movieSessionId)
* `GET: /shopping-carts/by-user` - find shopping cart belongs to current user
* `GET: /orders` - get list of orders of current authenticated user
* `POST: /orders/complete` - complete order with added tickets

## 🔒 Security features
Required access levels to endpoints: <br>
`POST: /register` - all<br>
`GET: /cinema-halls` - `USER`/`ADMIN`<br> 
`POST: /cinema-halls` - `ADMIN`<br>
`GET: /movies` - `USER`/`ADMIN`<br>
`POST: /movies` - `ADMIN`<br>
`GET: /movie-sessions/available` - `USER`/`ADMIN`<br>
`POST: /movie-sessions` - `ADMIN`<br>
`PUT: /movie-sessions/{id}` - `ADMIN`<br>
`DELETE: /movie-sessions/{id}` - `ADMIN`<br>
`GET: /orders` - `USER`<br>
`POST: /orders/complete` - `USER`<br>
`PUT: /shopping-carts/movie-sessions` - `USER`<br>
`GET: /shopping-carts/by-user` - `USER`<br>
`GET: /users/by-email` - `ADMIN`<br>
By default all new users have access level as `USER`
and also by default user with `ADMIN` role already injected in DB.

## 📚 Project structure
Project structure designed in accordance with N-tier architecture and endpoints follows RESTful API rules.
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
```bash
CREATE SCHEMA IF NOT EXISTS `cinema-app` DEFAULT CHARACTER SET utf8;
```

4️⃣  Configure [db.properties](src/main/resources/db.properties)


5️⃣  Configure TomCat for this project and run it

6️⃣  You can log in as `ADMIN` using username = `admin@i.ua` and password = `admin123` or register new user


## Scheme of relations between entities in database

<img src="Hibernate_Cinema_Uml.png">
