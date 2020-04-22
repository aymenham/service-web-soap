<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/adhesion.css" />
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
	<h3 class="message">${message }</h3>
    <div class="main_reinscription">
      <div class="search">
        <form action="AdhesionServlet" method="post">
          <input
            type="text"
            name="id_cherche"
            id="id_cherche"
            class="search_input"
            placeholder="entrer numéro etudiant  ..."
          />

          <input
            type="submit"
            value="adhésion"
            class="button_reinscription"
            name="chercher_btn"
          />
        </form>

     
    </div>
    
   
    
    </div>
    
    



</body>
</html>