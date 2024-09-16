import duma.su.model.Parameter;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

public class structure {

    class HomeController{
        String index(){
            return "index";
        }
    }

    class RestApiController{
        Parameter create(){return null;}
        Parameter edit(){return null;}
        Parameter delete(){return null;}
    }
    class AccountController{
        void register(){}
        void getLogin(){}
    }

    class UserDataController{
        void Audio(){}
        void Dash(){}
        void VideoDash(){}
    }

    class StandartParameterService{
        Parameter createParameter(){return null;}
        List<Parameter> getAllParameter(){return null; }
    }
    class RegisterModel
    {
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
    class Parameter
    {
        @Setter
        @Getter
        public int id;

        @Setter
        @Getter
        public Date datetime;

        @Setter
        @Getter
        public String parameter;

        @Setter
        @Getter
        public String codparameter;

        @Setter
        @Getter
        public String lastupdate;

        @Setter
        @Getter
        public int meaning;

        @Setter
        @Getter
        public int DumId;// внешний ключь
        public Dum dum = new Dum();//навигационное свойство
    }
    class LoginModel
    {
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
    class Dum
    {
        @Setter
        @Getter
        public int id;

        @Setter
        @Getter
        public String guId;


        @Setter
        @Getter
        public Date datetime;

        @Setter
        @Getter
        public String macadress;

        @Setter
        @Getter
        public String ipadress;

        @Setter
        @Getter
        public int port;

        @Setter
        @Getter
        public String status;

        @Setter
        @Getter
        public int number;

        @Setter
        @Getter
        public String migration;

        @Setter
        @Getter
        public int age;
    }
    class Contact
    {
        @Setter
        @Getter
        public String Name;

        @Setter
        @Getter
        public String Telephone;

        @Setter
        @Getter
        public String EmailAdress;

        @Setter
        @Getter
        public String Wishes;
    }
}



