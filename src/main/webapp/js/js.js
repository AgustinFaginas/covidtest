function validarEmail(){
	var email = $('#email').val();
	email
	$.ajax({						
        type: 'POST',
        url: "http://localhost:8080/covidtest/validar-email",
        dataType: 'json',
        data: email,
        contentType: "application/json; charset=utf-8",
        success : function(data){
        	var a =  data;
        	if(a == 'OK'){
				$('.email').remove();
//				$('#email2').html("<div class='form-group has-success has-feedback'>"
//				+ 	"<input id='inputSuccess' path='email' type='email' class='col-sm-6 form-control email' placeholder='E-mail' required='required' onchange='validarEmail()'>"
//				+	"<span class='glyphicon glyphicon-ok form-control-feedback'></span>"
//				+	"<label class='control-label' for='inputSuccess'>Input with error and glyphicon</label>"
//				+ "</div>");

        	}
        	else if(a == 'BAD'){
				$('.email').remove();
				$('#email2').html("<div class='form-group has-error has-feedback'>"
				+ 	"<input id='inputError' path='email' type='email' class='col-sm-6 form-control email' placeholder='E-mail' required='required' onchange='validarEmail()'>"
				+	"<span class='glyphicon glyphicon-remove form-control-feedback'></span>"
				+	"<label class='control-label' for='inputError'>Input with error and glyphicon</label>"
				+ "</div>");

        	}
        }
	});
}
