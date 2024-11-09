package duma.security;

import lombok.val;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {

    private BCryptPasswordEncoder encoder;
    public CustomPasswordEncoder(){
        encoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encode(CharSequence rawPassword) {
        //шифруем пороль
        String hashedPassword = encoder.encode(rawPassword);

        return hashedPassword;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);//rawPassword.equals(encodedPassword);
    }
}
