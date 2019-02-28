package org.paingan.boot;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

import id.co.elevenia.eventagg.EventAggregatorApp;
import id.co.elevenia.eventagg.config.DefaultProfileUtil;


//@EnableAutoConfiguration
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
	
	 @PostConstruct
	    public void initApplication() {
	        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
	        log.info(activeProfiles.toString());
	 }
	
	public static void main(String[] args) {
//		SpringApplication.run(MainApp.class, args);

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
        log.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\t{}://localhost:{}{}\n\t" +
                "External: \t{}://{}:{}{}\n\t" +
                "Profile(s): \t{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            protocol,
            serverPort,
            contextPath,
            protocol,
            hostAddress,
            serverPort,
            contextPath,
            env.getActiveProfiles());

        String configServerStatus = env.getProperty("configserver.status");
        
        if (configServerStatus == null) {
            configServerStatus = "Not found or not setup for this application";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "Config Server: \t{}\n----------------------------------------------------------", configServerStatus);
    }
	
	
//	@Bean
//	  public BCryptPasswordEncoder bCryptPasswordEncoder() {
//	      return new BCryptPasswordEncoder();
//	  }
//	
//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
//
//	public void sendMessage(String msg) {
//		kafkaTemplate.send(topic, msg);
//		System.out.println("[Main App] Sent sample message [" + msg + "] to " + topic);
//	}
//	
//	@KafkaListener(topics = "${kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
//	public void listen(String message) {
//		System.out.println("[Main App] Received Message in group - group-id: " + message);
//	}
//
//	public void run(ApplicationArguments args) throws Exception {
//		sendMessage("Hi Welcome to Spring For Apache Kafka");
//	}
}
