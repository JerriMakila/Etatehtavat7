<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css\main.css">
<script src="scripts/main.js"></script>
<title>Asiakkaat</title>
</head>
<body>
<table id="listaus">
	<thead>
		<tr>
			<th colspan="5" id="uusiAsiakas"><a href="lisaaasiakas.jsp" class="siirto">Lis�� uusi asiakas<span class="right-arrow"></span></a></th>
		</tr>
		<tr>
			<th>Hakusana:</th>
			<th colspan="3"><input type="text" id="hakusana"></th>
			<th><input type="button" value="Hae" id="hakunappi" onclick="haeAsiakkaat()"></th>
		</tr>			
		<tr>
			<th>Etunimi</th>
			<th>Sukunimi</th>
			<th>Puhelinnumero</th>
			<th>S�hk�posti</th>	
			<th></th>						
		</tr>
	</thead>
	<tbody id="asiakastiedot">
	</tbody>
</table>
<script>

document.getElementById("hakusana").addEventListener("keypress", function(event) {
	if (event.keyCode === 13) {
		event.preventDefault();
	    document.getElementById("hakunappi").click();
	}
});

haeAsiakkaat();

function haeAsiakkaat(){
	var asiakastiedot = document.getElementById("asiakastiedot");
	asiakastiedot.innerHTML = "";
	fetch("asiakkaat/" + document.getElementById("hakusana").value,{
	      method: 'GET'
	    })
	.then(function (response) {
		return response.json()	
	})
	.then(function (responseJson) {
		var asiakkaat = responseJson.asiakkaat;	
		var htmlStr="";
		for(var i=0;i<asiakkaat.length;i++){			
        	htmlStr+="<tr class='asiakasrivi'>" +
				"<td>" + asiakkaat[i].etunimi + "</td>" +
        		"<td>" + asiakkaat[i].sukunimi + "</td>" +
        		"<td>" + asiakkaat[i].puhelin + "</td>" +
        		"<td>" + asiakkaat[i].sposti + "</td>" +  
        		"<td><a href='muutaasiakas.jsp?id=" + asiakkaat[i].id + "'>Muuta</a>&nbsp;" +
        		"<span class='poista' onclick=poista('" + asiakkaat[i].id + "','" + asiakkaat[i].etunimi + "','" + asiakkaat[i].sukunimi + "')>Poista</span></td>";
        	htmlStr+="</tr>";        	
		}
		asiakastiedot.innerHTML = htmlStr;		
	})	
}

function poista(id, etunimi, sukunimi){
	if(confirm("Haluatko varmasti poistaa asiakkaan " + etunimi +" " + sukunimi + "?")){	
		fetch("asiakkaat/" + id,{
		      method: 'DELETE'		      	      
		    })
		.then(function (response) {
			return response.json()
		})
		.then(function (responseJson) {
			var vastaus = responseJson.response;
			
			if(vastaus == 0){
				alert("Asiakkaan poisto ep�onnistui.");
	        }else if(vastaus == 1){	        	
	        	alert("Asiakkaan poisto onnistui.");
				haeAsiakkaat();        	
			}	
		})		
	}
}

</script>
</body>
</html>