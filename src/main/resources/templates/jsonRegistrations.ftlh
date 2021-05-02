<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	<style>
		#main-div {margin-top: 50px;}
		#main-page-link {margin-top: 20px;}
		#json {background-color: #F2F2F2;}
	</style>
    <title>JSON Registrations</title>
    <script>
      const onPageLoad = async () => {
         const response = await fetch('http://localhost:8080/rego/registrations');
         const myJson = await response.json();
         document.getElementById("json").innerHTML = JSON.stringify(myJson, undefined, 2);
      }
    </script>
  </head>
  <body onload="onPageLoad()">
	<div class="container" id="main-div">
		<h2>JSON Registrations</h2>
		<pre id="json"></pre>
	    <div class="container">
	      <div class="row">
	        <a href="/" class="linkcls" id="main-page-link">Main Menu</a>
	      </div>
	    </div>  
	</div>
</body>
</html>