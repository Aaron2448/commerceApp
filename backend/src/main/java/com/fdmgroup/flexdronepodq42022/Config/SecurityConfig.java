package com.fdmgroup.flexdronepodq42022.Config;

import com.fdmgroup.flexdronepodq42022.Security.JwtAuthenticationEntryPoint;
import com.fdmgroup.flexdronepodq42022.Security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    private final JwtAuthenticationEntryPoint authenticationEntryPoint;

    private final JwtAuthenticationFilter authenticationFilter;

    public SecurityConfig(UserDetailsService userDetailsService,
                          JwtAuthenticationEntryPoint authenticationEntryPoint,
                          JwtAuthenticationFilter authenticationFilter) {
        this.userDetailsService = userDetailsService;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.authenticationFilter = authenticationFilter;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize
                                /**
                                 * Default User Section
                                 */
                                .requestMatchers(HttpMethod.GET, "/api/v1/auth/profile").authenticated()
                                .requestMatchers(HttpMethod.POST, "/api/v1/auth/**").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/api/v1/auth/update").hasAuthority("ROLE_USER")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/auth/delete").hasAuthority("ROLE_USER")

                                /**
                                 * Admin User Section
                                 */
                                .requestMatchers(HttpMethod.GET, "/api/v1/admin/user/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/admin/user/update/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/admin/user/delete/**").hasRole("ADMIN")

                                /**
                                 * Product Section
                                 */
                                .requestMatchers(HttpMethod.GET, "/api/v1/product/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/v1/product/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/product/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/product/**").hasAuthority("ROLE_ADMIN")

                                /**
                                 * Order Section
                                 */
                                .requestMatchers(HttpMethod.GET, "/api/v1/order/myOrder/").authenticated()
                                .requestMatchers(HttpMethod.GET, "/api/v1/order/getAll").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/order/myOrder/id/**").authenticated()
                                .requestMatchers(HttpMethod.POST, "/api/v1/order/**").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/api/v1/order/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/order/**").hasAuthority("ROLE_ADMIN")

                                /**
                                 * Supplier Section
                                 */
                                .requestMatchers(HttpMethod.GET, "/api/v1/suppliers/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/v1/suppliers/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/suppliers/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/suppliers/**").hasAuthority("ROLE_ADMIN")

                                /**
                                 * Product Supplier Section
                                 */
                                .requestMatchers(HttpMethod.GET, "/api/v1/productSupplier/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/v1/productSupplier/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/productSupplier/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/productSupplier/**").hasAuthority("ROLE_ADMIN")

                                /**
                                 * Enquiry Section
                                 */
                                .requestMatchers(HttpMethod.GET, "/api/v1/enquiry/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/v1/enquiry/**").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/api/v1/enquiry/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/enquiry/**").hasAuthority("ROLE_ADMIN")

                                /**
                                 * User Enquiry Section
                                 */
                                .requestMatchers("/api/v1/user-enquiries/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/api/v1/order/myOrder/**").authenticated()

                                .anyRequest().authenticated()

                ).exceptionHandling(exception -> exception
                        .authenticationEntryPoint(authenticationEntryPoint)
                ).sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}