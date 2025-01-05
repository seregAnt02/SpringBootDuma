package duma.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(source -> {
            Map<String, Object> resourceAccess = source.getClaim("realm_access");
            List<String> roles = (List<String>) resourceAccess.get("roles");
            return roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        });

        return httpSecurity
                .csrf().disable()
                .authorizeHttpRequests(register -> register
                        .requestMatchers("/home/index").hasAuthority("admin")
                        .requestMatchers("/home/vue").hasAuthority("admin")
                        .requestMatchers("/home/**").permitAll()
                        .requestMatchers("/parameter/**").hasAuthority("admin")
                        .requestMatchers("/account/**").hasAuthority("admin")
                        .requestMatchers("/account/**").hasAuthority("user")
                )
                .formLogin()
                .defaultSuccessUrl("/home/index", true)
                .and()
                .oauth2ResourceServer(configurer ->
                        configurer.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(converter)) //Customizer.withDefaults()
                )
                .build();
    }

}
