package duma.security;

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
                        "/js/**", "/images/**", "/favicon.ico");
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf().disable()
                .authorizeHttpRequests(register -> register
                        .requestMatchers("/home/index").hasAuthority("admin")
                        .requestMatchers("/home/vue").hasAuthority("admin")
                        .requestMatchers("/home/**").permitAll()
                        .requestMatchers("/parameter/**").hasAuthority("admin")
                        //.requestMatchers("/parameter/**").permitAll()
                        .requestMatchers("/account/**").hasAuthority("admin")
                        .requestMatchers("/account/**").hasAuthority("user")
                )
                .formLogin(Customizer.withDefaults())
                .build();


        /*return httpSecurity
                .authorizeHttpRequests(register -> register
                        .requestMatchers("/api/resource/admin/**").hasAuthority("admin")
                        .requestMatchers("/api/resource/user/**").hasAuthority("user")
                        //.requestMatchers("/user/admin/**").hasAuthority("admin")
                        .requestMatchers("/api/resource/auth/**").authenticated()
                        .requestMatchers("/api/resource").permitAll()
                        .requestMatchers("/user").permitAll()
                        .requestMatchers("/role").permitAll()
                        .anyRequest().denyAll()
                )
                .formLogin(Customizer.withDefaults())
                .build();*/
    }

    /*@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(source -> {
            Map<String, Object> resourceAccess = source.getClaim("resource_access");
            List<String> roles = (List<String>) resourceAccess.get("roles");
            return roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        });
        return httpSecurity
                .authorizeHttpRequests(register -> register
                        .requestMatchers("/api/resource/admin/**").hasAuthority("admin")
                        .requestMatchers("/api/resource/user/**").hasAuthority("user")
                        //.requestMatchers("/user/admin/**").hasAuthority("admin")
                        .requestMatchers("/api/resource/auth/**").authenticated()
                        .requestMatchers("/api/resource").permitAll()
                        .requestMatchers("/user").permitAll()
                        .requestMatchers("/role").permitAll()
                        .anyRequest().denyAll()
                )
                //.formLogin(Customizer.withDefaults())
                .oauth2ResourceServer(configurer ->
                        configurer.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(converter)) //Customizer.withDefaults()
                )
                .build();
    }*/

}
