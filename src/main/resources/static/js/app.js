(function($, document, window){
	
	$(document).ready(function(){
		
		$('#textSearch').hide();
		
		$('#btnSearch').click(function (){
			var textSearch = $('#textSearch').val();
			
			if (textSearch === '' || textSearch === null){
				if ($('#textSearch').is(":visible")){
					$('#textSearch').hide();
					$('#btnSearch').show();			
				}	
				else {
					$('#textSearch').show();
					$('#btnSearch').hide();
				}
				return;
			}
			
			window.location.replace("/search?text=" + textSearch);
			
		});
		
		$('#textSearch').keyup(function(e){
			var textSearch = $('#textSearch').val();
			
			if(e.keyCode == 13)
		    {
				if (textSearch === '' || textSearch === null){
					return;
				}
				window.location.replace("/search?text=" + textSearch);
		    }	
		});
		
		$('#textSearch').blur(function(){
			$('#textSearch').val('');
			$('#textSearch').hide();
			$('#btnSearch').show();
		});

		// Cloning main navigation for mobile menu
		$(".mobile-navigation").append($(".main-navigation .menu").clone());

		// Mobile menu toggle 
		$(".menu-toggle").click(function(){
			$(".mobile-navigation").slideToggle();
		});
		$(".search-form button").click(function(){
			$(this).toggleClass("active");
			var $parent = $(this).parent(".search-form");

			$parent.find("input").toggleClass("active").focus();
		});


		$(".slider").flexslider({
			controlNav: false,
			prevText:'<i class="fa fa-chevron-left"></i>',
			nextText:'<i class="fa fa-chevron-right"></i>',
		});
		if( $(".map").length ) {
			$('.map').gmap3({
				map: {
					options: {
						maxZoom: 14 
					}  
				},
				marker:{
					address: "40 Sibley St, Detroit",
				}
			},
			"autofit" );
	    	
	    }
	});

	$(window).load(function(){

	});

})(jQuery, document, window);