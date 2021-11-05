package com.ibm.grupo2;

import com.ibm.grupo2.config.JWTAuthorizationFilter;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class Grupo2Application {

    @Autowired
    private Environment env;
    
    public static void main(String[] args) {
        SpringApplication.run(Grupo2Application.class, args);
    }
    
    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/auth/login").permitAll()
                    .anyRequest().authenticated();
        }

        @Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200", env.getProperty("spring.evaluacion.allowed-origins"), env.getProperty("spring.tramites.allowed-origins")));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Arrays.asList("Content-Type","Authorization"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		 FilterRegistrationBean<CorsFilter> bean = new  FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
		 bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		 return bean;
	}

    }
}
