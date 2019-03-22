$(document).ready(function(){
	
	$("small").each(function(index, el){
		$(this).hide();
	});
	
	$("#butLog").click(function(event){
		event.preventDefault();
		var korisnickoIme = $("#korisIme").val();
		var lozinka = $("#loz").val();
		
		if(korisnickoIme == "admin"){
			if(lozinka == "admin"){
				window.location.href = "html/admin.html";
			}
		} else {
			$("#greskaKorIme").show().delay(4000).fadeOut();
		}
			
			
		}
	});	
});