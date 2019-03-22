$(document).ready(function(){
	
	var odabraniTip = "";
	
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

	$.ajax({
		type: "GET",
		url: "/Certificate/getAll",
		contentType: 'application/json',
		success: function(data){
			$("#tabelaNovihSertifikata").html("");
			upisiSertifikate(data);
		},
	});
	
	function upisiSertifikate(data) {
		for(i = 0; i < data.length; i++){
			if(data[i].revoked == true){
				if(data[i].idNadSertifikata != null){
					var pom = '<tr><td>'+data[i].idNadSertifikata+'</td>'+
					'<td>'+data[i].tip+'</td>'+
					'<td>'+data[i].datumIzdavanja+'</td>'+
					'<td>'+data[i].datumIsteka+'</td>'+
					'<td> POVUCEN </td></tr>';
				} else {
					var pom = '<tr><td>/</td>'+
					'<td>'+data[i].tip+'</td>'+
					'<td>'+data[i].datumIzdavanja+'</td>'+
					'<td>'+data[i].datumIsteka+'</td>'+
					'<td> POVUCEN </td></tr>';
				}
			}
				
			else {
				if(data[i].idNadSertifikata != null){
					var pom = '<tr><td>'+data[i].idNadSertifikata+'</td>'+
					'<td>'+data[i].tip+'</td>'+
					'<td>'+data[i].datumIzdavanja+'</td>'+
					'<td>'+data[i].datumIsteka+'</td>'+
					'<td> VALIDAN </td>'+
					'<td><button id="'+data[i].id+'" class="btn btn-link">Povuci sertifikat</button></td></tr>';
				} else {
					var pom = '<tr><td>/</td>'+
					'<td>'+data[i].tip+'</td>'+
					'<td>'+data[i].datumIzdavanja+'</td>'+
					'<td>'+data[i].datumIsteka+'</td>'+
					'<td> VALIDAN </td>'+
					'<td><button id="'+data[i].id+'" class="btn btn-link">Povuci sertifikat</button></td></tr>';
				}
			}
			$("#tabelaNovihSertifikata").append(pom);
		}
	}
	
	
	$("#tabelaNovihSertifikata").on('click', 'button', function(event){
		var id = $(this).attr('id');
		$.ajax({
			type: "POST",
			url: "/Certificate/"+id,
			contentType: 'application/json',
			success: function(data){
				$.ajax({
					type: "GET",
					url: "/Certificate/getAll",
					contentType: 'application/json',
					success: function(data){
						$("#tabelaNovihSertifikata").html("");
						upisiSertifikate(data);
						$.ajax({
							type: "GET",
							url: "/Certificate/unrevoked",
							contentType: 'application/json',
							success: function(data){
								$("#comboSertifikat1").html("");
								$("#comboSertifikat2").html("");
								upisiValidne(data);
							},
						});
						
						$.ajax({
							type: "GET",
							url: "/Certificate/authority",
							contentType: 'application/json',
							success: function(data){
								$("#comboSertifikat").html("");
								upisiCa(data);
							},
						});
					},
				});
			},
		});
	});
	
	$.ajax({
		type: "GET",
		url: "/Certificate/unrevoked",
		contentType: 'application/json',
		success: function(data){
			$("#comboSertifikat1").html("");
			$("#comboSertifikat2").html("");
			upisiValidne(data);
		},
	});
	
	$.ajax({
		type: "GET",
		url: "/Certificate/authority",
		contentType: 'application/json',
		success: function(data){
			$("#comboSertifikat").html("");
			upisiCa(data);
		},
	});
	
	function upisiValidne(data){
		for(var i = 0;i < data.length; i++){
			var pom = '<option value ="'+data[i].id+'">'+data[i].id+'</option>';
			$("#comboSertifikat1").append(pom);
			$("#comboSertifikat2").append(pom);
		}
	}
	
	function upisiCa(data){
		for(var i = 0;i < data.length; i++){
			var pom = '<option value ="'+data[i].id+'">'+data[i].id+'</option>';
			$("#comboSertifikat").append(pom);
		}
	}
	
	function vratiPocetno(){
		$("#dodajSertifikat").html("");
		var pom = '<tr><td>Kreiraj sertifikat za:</td>'+
		'<td align="center"><select id="comboSertifikatN">'+
		'<option value="ROOT">Korenski sertifikat</option>'+
		'<option value="PERSON">Osobu</option>'+
		'<option value="APPLICATION">Aplikaciju</option>'+
		'<option value="ORGANIZATION">Organizaciju</option>'+
		'<option value="EQUIPMENT">Opremu</option>'+
		'</select></td><td>'+
		'<td colspan="2" align="center"><button id="nastavi" class="btn btn-outline-dark">Nastavi</button>'+
		'</td></tr>';
		$("#dodajSertifikat").append(pom);
	}
	
	function ocistiFormu(){
		$("#nadSertifikat").val("");
		$("#subject").val("");
		$("#datumIzdavanja").val("");
		$("#datumIsticanja").val("");
		$("#checkCA").checked = false;
	}
	
	$("#kreirajSert").click(function(event){
		if(odabraniTip == "ROOT"){
			var sertifikat = new Object();
			sertifikat.nazivOrganizacije = $("#nazivOrganizacijeRoot").val();
			sertifikat.datumIzdavanja = $("#datumIzdavanjaRoot").val();
			sertifikat.datumIsteka = $("#datumIsticanjaRoot").val();
			sertifikat.tip = "ROOT";
			
			$.ajax({
				type: "POST",
				url: "/Certificate/create",
				data: JSON.stringify(sertifikat),
				contentType: 'application/json',
				success: function(data){
					$.ajax({
						type: "GET",
						url: "/Certificate/getAll",
						contentType: 'application/json',
						success: function(data){
							$("#tabelaNovihSertifikata").html("");
							upisiSertifikate(data);
						},
					});
				},
			});
			vratiPocetno();
			
		} else if(odabraniTip == "PERSON"){
			var sertifikat = new Object();
			sertifikat.nadSertifikatId = $("#comboSertifikat option:selected").val();
			sertifikat.datumIzdavanja = $("#datumIzdavanjaOsoba").val();
			sertifikat.datumIsteka = $("#datumIsticanjaOsoba").val();
			sertifikat.authority = $("#dozvolaZaIzdavanjeOsoba").val();
			sertifikat.tip = "PERSON";
			sertifikat.nazivOrganizacije = $("#nazivOrganizacijeOsoba").val();
			sertifikat.ime = $("#imeOsoba").val();
			sertifikat.prezime = $("#prezimeOsoba").val();
			sertifikat.drzava = $("#drzavaOsoba").val();
			sertifikat.email = $("#emailOsoba").val();
			
			$.ajax({
				type: "POST",
				url: "/Certificate/create",
				data: JSON.stringify(sertifikat),
				contentType: 'application/json',
				success: function(data){
					$.ajax({
						type: "GET",
						url: "/Certificate/getAll",
						contentType: 'application/json',
						success: function(data){
							$("#tabelaNovihSertifikata").html("");
							upisiSertifikate(data);
						},
					});
				},
			});
			vratiPocetno();
		}
		else if(odabraniTip == "APPLICATION"){
			var sertifikat = new Object();
			sertifikat.nadSertifikatId = $("#comboSertifikat option:selected").val();
			sertifikat.datumIzdavanja = $("#datumIzdavanjaAplikacija").val();
			sertifikat.datumIsteka = $("#datumIsticanjaAplikacija").val();
			sertifikat.authority = $("#dozvolaZaIzdavanjeAplikacija").val();
			sertifikat.tip = "APPLICATION";
			sertifikat.nazivOrganizacije = $("#nazivOrganizacijeAplikacija").val();
			sertifikat.nazivAplikacije = $("#nazivAplikacija").val();
			sertifikat.verzija = $("#verzijaAplikacija").val();
		
			$.ajax({
				type: "POST",
				url: "/Certificate/create",
				data: JSON.stringify(sertifikat),
				contentType: 'application/json',
				success: function(data){
					$.ajax({
						type: "GET",
						url: "/Certificate/getAll",
						contentType: 'application/json',
						success: function(data){
							$("#tabelaNovihSertifikata").html("");
							upisiSertifikate(data);
						},
					});
				},
			});
			vratiPocetno();
		}
		
		else if(odabraniTip == "ORGANIZATION"){
			var sertifikat = new Object();
			sertifikat.nadSertifikatId = $("#comboSertifikat option:selected").val();
			sertifikat.datumIzdavanja = $("#datumIzdavanjaOrganizacija").val();
			sertifikat.datumIsteka = $("#datumIsticanjaOrganizacija").val();
			sertifikat.authority = $("#dozvolaZaIzdavanjeOrganizacija").val();
			sertifikat.tip = "ORGANIZATION";
			sertifikat.nazivOrganizacije = $("#nazivOrganizacijeOrganizacija").val();
			sertifikat.drzava = $("#drzavaOrganizacija").val();
			sertifikat.PTT = $("#pttOrganizacija").val();
			sertifikat.adresa = $("#adresaOrganizacija").val();
		
			$.ajax({
				type: "POST",
				url: "/Certificate/create",
				data: JSON.stringify(sertifikat),
				contentType: 'application/json',
				success: function(data){
					$.ajax({
						type: "GET",
						url: "/Certificate/getAll",
						contentType: 'application/json',
						success: function(data){
							$("#tabelaNovihSertifikata").html("");
							upisiSertifikate(data);
						},
					});
				},
			});
			vratiPocetno();
		}
		
		else if(odabraniTip == "EQUIPMENT"){
			var sertifikat = new Object();
			sertifikat.nadSertifikatId = $("#comboSertifikat option:selected").val();
			sertifikat.datumIzdavanja = $("#datumIzdavanjaOprema").val();
			sertifikat.datumIsteka = $("#datumIsticanjaOprema").val();
			sertifikat.authority = $("#dozvolaZaIzdavanjeOprema").val();
			sertifikat.tip = "EQUIPMENT";
			sertifikat.nazivOrganizacije = $("#nazivOrganizacijeOprema").val();	
			sertifikat.MAC = $("#macOprema").val();
			sertifikat.nazivOpreme = $("#nazivOprema").val();
			sertifikat.drzava = $("#drzavaOprema").val();
			sertifikat.idOpreme = $("#idOprema").val();
		
			$.ajax({
				type: "POST",
				url: "/Certificate/create",
				data: JSON.stringify(sertifikat),
				contentType: 'application/json',
				success: function(data){
					$.ajax({
						type: "GET",
						url: "/Certificate/getAll",
						contentType: 'application/json',
						success: function(data){
							$("#tabelaNovihSertifikata").html("");
							upisiSertifikate(data);
						},
					});
				},
			});
			vratiPocetno();
		}
		
	});
	
	$("#nastavi").click(function(event){
		odabraniTip = $("#comboSertifikatN option:selected").val();
		if(odabraniTip == "ROOT"){
			vratiPocetno();
			dodajZaRoot();
			dodajDugme();
		}
		else if(odabraniTip == "PERSON"){
			vratiPocetno();
			dodajZaOsobu();
			dodajDugme();
		}
		else if(odabraniTip == "APPLICATION"){
			vratiPocetno();
			dodajZaAplikaciju();
			dodajDugme();
		}
		else if(odabraniTip == "ORGANIZATION"){
			vratiPocetno();
			dodajZaOrganizaciju();
			dodajDugme();
		}
		else if(odabraniTip == "EQUIPMENT"){
			vratiPocetno();
			dodajZaOpremu();
			dodajDugme();
		}
	});
	
	function dodajZaRoot(){
		var pom = '<tr><td>Datum izdavanja:</td>'+
		'<td><input type="date" id="datumIzdavanjaRoot"/></td></tr>'+
		'<tr><td>Datum isticanja:</td>'+
		'<td><input type="date" id="datumIsticanjaRoot"/></td></tr>'+
		'<tr><td>Naziv organizacije:</td>'+
		'<td><input type="text" id="nazivOrganizacijeRoot"/></td></tr>';
		$("#dodajSertifikat").append(pom);
	}
	
	function dodajZaOsobu(){
		var pom = '<tr><td>Datum izdavanja:</td>'+
		'<td><input type="date" id="datumIzdavanjaOsoba"/></td></tr>'+
		'<tr><td>Datum isticanja:</td>'+
		'<td><input type="date" id="datumIsticanjaOsoba"/></td></tr>'+
		'<tr><td>Naziv organizacije:</td>'+
		'<td><input type="text" id="nazivOrganizacijeOsoba"/></td></tr>'+
		'<tr><td>Nadsertifikat:</td>'+
		'<td><select id = "comboSertifikat"></select></td></tr>'+
		'<tr><td>Dozvola za izdavanje:</td>'+
		'<td><input type="checkbox" id="dozvolaZaIzdavanjeOsoba"/></td></tr>'+
		'<tr><td>Ime:</td>'+
		'<td><input type="text" id="imeOsoba"/></td></tr>'+
		'<tr><td>Prezime:</td>'+
		'<td><input type="text" id="prezimeOsoba"/></td></tr>'+
		'<tr><td>Drzava:</td>'+
		'<td><input type="text" id="drzavaOsoba"/></td></tr>'+
		'<tr><td>Email:</td>'+
		'<td><input type="text" id="emailOsoba"/></td></tr>';
		$("#dodajSertifikat").append(pom);
	}
	
	function dodajZaAplikaciju(){
		var pom = '<tr><td>Datum izdavanja:</td>'+
		'<td><input type="date" id="datumIzdavanjaAplikacija"/></td></tr>'+
		'<tr><td>Datum isticanja:</td>'+
		'<td><input type="date" id="datumIsticanjaAplikacija"/></td></tr>'+
		'<tr><td>Naziv organizacije:</td>'+
		'<td><input type="text" id="nazivOrganizacijeAplikacija"/></td></tr>'+
		'<tr><td>Nadsertifikat:</td>'+
		'<td><select id = "comboSertifikat"></select></td></tr>'+
		'<tr><td>Dozvola za izdavanje:</td>'+
		'<td><input type="checkbox" id="dozvolaZaIzdavanjeAplikacija"/></td></tr>'+
		'<tr><td>Naziv aplikacije:</td>'+
		'<td><input type="text" id="nazivAplikacija"/></td></tr>'+
		'<tr><td>Verzija:</td>'+
		'<td><input type="text" id="verzijaAplikacija"/></td></tr>';
		$("#dodajSertifikat").append(pom);
	}
	
	function dodajZaOrganizaciju(){
		var pom = '<tr><td>Datum izdavanja:</td>'+
		'<td><input type="date" id="datumIzdavanjaOrganizacija"/></td></tr>'+
		'<tr><td>Datum isticanja:</td>'+
		'<td><input type="date" id="datumIsticanjaOrganizacija"/></td></tr>'+
		'<tr><td>Naziv organizacije:</td>'+
		'<td><input type="text" id="nazivOrganizacijeOrganizacija"/></td></tr>'+
		'<tr><td>Nadsertifikat:</td>'+
		'<td><select id = "comboSertifikat"></select></td></tr>'+
		'<tr><td>Dozvola za izdavanje:</td>'+
		'<td><input type="checkbox" id="dozvolaZaIzdavanjeOrganizacija"/></td></tr>'+
		'<tr><td>PTT:</td>'+
		'<td><input type="text" id="pttOrganizacija"/></td></tr>'+
		'<tr><td>Drzava:</td>'+
		'<td><input type="text" id="drzavaOrganizacija"/></td></tr>'+
		'<tr><td>Adresa:</td>'+
		'<td><input type="text" id="adresaOrganizacija"/></td></tr>';
		$("#dodajSertifikat").append(pom);
	}
	
	function dodajZaOpremu(){
		var pom = '<tr><td>Datum izdavanja:</td>'+
		'<td><input type="date" id="datumIzdavanjaOprema"/></td></tr>'+
		'<tr><td>Datum isticanja:</td>'+
		'<td><input type="date" id="datumIsticanjaOprema"/></td></tr>'+
		'<tr><td>Naziv organizacije:</td>'+
		'<td><input type="text" id="nazivOrganizacijeOprema"/></td></tr>'+
		'<tr><td>Nadsertifikat:</td>'+
		'<td><select id = "comboSertifikat"></select></td></tr>'+
		'<tr><td>Dozvola za izdavanje:</td>'+
		'<td><input type="checkbox" id="dozvolaZaIzdavanjeOprema"/></td></tr>'+
		'<tr><td>MAC:</td>'+
		'<td><input type="text" id="macOprema"/></td></tr>'+
		'<tr><td>Naziv opreme:</td>'+
		'<td><input type="text" id="nazivOprema"/></td></tr>'+
		'<tr><td>Drzava:</td>'+
		'<td><input type="text" id="drzavaOprema"/></td></tr>'+
		'<tr><td>ID opreme:</td>'+
		'<td><input type="text" id="idOprema"/></td></tr>';
		$("#dodajSertifikat").append(pom);
	}
	
	function dodajDugme(){
		var pom = '<tr><td align="center" colspan="2"><button class="btn btn-outline-dark" id="kreirajSert">Kreiraj</button></td></tr>';
		$("#dodajSertifikat").append(pom);
	}
	
});
