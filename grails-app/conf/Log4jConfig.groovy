import org.apache.log4j.PatternLayout;

log4j =
{
    environments
    {
        production
        {
            appenders
            {
                console     name            : "stdout",
                            layout          : pattern( conversionPattern : '%d{yyyy-MM-dd HH:mm:ss} %-5p [%-18c{1}] %m%n' );

                rollingFile name            : "mainLog",
                            maxFileSize     : '100MB',
                            maxBackupIndex  : 5,
                            file            : "logs/website.log",
                            layout          : pattern( conversionPattern : '%d{yyyy-MM-dd HH:mm:ss} %-5p [%c{2}] %m%n' ),
                            encoding        : 'UTF-8';

            };
        
            error  'org.codehaus.groovy.grails.web.servlet',        // controllers
                   'org.codehaus.groovy.grails.web.pages',          // GSP
                   'org.codehaus.groovy.grails.web.sitemesh',       // layouts
                   'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
                   'org.codehaus.groovy.grails.web.mapping',        // URL mapping
                   'org.codehaus.groovy.grails.commons',            // core / classloading
                   'org.codehaus.groovy.grails.plugins',            // plugins
                   'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
                   'org.springframework',
                   'org.hibernate',
                   'net.sf.ehcache.hibernate';

            //all 'org.codehaus.groovy.grails.web.mapping'
                    
            info mainLog:   [
                                'grails.app.controllers',
                                'grails.app.services',
                                'grails.app.conf'
                            ];

            root
            {
                info 'stdout';
            };
        }
        development
        {
        	appenders
            {
                console     name            : "stdout",
                            layout          : pattern( conversionPattern : '%d{yyyy-MM-dd HH:mm:ss} %-5p [%-18c{1}] %m%n' );

                rollingFile name            : "mainLog",
                            maxFileSize     : '100MB',
                            maxBackupIndex  : 5,
                            file            : "logs/website.log",
                            layout          : pattern( conversionPattern : '%d{yyyy-MM-dd HH:mm:ss} %-5p [%c{2}] %m%n' ),
                            encoding        : 'UTF-8';

            };
        
            error  'org.codehaus.groovy.grails.web.servlet',        // controllers
                   'org.codehaus.groovy.grails.web.pages',          // GSP
                   'org.codehaus.groovy.grails.web.sitemesh',       // layouts
                   'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
                   'org.codehaus.groovy.grails.web.mapping',        // URL mapping
                   'org.codehaus.groovy.grails.commons',            // core / classloading
                   'org.codehaus.groovy.grails.plugins',            // plugins
                   'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
                   'org.springframework',
                   'org.hibernate',
                   'net.sf.ehcache.hibernate';

            //all 'org.codehaus.groovy.grails.web.mapping'
                    
            info mainLog:   [
                                'grails.app.controllers',
                                'grails.app.services',
                                'grails.app.conf'
                            ];

            root
            {
                info 'stdout';
            };
        }
		test
		{
			appenders
            {
                console     name            : "stdout",
                            layout          : pattern( conversionPattern : '%d{yyyy-MM-dd HH:mm:ss} %-5p [%-18c{1}] %m%n' );

                rollingFile name            : "mainLog",
                            maxFileSize     : '100MB',
                            maxBackupIndex  : 5,
                            file            : "logs/website.log",
                            layout          : pattern( conversionPattern : '%d{yyyy-MM-dd HH:mm:ss} %-5p [%c{2}] %m%n' ),
                            encoding        : 'UTF-8';

            };
        
            error  'org.codehaus.groovy.grails.web.servlet',        // controllers
                   'org.codehaus.groovy.grails.web.pages',          // GSP
                   'org.codehaus.groovy.grails.web.sitemesh',       // layouts
                   'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
                   'org.codehaus.groovy.grails.web.mapping',        // URL mapping
                   'org.codehaus.groovy.grails.commons',            // core / classloading
                   'org.codehaus.groovy.grails.plugins',            // plugins
                   'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
                   'org.springframework',
                   'org.hibernate',
                   'net.sf.ehcache.hibernate';

            //all 'org.codehaus.groovy.grails.web.mapping'
                    
            info mainLog:   [
                                'grails.app.controllers',
                                'grails.app.services',
                                'grails.app.conf'
                            ];

            root
            {
                info 'stdout';
            };
		}
    }
}
