package duma.model;

import lombok.Getter;
import lombok.Setter;

public class LoginModel {
    @Setter
    @Getter
    public String Email;

    @Setter
    @Getter
    public String Password;

    @Setter
    @Getter
    public String Captcha;
}
