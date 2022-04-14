$(function(){

	let current = 0; 
	let animate = false;
	
	
	$("#next").click(function(){
		if(animate) return;
		animate = true;
		$(".banner_item").eq(current).stop().animate({left:"-100%"}, 1000);
		current++;
		if(current >= $(".banner_item").length) current = 0;
		$(".banner_item").eq(current).css("left", "100%").stop().animate({left:"0%"}, 1000, function(){
			
			animate = false;
		});
	});
	
	$("#prev").click(function(){
		if(animate) return;
		animate = true;
		
		$(".banner_item").eq(current).stop().animate({left:"100%"}, 1000);
		current--;
		if(current < 0) current = $(".banner_item").length - 1;
		$(".banner_item").eq(current).css("left", "-100%").stop().animate({left:"0%"}, 1000, function(){
			
			animate = false;
		});
	});
	
	setInterval(function(){
		$("#next").trigger("click");
	}, 5000)


})