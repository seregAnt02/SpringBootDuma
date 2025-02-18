import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

/// Структура
/*
*  Сервис представляет из себя микросервисную веб-архитектуру, имеющий простой базовый пользовательский
*   интерфейс, который имеет таблицу и значения. Функционал предпологает CRUID - запросы
*   прикладного уровня, которые коммуницируют с транспорным уровнем по протоколу TCP/IP, UDP на локальные сервера.
*   Локальный сервер(клиент) принимает пакеты данных запросов и отправляет в сеть modbus RTU в виде PDU-пакетов к
*   подчиненным устройствам, согласно  CRUID запросам и возвратом ввиде ответа в стек верхнего уровня с последующим
*   сохранением в базе данных.
*   1. Создать функционал CRUID - операций с полным циклом запроса.
*   2. Создать функционал с слобозвязанными связями с базой данных виде интерфеса предоставляющего абстракцию.
    3. Интегрировать библиотеку Keycloak для управления идентификацией и доступом к сервису.
    4. На фронтене интегрировать прогрессивный JavaScript-фреймворк Vue.js, Bootstrap HTML, CSS и JS-фреймворк,
        который используется для быстрой верстки адаптивных дизайнов сайтов и веб-приложений.
    5.
    5. Развернуть сервисы в Docker контейнере, для совместного запуска сервисов в изолированной среде.
    *
*
* */


/// server
public class structure {


    class HomeController{

        String index(){
            return "index";
        }


        String getLayOut(){return "layOut";}


        String getCoordinate(){return "coordinate";}


        String getCompanyPage(){return "company";}


        String getServicesPage(){return "service";}


        String startPage(){return "start-page";}


        String getPrice(){return "price";}


        String getFormParameter(){return "parameter";}
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

        // контент на ссылки из меню
    }


}



