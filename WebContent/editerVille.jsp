<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editer la ville</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<h1>Modifier la ville !</h1>
	<br/>
	<p>Pensez à bien valider le formulaire pour qu'il soit pris en compte !</p>
	<a href="index.html" class = "btn btn-info" id="retourAccueil"/>Retour à l'accueil</a>
	<br/>
	<div class="col-lg-6 col-md-6">
		<div class="panel panel-default ">
			<div class="panel-heading" align="center"><h4>Remplissez le formulaire :</h4></div>
				<div class="panel-body">
					<form method="POST" action="EditerVille" >
						<input type="hidden" name="CodeINSEE" value="<%=request.getAttribute("CodeINSEE") %>"/>
						<label>Nom</label> : <input class="form-control" type="text" name="Nom" value="<%=request.getAttribute("Nom") %>"/>
						<label>Code Postal</label> : <input class="form-control" type="text" name="CodePostal" value="<%=request.getAttribute("CodePostal") %>"/>
						<label>Libelle acheminement</label> : <input class="form-control" type="text" name="LibelleAcheminement" value="<%=request.getAttribute("LibelleAcheminement") %>"/>
						<label>Ligne5</label> : <input class="form-control" type="text" name="Ligne5" value="<%=request.getAttribute("Ligne5") %>"/>
						<label>Latitude</label> : <input class="form-control" type="text" name="Latitude" value="<%=request.getAttribute("Latitude") %>"/>
						<label>Longitude</label> : <input class="form-control" type="text" name="Longitude" value="<%=request.getAttribute("Longitude") %>"/>
						<br/>
						<input type="submit" class="btn btn-primary" value="Editer">
					</form>
				</div>
		</div>
	</div>
</body>
</html>