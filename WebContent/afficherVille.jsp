<%@page import="ville.bean.VilleFrance"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des villes</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<h1>Liste des villes !</h1>
	<br/>
	<p>Voici l'ensemble des villes françaises contenues dans la base de données</p>
	<a href="index.html" class = "btn btn-info" id="retourAccueil"/>Retour à l'accueil</a>
	<br/>
	<div class="col-lg-12 col-md-12">
		<div class="panel panel-default ">
			<div class="panel-heading" align="center"><h4>Liste des villes :</h4></div>
			<div class="panel-body">
				<table class="table table-condensed">
					<thead>
			        	<tr>
				            <th>Code INSEE</th>
				            <th>Nom</th>
				            <th>Code Postal</th>
				            <th>Latitude</th>
				            <th>Longitude</th>
			        	</tr>
			        </thead>
			        <tbody>
			        	<%ArrayList<VilleFrance> villes = new ArrayList<VilleFrance>();
			        	villes = (ArrayList<VilleFrance>) session.getAttribute("listeVilles");
			        	for(int i=0;i<villes.size();i++){
			        		%>
				        	<tr>
				        		<td><%=villes.get(i).getCodeINSEE() %></td>
					            <td><%=villes.get(i).getNom() %></td>
					            <td><%=villes.get(i).getCodePostal() %></td>
					            <td><%=villes.get(i).getLatitude() %></td>
					            <td><%=villes.get(i).getLongitude() %></td>
					        </tr>
			        	<% }%>			       
			        </tbody>
				</table>
			</div>
		</div>
	</div>
				
</body>
</html>