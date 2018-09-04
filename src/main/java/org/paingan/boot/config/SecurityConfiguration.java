package org.paingan.boot.config;

import javax.annotation.PostConstruct;

import org.paingan.boot.security.AuthoritiesConstants;
import org.paingan.boot.security.JWTAuthenticationFilter;
import org.paingan.boot.security.JWTAuthorizationFilter;
import org.paingan.boot.security.SecurityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final AuthenticationManagerBuilder authenticationManagerBuilder;
	
    @Autowired
	private UserDetailsService userDetailsService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder, UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
    	this.authenticationManagerBuilder = authenticationManagerBuilder;
    	this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @PostConstruct
    public void init() {
        try {
            authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        } catch (Exception e) {
            throw new BeanInitializationException("Security configuration failed", e);
        }
    }
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//    	http
//        	.authorizeRequests()
//        	.antMatchers("/").permitAll()
//        	.antMatchers("/chart").permitAll()
//            .antMatchers("/form").authenticated()
//            .anyRequest().permitAll()
//            .and()
//            .formLogin()
//             	.loginPage("/login")
//             	.permitAll()
//             	.and()
//             	.logout()
//             	.permitAll();
    	 
//        http.cors().and().csrf().disable().authorizeRequests()
//                .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//                // this disables session creation on Spring Security
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    	
    	http.
		authorizeRequests()
			.antMatchers("/chart","/form").hasAnyRole(AuthoritiesConstants.USER.getText(),AuthoritiesConstants.ADMIN.getText())
			.antMatchers(HttpMethod.POST,"/registration").hasRole(AuthoritiesConstants.ADMIN.getText())
			.antMatchers("/actuator/**").permitAll()
			.antMatchers("/static/**").permitAll()
            .antMatchers( "/favicon.ico").permitAll()
			.and().csrf().disable().formLogin()
			.loginPage("/login").failureUrl("/login?error=true")
			.defaultSuccessUrl("/")
			.usernameParameter("username")
			.passwordParameter("password")
			.and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/").and().exceptionHandling()
			.accessDeniedPage("/login?accessdenied=true");

    	
//    	
//    	http.cors().and().csrf().disable().authorizeRequests()
//			.antMatchers(HttpMethod.GET, SecurityConstants.SIGN_UP_URL).permitAll()
//			 .and()
//             .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//             .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//             // this disables session creation on Spring Security
//             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//			.and().csrf().disable().formLogin()
//			.loginPage("/login").failureUrl("/login?error=true")
//			.defaultSuccessUrl("/")
//			.usernameParameter("username")
//			.passwordParameter("password")
//			.and().logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/").and().exceptionHandling()
//			.accessDeniedPage("/login?accessdenied=true")
//			.and().addFilter(new JWTAuthenticationFilter(authenticationManager()))
//			.addFilter(new JWTAuthorizationFilter(authenticationManager()))
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    	
    }

}
