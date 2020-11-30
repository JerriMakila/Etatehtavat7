<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="scripts/main.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Asiakastietojen muuttaminen</title>
</head>
<body>
<form id="tiedot">
	<table>
		<thead>	
			<tr>
				<th colspan="5" id="takaisin"><a href="listaaasiakkaat.jsp" class="siirto"><span class="left-arrow"></span>Takaisin listaukseen</a></th>
			</tr>
			<tr>
				<th colspan="5" id="ohje">Syötä uudet tiedot niihin kenttiin, joita haluat muuttaa<br>Voit jättää tyhjiksi ne kentät, joita ei muuteta</th>
			</tr>	
			<tr>
				<th>Etunimi</th>
				<th>Sukunimi</th>
				<th>Puhelinnumero</th>
				<th>Sähköposti</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="data-input"><input type="text" name="etunimi" id="etunimi"></td>
				<td class="data-input"><input type="text" name="sukunimi" id="sukunimi"></td>
				<td class="data-input"><input type="text" name="puhelin" id="puhelin"></td>
				<td class="data-input"><input type="text" name="sposti" id="sposti"></td> 
				<td class="data-input"><input type="button" id="tallenna" value="Lisää" onclick="muutaTiedot()"></td>
			</tr>
		</tbody>
	</table>
	<input type="hidden" name="id" id="id">
</form>
<div id="ilmo"></div>
</body>
<script>

var tekstikentat = document.querySelectorAll(".data-input");

for(i=0; i<tekstikentat.length; i++){
	tekstikentat[i].addEventListener("keypress", function(event){
		if (event.keyCode === 13) {
			event.preventDefault();
		    document.getElementById("tallenna").click();
		}
	});
}

haeAsiakas(requestURLParam("id"));

function haeAsiakas(id){
	fetch("asiakkaat/haeyksi/" + id,{
	    method: 'GET'	      
	  })
	.then( function (response) {
		return response.json()
	})
	.then( function (responseJson) {
		document.getElementById("etunimi").setAttribute("placeholder", responseJson.etunimi);
		document.getElementById("sukunimi").setAttribute("placeholder", responseJson.sukunimi);	
		document.getElementById("puhelin").setAttribute("placeholder", responseJson.puhelin);	
		document.getElementById("sposti").setAttribute("placeholder", responseJson.sposti);	
		document.getElementById("id").value = responseJson.id;	
	});	
}

function muutaTiedot(){
	if(tarkastaKentat()){
		document.getElementById("etunimi").value = document.getElementById("etunimi").value.trim();
		document.getElementById("sukunimi").value = document.getElementById("sukunimi").value.trim();
		document.getElementById("puhelin").value = document.getElementById("puhelin").value.trim();
		document.getElementById("sposti").value = document.getElementById("sposti").value.trim();
		var formJsonStr = formDataToJSON(document.getElementById("tiedot"));
		
		fetch("asiakkaat",{
		      method: 'PUT',
		      body:formJsonStr
		    })
		.then( function (response) {
			return response.json();
		})
		.then( function (responseJson) {
			
			var vastaus = responseJson.response;		
			if(vastaus==0){
				document.getElementById("ilmo").innerHTML= "Tietojen päivitys epäonnistui";
	        }else if(vastaus==1){	        	
	        	document.getElementById("ilmo").innerHTML= "Tietojen päivitys onnistui";			      	
			}	
		});
		
		document.getElementById("tiedot").reset();
		setTimeout(function(){ haeAsiakas(document.getElementById("id").value); }, 2);
	}
}

function tarkastaKentat(){
	document.getElementById("ilmo").innerHTML = "";
	var paluuArvo = true;
	var nimiPattern = /^[a-zåäöA-ZÅÄÖ]{1,50}$/;
	var puhelinPattern = /^[+]?[0-9]{2,3}[-]?[0-9]{7,9}$/;
	var spostiPattern = /^[a-zA-Z]{1,}[\.]{0,1}[a-zA-Z]{0,}[@]{1}[a-zA-Z]{1,}[\.]{1}[a-zA-Z]{1,}$/;
	
	if(!nimiPattern.test(document.getElementById("etunimi").value) && document.getElementById("etunimi").value.length > 0){
		if(document.getElementById("etunimi").value.length > 50){
			ilmo = "Nimen enimmäispituus on 50 merkkiä";
		} else {
			ilmo = "Nimi voi sisältää vain kirjaimia a-ö";
		}
		document.getElementById("ilmo").innerHTML += "<div>" + ilmo + "</div>";
		paluuarvo = false;
	}
	
	if(document.getElementById("etunimi").value == ""){
		document.getElementById("etunimi").value = document.getElementById("etunimi").getAttribute("placeholder");
	}
	
	if(!nimiPattern.test(document.getElementById("sukunimi").value) && document.getElementById("sukunimi").value.length > 0){		
		if(document.getElementById("sukunimi").value.length > 50){
			ilmo = "Nimen enimmäispituus on 50 merkkiä";
		} else {
			ilmo = "Nimi voi sisältää vain kirjaimia a-ö";
		}
		
		document.getElementById("ilmo").innerHTML += "<div>" + ilmo + "</div>";
		paluuArvo = false;
	}
	
	if(document.getElementById("sukunimi").value == ""){
		document.getElementById("sukunimi").value = document.getElementById("sukunimi").getAttribute("placeholder");
	}
	
	if(!puhelinPattern.test(document.getElementById("puhelin").value) && document.getElementById("puhelin").value.length > 0){		
		document.getElementById("ilmo").innerHTML += "<div>Anna kelvollinen puhelinnumero</div>";
		paluuArvo = false;
	}
	
	if(document.getElementById("puhelin").value == ""){
		document.getElementById("puhelin").value = document.getElementById("puhelin").getAttribute("placeholder");
	}
	
	if(!spostiPattern.test(document.getElementById("sposti").value) && document.getElementById("sposti").value.length > 0){
		if(document.getElementById("sposti").value.length > 100){
			ilmo = "Sähköpostin enimmäispituus on 100 merkkiä"
		} else {
			ilmo = "Anna kelvollinen sähköpostiosoite muodossa \"esim@esim.fi\"";
		}
		
		document.getElementById("ilmo").innerHTML += "<div>" + ilmo + "</div>";
		paluuArvo = false;	
	} else if(document.getElementById("sposti").value.length > 100){
		document.getElementById("ilmo").innerHTML += "<div>Sähköposti voi olla maksimissaan 100 merkkiä pitkä</div>";
	}
	
	if(document.getElementById("sposti").value == ""){
		document.getElementById("sposti").value = document.getElementById("sposti").getAttribute("placeholder");
	}
	
	return paluuArvo;
}

</script>

</body>
</html>