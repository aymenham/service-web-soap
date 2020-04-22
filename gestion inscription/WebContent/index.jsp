<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="./css/index.css" />
    <link
      rel="stylesheet"
      href="./fontawesome-free-5.11.2-web/fontawesome-free-5.11.2-web/css/all.css"
    />
    <title>Login</title>
  </head>
  <body>
    <form action="LoginServlet" method="post">
      <div class="main">
        <h3>${ erreur }</h3>
        <div class="login">
          <h1 class="information">Authentfication</h1>
          <i class="fas fa-user-lock"></i>
          <input
            type="text"
            name="username"
            id="username"
            placeholder="username"
            class="information"
          />

          <input
            type="password"
            name="password"
            id="password"
            placeholder="password"
            class="information"
          />

          <input type="submit" value="Login" class="loginbtn" />
        </div>
      </div>
    </form>
  </body>
</html>
