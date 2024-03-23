package com.nerv.crm.config;

import com.nerv.crm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableMethodSecurity()
@Configuration
@AllArgsConstructor
public class WebSecurityConfig {
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    SecurityFilterChain securityFilterChain (final HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/img/**").permitAll()
                .requestMatchers("/js/**").permitAll()
                .requestMatchers("/errors/**").permitAll()
                .requestMatchers("/**").authenticated()
        );

//        http.exceptionHandling((exception)-> exception
//                .accessDeniedPage("/error/forbidden")
//        );


        http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        http.csrf(AbstractHttpConfigurer::disable);

        http.formLogin(form -> form
                .loginPage("/login")
                .permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                );

        http.logout(logout -> logout
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login?logout")
                .permitAll());
        return http.build();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }
}
