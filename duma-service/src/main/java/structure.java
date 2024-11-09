import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

/// Структура


/// server
public class structure {

    class HomeController{
        String index(){
            return "index";
        }

        String layOut(){return "layOut";}

    }

    class RestApiController{
        Parameter create(){return null;}
        Parameter edit(){return null;}
        Parameter delete(){return null;}
    }

    class AccountController{
        void registerUser(){}
        String registerUserPost(){return null;}
        String userAll(){return null;}
    }

    class UserDataController{
        void Audio(){}
        void Dash(){}
        void VideoDash(){} 
    }


    class RegisterModel
    {
        public String Email;

        public int Year;

        public String Password;

        public String PasswordConfirm;
    }
    class Parameter
    {
        public int id;

        public Date datetime;

        public String parameter;

        public String codparameter;

        public String lastupdate;

        public int meaning;

        public int DumId;// внешний ключь

        public Dum dum = new Dum();//навигационное свойство
    }
    class LoginModel
    {
        public String Email;

        public String Password;

        public String Captcha;
    }

    class Dum
    {
        public int id;

        public String guId;

        public Date datetime;

        public String macadress;

        public String ipadress;

        public int port;

        public String status;

        public int number;

        public String migration;

        public int age;
    }
    class Contact
    {
        public String Name;

        public String Telephone;

        public String EmailAdress;

        public String Wishes;
    }



    /// client


    // страница шаблона
    class layOut{

        // menu
        String company;
        String service;
        String price;
        String coordinate;
        String loginIn;


        // ссылка на выдвижную панель

        // ссылка на брендовку

        // контент
    }
}



