modules = {
    application {
		dependsOn 'jquery, jquery-ui'
        resource url:'js/application.js' , disposition: 'head'
		resource url: 'css/jquery.mobile-1.3.2.min.css'
		resource url: 'js/jquery.mobile-1.3.2.js', disposition: 'head'
		resource url: 'js/themes/lightcolor/blue/jtable.css'
		resource url: 'js/jquery.jtable.min.js', disposition: 'head'
		resource url: 'css/main.css'
		resource url: '/js/jquery.mask.min.js', disposition: 'head'
    }

}