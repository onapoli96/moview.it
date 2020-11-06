
function nascondiGruppi(){
$(".gruppo").hide();
$(".gruppo1").show();
$(".pagination li").removeClass("disabled");
}

function cambiaPagina(i){
	$(this).addClass("disabled");
	$(".pagination li").removeClass("disabled");
	$(".gruppo").hide();
	$("#gruppo"+i).show();
}