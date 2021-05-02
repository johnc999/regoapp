<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

	<style>
		#main-div {margin-top: 50px;}
		#main-page-link {margin-top: 20px;}
	</style>
    <title>List Registrations</title>
  </head>
  <body>
	<div class="container" id="main-div">
	
		<h2>Registrations List</h2>
		
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th>Number Plate</th>
		      <th>Insurer</th>
		      <th>Type</th>
		      <th>Colour</th>
		      <th>Make</th>
		      <th>Model</th>
		    </tr>
		  </thead>
		  <tbody>
		    <#list registrations as registration>
		    <tr>
		      <td>${registration.numberplate}</td>
		      <td>${registration.insurer}</td>
		      <td>${registration.vehicletype}</td>
		      <td>${registration.colour}</td>
		      <td>${registration.make}</td>
		      <td>${registration.model}</td>
		    </tr>
		    </#list>
		  </tbody>
		</table>
		
	    <div class="container">
	      <div class="row">
	        <a href="/" class="linkcls" id="main-page-link">Main Menu</a>
	      </div>
	    </div>  
	</div>
</body>
</html>