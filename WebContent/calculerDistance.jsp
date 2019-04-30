<%@page import="ville.bean.VilleFrance"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calcul de la distance</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<h1>Distance entre deux villes !</h1>
	<br/>
	<p>Vous pouvez ici calculer la distance séparant deux villes françaises</p>
	<a href="index.html" class = "btn btn-info" id="retourAccueil"/>Retour à l'accueil</a>
	<br/>

	<div class="col-lg-6 col-md-6">
		<form method="POST" action="CalculerDistance">
	     	Calcul de la distance entre : 
	     	<% ArrayList<VilleFrance> villes = new ArrayList<VilleFrance>();
	     	villes = (ArrayList<VilleFrance>) session.getAttribute("listeVilles");%>
			<select class="form-control" name="nomVilleDepart" id="nomVilleDepart">
			<%for(int i=0;i<villes.size();i++){
	     		%>
					<option value="<%=villes.get(i).getCodeINSEE()%>"><%=villes.get(i).getNom()%> (<%=villes.get(i).getCodePostal()%>)
					</option>
			<% }%>
			</select>
			et
			<select class="form-control" name="nomVilleArrivee" id="nomVilleArrivee">
			<%for(int i=0;i<villes.size();i++){
	     		%>
					<option value="<%=villes.get(i).getCodeINSEE()%>"><%=villes.get(i).getNom()%> (<%=villes.get(i).getCodePostal()%>)
					</option>
			<% }%>
			</select>
			
			<input TYPE="submit" class ="btn btn-primary" NAME="calcul" VALUE="Calculer">
		</form>
	</div>
	
	<% if((double)session.getAttribute("distance") != 0){ %>
		La distance entre <%=request.getAttribute("villeDepart") %> et <%=request.getAttribute("villeArrivee") %> est de <%=(double)session.getAttribute("distance") %> kilomètres
	<%}
		%>
	

</body>
</html>