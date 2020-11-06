function invioDatiRicerca(){
	$.ajax({
		// definisco il tipo della chiamata
		type: "POST",
		// specifico la URL della risorsa da contattare
		url: "Ricerca",
		// passo dei dati alla risorsa remota
		data: "",
		// definisco il formato della risposta
		dataType: "html",
		// imposto un'azione per il caso di successo
		success: function(risposta){
			var div1 = $("#filmhome1");      
			var div2 = $("#filmhome2");      
			var json = JSON.parse(risposta);
			var primo = JSON.parse(json[1]);
			var secondo = JSON.parse(json[3]);
			printFilm(div1,primo);
			printFilm(div2,secondo);
			
		},
		// ed una per il caso di fallimento
		error: function(){
			alert("Chiamata fallita!!!");
		}
	});
}

function printFilm(contenitore,film){
	var trama= "trama non disponibile";
	if(film.trama!=undefined){
		trama=film.trama;
	};
	contenitore.html(
	'<div class="card">'+
    '<img class="card-img-top" src="'+film.poster+'" alt="Card image cap" >'+
    '<div class="card-body">'+
      '<h2 class="card-title">'+film.titolo+'</h2>'+
      '<p class="card-text">'+trama+'</p>'+
    '</div>'+
    '<div class="card-footer text-muted"> '+film.rilasciato+'  </div>'+
    '</div>');
}
