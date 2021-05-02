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
    <title>Add Registration</title>
    <script>
	  function clearMsg() {
	    if (document.getElementById("msgid")) {
	      var element = document.getElementById("msgid");
		  element.parentNode.removeChild(element);
		}
	  }
	  function validateForm() {
	    if ((document.getElementById("numberplate").value.length == 0) || (document.getElementById("numberplate").value.length > 8)) {
	      alert('Please enter a valid Number Plate');
	      return false; 
	    }
	    if (document.getElementById("insurer").value == '00') {
	      alert('Please select a valid Insurer');
	      return false; 
	    }
	    if (document.getElementById("vehicletype").value == '00') {
	      alert('Please select a valid Vehicle Type');
	      return false; 
	    }
	    if (document.getElementById("colour").value == '00') {
	      alert('Please select a valid Colour');
	      return false; 
	    }
	    if ((document.getElementById("make").value.length == 0) || (document.getElementById("make").value.length > 15)) {
	      alert('Please enter a valid Make');
	      return false; 
	    }
	    if ((document.getElementById("model").value.length == 0) || (document.getElementById("model").value.length > 15)) {
	      alert('Please enter a valid Model');
	      return false; 
	    }
	    return true;
	  }
	</script>	
  </head>
  <body>

<div class="container" id="main-div">
  <form name="registration" action="addRegistration" method="POST" onsubmit="return validateForm()" autocomplete="off">
    <h2>Add Registration</h2>
    <#if message??>
          <strong style="color: red;" id="msgid">${message}</strong>
    </#if>
    <div class="row">
      <div class="col-md-6">
        <div class="form-group">
          <label for="first">Number Plate</label>
          <input type="text" class="form-control" placeholder="" id="numberplate" name="numberplate" onfocus="clearMsg();">
        </div>
      </div>

      <div class="col-md-6">
        <div class="form-group">
          <label for="last">Insurer</label>
          <div class="dropdown">
			  <select class="form-control" id="insurer" name="insurer">
			    <option value="00"></option> 
				<option value="11">AAMI</option>
				<option value="22">Allianz</option>
				<option value="33">NRMA</option>
				<option value="44">RACQ</option>
				<option value="55">Suncorp</option>
			  </select>
		  </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-md-6">
        <div class="form-group">
          <label for="company">Vehicle Type</label>
          <div class="dropdown">
			  <select class="form-control" id="vehicletype" name="vehicletype">
			    <option value="00"></option>
			    <option value="Convertible">Convertible</option>
			    <option value="Coupe">Coupe</option>
				<option value="Hatchback">Hatchback</option>
				<option value="Minivan">Minivan</option>
				<option value="Sedan">Sedan</option>
				<option value="Sports">Sports</option>
				<option value="Station Wagon">Station Wagon</option>
				<option value="SUV">SUV</option>
				<option value="White">Truck</option>
			  </select>
		  </div>
        </div>

      </div>
      <div class="col-md-6">
        <div class="form-group">
          <label for="phone">Colour</label>
          <div class="dropdown">
			  <select class="form-control" id="colour" name="colour">
			    <option value="00"></option>
				<option value="Black">Black</option>
				<option value="Blue">Blue</option>
				<option value="Brown">Brown</option>
				<option value="Green">Green</option>
				<option value="Grey">Grey</option>
				<option value="Red">Red</option>
				<option value="Silver">Silver</option>
				<option value="White">White</option>
				<option value="Yellow">Yellow</option>
			  </select>
		  </div>
        </div>
      </div>
    </div>
    
    <div class="row">
      <div class="col-md-6">
        <div class="form-group">
          <label for="email">Make</label>
          <input type="text" class="form-control" id="make" name="make" placeholder="">
        </div>
      </div>

      <div class="col-md-6">
        <div class="form-group">
          <label for="email">Model</label>
          <input type="text" class="form-control" id="model" name="model" placeholder="">
        </div>
      </div>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
    
    <div class="container">
      <div class="row">
        <a href="/" class="linkcls" id="main-page-link">Main Menu</a>
      </div>
    </div>    
  </form>
</div>

</body>
</html>