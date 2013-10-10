import grails.plugins.springsecurity.SecurityConfigType


grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    xml:           ['text/xml', 'application/xml']
]

grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"

grails.views.gsp.sitemesh.preprocess = true
grails.scaffolding.templates.domainSuffix = 'Instance'

grails.json.legacy.builder = false
grails.enable.native2ascii = true
grails.spring.bean.packages = []
grails.web.disable.multipart=false
grails.gorm.failOnError=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true
		disable.auto.recompile = false
		grails.gsp.enable.reload = true
    }
    production {
        grails.logging.jul.usebridge = false
    }
}

// log4j configuration
log4j = {
    
    appenders {
        console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    }

	root {
		error()
	}
	
	error stdout: "StackTrace"
	
    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',           // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
//	debug  'org.hibernate'
//  debug  'net.sf.ehcache.hibernate'
//	debug  'org.codehaus.groovy.grails.orm.hibernate',
//	 	   'org.springframework'
}

grails.views.javascript.library="jquery"

//log4j.logger.org.springframework.security='off,stdout'
grails.plugins.springsecurity.password.algorithm='SHA-512'
//grails.plugins.springsecurity.portMapper.httpPort = "8080"      //port map for http
//grails.plugins.springsecurity.portMapper.httpsPort = "8443"     //port map for https

grails.plugins.springsecurity.userLookup.userDomainClassName = 'org.dupreez.procureman.User'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'org.dupreez.procureman.UserRole'
grails.plugins.springsecurity.authority.className = 'org.dupreez.procureman.Role'
grails.plugins.springsecurity.userLookup.usernamePropertyName = 'email'

//grails.plugins.springsecurity.rejectIfNoRule = true             //force authentication if no rule exists

//grails.plugins.springsecurity.failureHandler.defaultFailureUrl = '/'
//grails.plugins.springsecurity.auth.loginFormUrl = '/'


grails.plugins.springsecurity.securityConfigType = SecurityConfigType.InterceptUrlMap
grails.plugins.springsecurity.interceptUrlMap = [
    '/person/**':    ['ROLE_ADMIN'],
	'/user/**':    	 ['ROLE_ADMIN', 'IS_AUTHENTICATED_FULLY'],
    '/js/**':        ['IS_AUTHENTICATED_ANONYMOUSLY'],
    '/css/**':       ['IS_AUTHENTICATED_ANONYMOUSLY'], 
    '/images/**':    ['IS_AUTHENTICATED_ANONYMOUSLY'],
//    '/*':            ['IS_AUTHENTICATED_FULLY'],
    '/login/**':     ['IS_AUTHENTICATED_ANONYMOUSLY'], 
    '/logout/**':    ['IS_AUTHENTICATED_ANONYMOUSLY'],
	'/**':    	     ['IS_AUTHENTICATED_FULLY']
]
