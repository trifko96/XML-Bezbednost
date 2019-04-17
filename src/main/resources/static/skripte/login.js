$(document).ready(function(){
	
	
	
	$("#butLog").click(function(event){
		event.preventDefault();
		var email = $("#korisIme").val();
		var password = $("#loz").val();
		
		customAjax({
			method: 'POST',
			url: "/auth/login",
			data: { 'email': email, 'password': password },
			success: function(jwt, status, xhr){
				if(xhr.status == 200){
			          localStorage.setItem('jwt', jwt);

			          customAjax({
			              url: '/User/getCurrentUser',
			              method: 'GET',
			              contentType: 'application/json',
			              success : function(data){
			                   window.location.href = '/html/admin.html';
			              },
			           });     
			        }
			},
		});
		
	});	
	
	
	$("#butReg").click(function(event){
		event.preventDefault();
		var lozinka = $("#pass");
		var novaLozinka = $("#passPon");
		var ime = $("#ime");
		var prezime = $("#prezime");
		var brTelefona = $("#telefon");
		var email = $("#email");
		
		
		if(!lozinka.val().trim() || !ime.val().trim() || !prezime.val().trim()
				|| !brTelefona.val().trim() || !email.val().trim() || isNaN(brTelefona.val()) ||
				!ispravanMail(email.val()) || !(lozinka.val()==novaLozinka.val())){
			
			if(!lozinka.val().trim()) {
				lozinka.addClass('bg-danger');
			}
			else {
				lozinka.removeClass('bg-danger');
			}
			
			if(!novaLozinka.val().trim())
				novaLozinka.addClass('bg-danger');
			else
				novaLozinka.removeClass('bg-danger');
			
			if(!ime.val().trim())
				ime.addClass('bg-danger');
			else
				ime.removeClass('bg-danger');
			
			if(!prezime.val().trim())
				prezime.addClass('bg-danger');
			else
				prezime.removeClass('bg-danger');
			
			if(!brTelefona.val().trim())
				brTelefona.addClass('bg-danger');
			else
				brTelefona.removeClass('bg-danger');
			
			if(!email.val().trim())
				email.addClass('bg-danger');
			else
				email.removeClass('bg-danger');
			
			if(isNaN(brTelefona.val()))
				$("#greskaTelefon").show().delay(4000).fadeOut();
			
			if(!ispravanMail(email.val()) && email.val().trim())
				$("#greskaEmailOblik").show().delay(4000).fadeOut();
			
			if(!(lozinka.val()==novaLozinka.val()))
				$("#greskaLozinka").show().delay(4000).fadeOut();
		} else {
			
			var user = new Object();
			user.email = email.val();
			user.password = lozinka.val();
			user.name = ime.val();
			user.surname = prezime.val();
			user.phoneNumber = brTelefona.val();
			customAjax({
				method: 'POST',
				url: '/User/create',
				data: JSON.stringify(user),
				contentType: 'application/json',
				success: function(data) {
					
						window.location.href = "/html/admin.html";
					 /*else if (data == "greskaKorIme"){
						$("#greskaKorIme").show().delay(4000).fadeOut();
					} else if (data == "greska"){
						$("#greskaEmail").show().delay(4000).fadeOut();
					}*/
				},
			});
		}
		
	});
	
	
	
});



