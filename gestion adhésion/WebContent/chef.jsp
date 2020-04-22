<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
 <link rel="stylesheet" href="./css/chef.css" />
</head>
<body>

	<h4>${message}</h4>
    <form action="ConservateurServlet" method="post">
      <div class="annee">
        <div class="btn1">
          <h2>Gerer Adhésion</h2>
          <input
            class="ouvrir"
            type="submit"
            value="Ouvrir période adhésion"
            name="ouvrir_annee"
          />
        </div>
        <div class="btn1">
          <input
            class="fermer"
            type="submit"
            value="Fermer période adhésion"
            name="fermer_annee"
          />
        </div>
      </div>
    </form>

</body>
</html>