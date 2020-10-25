
// SmoothState
$(function(){
  'use strict';
  var $page = $('#main'),
      options = {
        debug: true,
        prefetch: true,
		forms: 'none',
        cacheLength: 2,

		onBefore: function ($currentTarget, $container) {
			$('html, body').animate({scrollTop: 0}, 750);
        },

		onStart: {
          duration: 2000,
          render: function ($container) {
            $container.addClass('is-exiting');
            smoothState.restartCSSAnimations();
			$('.preloader').fadeIn();
			$('.layer').fadeIn();
			$(function () {
				try{
					FB.XFBML.parse();
				}catch(ex){}
			})
          }
        },

        onReady: {
          duration: 2000,
          render: function ($container, $newContent) {
            $container.removeClass('is-exiting');
            $container.html($newContent);
			$('.preloader').fadeOut();
			$('.layer').delay(600).fadeOut();
			$.readyFn.execute();
          }
		}
      },
      smoothState = $page.smoothState(options).data('smoothState');
});


var images = new Array()
function preload() {
	for (i = 0; i < preload.arguments.length; i++) {
		images[i] = new Image()
		images[i].src = preload.arguments[i]
	}
}


// Navigation
$(document).ready(function($){


// Open / Close Menu
	(function() {
		var triggerBttn = document.getElementById( 'openMenu' ),
			overlay = document.getElementById( 'main-menu' ),
			closeBttn = document.getElementById( 'closeMenu' ),
			transEndEventNames = {
				'WebkitTransition': 'webkitTransitionEnd',
				'MozTransition': 'transitionend',
				'OTransition': 'oTransitionEnd',
				'msTransition': 'MSTransitionEnd',
				'transition': 'transitionend'
			},
			transEndEventName = transEndEventNames[ Modernizr.prefixed( 'transition' ) ],
			support = { transitions : Modernizr.csstransitions };

		function toggleOverlay() {
			if( classie.has( overlay, 'open' ) ) {
				classie.remove( overlay, 'open' );
				classie.add( overlay, 'close' );
				var onEndTransitionFn = function( ev ) {
					if( support.transitions ) {
						if( ev.propertyName !== 'visibility' ) return;
						this.removeEventListener( transEndEventName, onEndTransitionFn );
					}
					classie.remove( overlay, 'close' );
				};
				if( support.transitions ) {
					overlay.addEventListener( transEndEventName, onEndTransitionFn );
				}
				else {
					onEndTransitionFn();
				}
			}
			else if( !classie.has( overlay, 'close' ) ) {
				classie.add( overlay, 'open' );
			}
		}

		triggerBttn.addEventListener( 'click', toggleOverlay );
		closeBttn.addEventListener( 'click', toggleOverlay );
	})();


// When Menu Is Open Fade Out/In The Main content
	$(function () {
		$('#openMenu').click(function(){
			$(".menu-inner").css({"-webkit-overflow-scrolling":"touch"});
		});
	})
	$(function () {
		$('#closeMenu').click(function(){
			$(".menu-inner").css({"-webkit-overflow-scrolling":"auto"});
		});
	})


// Hover Effects
	$('.navigation-item-philosophy').hover(function() {
    	$('.navigation-item-philosophy .navigation-subitem').stop().slideDown(300);
		}, function() {
    	$('.navigation-item-philosophy .navigation-subitem').stop().slideUp(300);
	})

	$('.navigation-item-collections').hover(function() {
    	$('.navigation-item-collections .navigation-subitem').stop().slideDown(300);
		}, function() {
    	$('.navigation-item-collections .navigation-subitem').stop().slideUp(300);
	})

	$('.navigation-item-experience').hover(function() {
    	$('.navigation-item-experience .navigation-subitem').stop().slideDown(300);
		}, function() {
    	$('.navigation-item-experience .navigation-subitem').stop().slideUp(300);
	})


// Hover Effects
	$('.social-icon-item').hover(function() {
    	$(this).find('img:eq(1)').stop(true,true).fadeIn('fast');
    		}, function() {
    	$(this).find('img:eq(1)').fadeOut('fast');
	})


// Home Background Change On Link Hover
	var project = $('.navigation-container');
	var pLink = project.find('.navigation-item-link');
	var pBg = project.find('.slider-item');

	var changeBg = function() {
		var thisProject = $(this);
		var thisProjectIndex = thisProject.parent().index();
		var thisProjectBg = pBg.eq(thisProjectIndex);

		pBg.removeClass('slider-item--active');

		thisProjectBg.addClass('slider-item--active');
	};

	var showFirst = function() {
		pLink.parent().first().children().css('opacity', '1');
		pBg.children(':first-child').next().addClass('slider-item--active');
	}

	var init = function() {
		$(document).on('ready', showFirst);
		pLink.on('mouseenter', changeBg);
	};

	init();


});