$(function(){

	//菜单
	$('.nav-btn').on('click',function(){
		$('.hd-nav').addClass('nav-show');
	});
	$('.nav-close').on('click',function(){
		$('.hd-nav').removeClass('nav-show');
	})

});