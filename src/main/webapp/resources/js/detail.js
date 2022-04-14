$(function (){
	
	let totalCount = 1;
	let finalPrice = $("#final").attr("data-value");
	
	$("#p_count").val(totalCount);
	$("#p_price").val(totalCount*finalPrice);
	

	
	
	
	$("#decrease").click(function(){
		totalCount--;
		if(totalCount < 1) totalCount =1;
		$(".total").html(totalCount);
		$("#final").html(numberWithCommas(totalCount*finalPrice));
		
		$("#p_count").val(totalCount);
		$("#p_price").val(totalCount*finalPrice);
	
	})
	$("#increase").click(function(){
		totalCount++;
		if(totalCount >= 100) totalCount = 100;
		$(".total").html(totalCount);
		$("#final").html(numberWithCommas(totalCount*finalPrice));
		
		$("#p_count").val(totalCount);
		$("#p_price").val(totalCount*finalPrice);
		
	})
	
	
		
	
	
})

function numberWithCommas(x) {
	return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g,","); 
	}
	