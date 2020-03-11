/*!
    * Start Bootstrap - SB Admin v6.0.0 (https://startbootstrap.com/templates/sb-admin)
    * Copyright 2013-2020 Start Bootstrap
    * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap-sb-admin/blob/master/LICENSE)
    */
    (function($) {
    "use strict";

    // Add active state to sidbar nav links
    var path = window.location.href; // because the 'href' property of the DOM element is the absolute path
        $("#layoutSidenav_nav .sb-sidenav a.nav-link").each(function() {
            if (this.href === path) {
                $(this).addClass("active");
            }
        });

    // Toggle the side navigation
    $("#sidebarToggle").on("click", function(e) {
        e.preventDefault();
        $("body").toggleClass("sb-sidenav-toggled");
    });

$('.submit').click(fuction(event) {
    var object=$('object').val()
    var email=$('email').val()
    var message=$('message').val()
    var statusElm=$('.status')
    statusElm.empty()
    
    if(email.length>5 && email.includes('@') && email.includes('.')) {
        statusElm.append('<div> Email is valid</div')
    } else {
        event.preventDefault()
        statusElm.append('<div> Email is not valid</div')
    }
  
    if(object.length >2) {
        statusElm.append('<div> Object is valid</div')
    } else {
        event.preventDefault()

        statusElm.append('<div> Object is not valid</div')
  
    }

    if(message.length> 20) {
        statusElm.append('<div> Message is valid</div')
    } else {
        event.preventDefault()

        statusElm.append('<div> Message is not valid</div')
  
    }


}



)



})
(jQuery);
