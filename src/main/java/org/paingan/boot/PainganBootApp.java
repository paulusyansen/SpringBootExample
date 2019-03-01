package org.paingan.boot;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;


@EnableAutoConfiguration
@SpringBootApplication
public class PainganBootApp extends SpringBootServletInitializer {
	
	private static final Logger log = LoggerFactory.getLogger(PainganBootApp.class);

    private final Environment env;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PainganBootApp.class);
	}
	
	public PainganBootApp(Environment env) {
		this.env = env;
	}
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PainganBootApp.class);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
	}
	
	private static void logApplicationStartup(Environment env) {
        String protocol = "http";
        
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        
        if (StringUtils.isEmpty(contextPath)) {
            contextPath = "/";
        }
        
        String hostAddress = "localhost";
        
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        
		log.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t{}://localhost:{}{}\n\t"
						+ "External: \t{}://{}:{}{}\n\t"
						+ "Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"), 
				protocol, 
				serverPort, 
				contextPath, 
				protocol, 
				hostAddress,
				serverPort, 
				contextPath, 
				env.getActiveProfiles());
    }
}
