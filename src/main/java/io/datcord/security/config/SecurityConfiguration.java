package io.datcord.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
/**
 * Configuration class for setting up security in the application.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    /**
     * Configures the security filter chain for HTTP requests.
     *
     * @param http the HttpSecurity object to configure security
     * @return the configured SecurityFilterChain
     * @throws Exception if configuration fails
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable) // Disable CSRF
                .authorizeHttpRequests(request -> request
                        .requestMatchers(rootDomain) // Match requests to the rootDomain variable value
                        .permitAll() // Permit all requests matching rootDomain
                        .anyRequest().authenticated()) // All other requests require authentication
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Stateless session management
        return http.build(); // Build and return the configured SecurityFilterChain
    }

    /**
     * Configures the authentication manager using AuthenticationConfiguration.
     *
     * @param config the AuthenticationConfiguration object for configuring authentication
     * @return the configured AuthenticationManager
     * @throws Exception if configuration fails
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager(); // Return the configured AuthenticationManager
    }

    /**
     * Holds the value of io.datcord.root-domain-all from application.properties.
     */
    @Value("${io.datcord.root-domain-all}") // Injecting property value from application.properties
    private String rootDomain; // Variable to hold the value of io.datcord.root-domain-all
}

