package main.java.duma.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/resources/**", "/static/**", "/css/**",
                        "/js/**", "/images/**", "/favicon.ico", "/video/**");
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf().disable()
                .authorizeHttpRequests(register -> register
                        /*.requestMatchers("/home/index").hasAuthority("admin")
                        .requestMatchers("/home/vue").hasAuthority("admin")
                        .requestMatchers("/home/**").permitAll()
                        .requestMatchers("/parameter/**").hasAuthority("admin")
                        .requestMatchers("/account/**").hasAuthority("admin")
                        .requestMatchers("/account/**").hasAuthority("user")*/
                        .requestMatchers("/player/**").permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
