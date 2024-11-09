package duma.model;

import lombok.Getter;
import lombok.Setter;

public class RegisterModel {
    @Setter
    @Getter
    public String Email;

    @Setter
    @Getter
    public int Year;

    @Setter
    @Getter
    public String Password;

    @Setter
    @Getter
    public String PasswordConfirm;
}
