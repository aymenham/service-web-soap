<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="windows-1256" />
    <link rel="stylesheet" href="./css/chef.css" />
    <title>Page Chef</title>
  </head>
  <body>
    <h4>${message}</h4>
    <form action="GererAnneeServlet" method="post">
      <div class="annee">
        <div class="btn1">
          <h2>Gerer Année</h2>
          <input
            class="ouvrir"
            type="submit"
            value="Ouvrir Année"
            name="ouvrir_annee"
          />
        </div>
        <div class="btn1">
          <input
            class="fermer"
            type="submit"
            value="Fermer Année"
            name="fermer_annee"
          />
        </div>
      </div>
    </form>

    <form action="GererInscriptionServlet" method="post">
      <div class="inscription">
        <div class="btn1">
          <h2>Gerer Inscription</h2>
          <input class="ouvrir" type="submit" value="Ouvrir Inscription" name="ouvrir_inscription" />
        </div>
        <div class="btn1">
          <input class="fermer" type="submit" value="Fermer Inscription" name="fermer_inscription"/>
        </div>
      </div>
    </form>
  </body>
</html>
