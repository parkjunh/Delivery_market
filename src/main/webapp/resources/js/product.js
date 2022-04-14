$(function() {

	$("#p_imgName").on('change',function(){
	  var fileName = $("#p_imgName").val();
	  $("#upload_name").val(fileName);
	});

})