$(document).ready(function(){

$(".navbar-link").click(function(event){
		
		$(".container-fluid").each(function(index, el) {
            $(this).hide();
        });
		
		var id = $(this).attr("id");
		if(id === "tabSer"){
			$("#tabSer").addClass('active');
			$("#tabKom").removeClass('active');
			$("#divSertifikat").show();
		} else if (id === "tabKom"){
			$("#tabKom").addClass('active');
			$("#tabSer").removeClass('active');
			$("#divKomunikacija").show();
		}

	});
	
	$("#tabSer").trigger('click');
	
	$("small").each(function(index, el){
		$(this).hide();
	});
	
});