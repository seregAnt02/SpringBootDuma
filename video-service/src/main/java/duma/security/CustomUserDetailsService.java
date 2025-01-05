package duma.security;


import main.java.duma.model.User;
import main.java.duma.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private static long sequence = 1L;
    private final UserRepository repository;

    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
        //addUser("admin", "pass", "admin");
        //addUser("user", "pass", "user");
        //addUser("auth", "pass", "auth");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                new main.java.duma.security.CustomPasswordEncoder().encode(user.getPassword()), List.of(new SimpleGrantedAuthority(user.getRole())
                /*new SimpleGrantedAuthority("admin"),
                new SimpleGrantedAuthority("user")*/
        ));
    }

}
