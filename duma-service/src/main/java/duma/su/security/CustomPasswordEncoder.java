package duma.su.security;

import lombok.val;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        //шифруем пороль
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(rawPassword);

        return hashedPassword;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPassword, encodedPassword);//rawPassword.equals(encodedPassword);
    }
}
