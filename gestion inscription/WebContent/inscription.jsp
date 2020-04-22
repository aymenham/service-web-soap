<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="./css/reinscription.css" />
    <link
      rel="stylesheet"
      href="./fontawesome-free-5.11.2-web/fontawesome-free-5.11.2-web/css/all.css"
    />
    <title>PAGE INSCRIPTION</title>
  </head>
  <body>
    <nav>
      <div class="information_agent">
        <h4>Agent : ${ sessionScope.nom } ${sessionScope.prenom }</h4>
      </div>

      <div class="disconnect_agent">
        <form action="DisconnectServlet" method="get">
          <input type="submit" value="Decconecter" />
        </form>
      </div>
    </nav>

    <div class="main_reinscription">
      <div class="search">
        <form action="InscriptionServlet" method="get">
          <input
            type="text"
            name="id_cherche"
            id="id_cherche"
            class="search_input"
            placeholder="cherchez par numéro  ..."
          />

          <input
            type="submit"
            value="CHERCHER"
            class="button_reinscription"
            name="chercher_btn"
          />
        </form>

        <h3>${ message }</h3>

        <c:choose>
          <c:when test="${ !empty noetudiant }">
            <h1> ${noetudiant } </h1>
          </c:when>

          <c:when test="${ !empty etudiant  }">
            <div class="main_inscription">
              <div class="formulaire_container">
                <h2 class="inscription_title">Inscription</h2>

                <i class="fas fa-university"></i>

                <form action="InscriptionServlet" method="post">
                   <input
                    type="text"
                    name="id"
                    id="id"
                    value="${etudiant.id }"
                    placeholder="le nom ..."
                  />
                 
                  <input
                    type="text"
                    name="nom"
                    id="nom"
                    value="${etudiant.nom }"
                    placeholder="le nom ..."
                  />
                  
                  <input
                    type="text"
                    name="prenom"
                    id="prenom"
                    value="${etudiant.prenom }"
                    placeholder="le prenom ..."
                  />
                  <input
                    type="date"
                    name="date_naissance"
                    id="date_naissance"
                    value="${etudiant.dataNaissance }"
                    placeholder="la date de naissance"
                  />

                  <input
                    type="text"
                    name="lieu_naissance"
                    id="lieu_naissance"
                    value="${etudiant.lieuNaissance }"
                    placeholder="lieu de la naissance ..."
                  />

                  <c:choose>
                    <c:when test="${ etudiant.sexe == 'homme' }">
                      <input
                        type="radio"
                        name="sexe"
                        id="sexe"
                        value="homme"
                        checked="checked"
                      />
                      HOMME
                    </c:when>

                    <c:otherwise>
                      <input type="radio" name="sexe" id="sexe" value="homme" />
                      HOMME
                    </c:otherwise>
                  </c:choose>

                  <c:choose>
                    <c:when test="${ etudiant.sexe == 'femme' }">
                      <input
                        type="radio"
                        name="sexe"
                        id="sexe"
                        value="femme"
                        checked="checked"
                      />
                      FEMME
                    </c:when>

                    <c:otherwise>
                      <input type="radio" name="sexe" id="sexe" value="femme" />
                      FEMME
                    </c:otherwise>
                  </c:choose>

                  <input
                    type="text"
                    name="telephone"
                    id="telephone"
                    value="${etudiant.telephone }"
                    placeholder="numéro telephone ..."
                  />
                  <input
                    type="text"
                    name="adresse"
                    id="adresse"
                    value="${etudiant.asresse }"
                    placeholder="l'adresse ..."
                  />
                  <input
                    type="text"
                    name="filiere"
                    id="filiere"
                    value="${etudiant.filiere }"
                    placeholder="la filiere ..."
                  />
                  
                   <input
                    type="text"
                    name="niveau_actuel"
                    id="filiere"
                    value="${etudiant.niveau_actuel}"
                    placeholder="la filiere ..."
                  />

                  <select name="niveau" id="niveau">
                    <option value="Premiére année">Premiére année</option>
                    <option value="Deuxiéme année">Deuxiéme année</option>
                    <option value=" Licence ">Licence</option>
                    <option value="Master 1">Master 1</option>
                    <option value="Master 2">Master 2</option>
                  </select>

                  <input
                    type="submit"
                    value="INSCRIPTION"
                    name="reinscrire_btn"
                    class="button_inscription"
                  />
                </form>
              </div>
            </div>
          </c:when>
        </c:choose>
      </div>
    </div>
  </body>
</html>
