import duma.model.Parameter;
import duma.model.Role;
import duma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/// Структура
/*
*  Сервис представляет из себя микросервисную веб-архитектуру, имеющий простой базовый пользовательский
*   интерфейс, который имеет таблицу и значения. Функционал предпологает CRUID - запросы
*   прикладного уровня, которые коммуницируют с транспорным уровнем по протоколу TCP/IP, UDP на локальные сервера.
*   Локальный сервер(клиент) принимает пакеты данных запросов и отправляет в сеть modbus RTU в виде PDU-пакетов к
*   подчиненным устройствам, согласно  CRUID запросам и возвратом ввиде ответа в стек верхнего уровня с последующим
*   сохранением в базе данных.
*   1. Разработать функционал CRUID - операций с полным циклом запроса.
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


        public String nameParameter;


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


    /*
    Создать репозиторий к базе данных в виде интерфейса ParameterRepository,
    который наследуется от JpaRepository<Parameter, Long> с параметрами типа
    Parameter и Long, для запросов к базе данных с объектами типа Parameter.
    */
    public interface ParameterRepository extends JpaRepository<Parameter, Long> {
    }


    /*
    Создать репозиторий к базе данных в виде интерфейса RoleRepository,
    который наследуется от JpaRepository<Role, Long> с параметрами типа
    Role и Long, для роли логина при аутентификаций к сервису.
    */
    public interface RoleRepository extends JpaRepository<Role, Long> {
    }


    /*
    Создать репозиторий к базе данных в виде интерфейса UserRepository,
    который наследуется от JpaRepository<User, Long> с параметрами типа
    User и Long, для логина при аутентификаций к сервису.
    */
    public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByLogin(String login);
    }


    class StandartParameterService{

        /*
            Создать объект типа StandartParameterService.

            Создать фунцию getParameterById(long id), для поиска по идентификатору в базе данных
                объекта типа Parameter.

            Создать функцию добавления в базу новых данных типа Parameter:
              * В StandartParameterService создаем метод add(), для добавления данных,
                с входящим аргументом типа String nameParameter.
              * Добавляем в метод новый объект Parameter с присвоенем свойства nameParameter,
                с входящим аргументом метода.
              * Сохраняем в базе данных текущий объект Parameter.

            Создать функцию редактирования в базе данных типа Parameter:
              * Добавить в объект типа StandartParameterService метод edit(), для редактирования данных,
                с входящим аргументом типа Parameter.
              * Добавляем в метод новый объект Parameter с присвоенем свойств входящего аргумента метода.
              * Сохраняем в базе данных объект типа Parameter.

            Создать функцию удаления из базы данных типа Parameter:
               * С помощью функций getParameterById(long id), находим необходимый объект в базе данных и
                с помощью репозитория ParameterRepository, удаляем из базе данных соответсвующий объект
                типа Parameter.
            */

        Parameter getParameterById(long id){ return null; }


        RedirectView add(){return new RedirectView("/home/index");}


        Parameter edit(){return null;}


        Parameter delete(){return null;}
    }


    class StandartAccountService{
        /*
            Создать объект типа StandartAccountService.

            Создать функцию void addUser(String login, String password, String role),
              для добаления нового пользователя и входящими аргументами, в базу данных
               с помощью репозитория  типа UserRepository.

            Создать функцию registerUser(User user), для регистраций нового пользователя,
              с помощью функций addUser(String login, String password, String role).

            Создать фунцию getUserAll() с возвращаемся списком всех пользователей.
        */


        void addUser(String login, String password, String role){}


        void registerUser(User user){}


        List<User> getUserAll(){return null; }
    }

    class HomeController{

        /*
            1. Страница пользователя метода index(), имеет простой интерфейс таблицу и значения.
                * Строки таблицы должны добавляться, редактироваться и удаляться.
                * Страница на фронтене обязана быть адаптивной.


            2. Станица шаблон с именем getLayOut(), которая имеет некий шаблон,
                представляющие из себя выдвижную панель, в которой имеются ссылки на меню сервиса:
                * компаний
                * услуги
                * цена
                * контакты
               Кнопка для выдвижения панели.
               Логотип бренда.
               Заголовок страницы под названием автоматизированные системы управления.
               Подвал страницы с контентом внутри "приложение Java MVC".

            3. Страница метода getCoordinate(), возвращает контент координат компаний.
            4. Страница метода getCompanyPage(), возвращает контент професиональной деятельности
                компаний.
            5. Страница метода getServicesPage(), возвращает контент направления деятельности и
                применения форматов и подходов.
            6. Страница метода startPage(), возвращает контент направления деятельности по
                разработке програмного обеспечения и разных подходов их реализаций.
            7. Страница метода getPrice, getServerAdministration, getDevelopment служит для
                навигаций перехода по страницам к направлению деятельности.
        */

        String index(){
            return "index";
        }


        String getLayOut(){return "layOut";}


        String getCoordinate(){return "coordinate";}


        String getCompanyPage(){return "company";}


        String getServicesPage(){return "service";}


        String startPage(){return "start-page";}


        String getPrice(){return "price";}


        String getServerAdministration(){return "serverAdministration";}


        String getDevelopment(){ return "homePages/development"; }
    }


    class AccountController{

        /*
           1. Ручка userAll(), служит для просмотра списка пользователей и
                с помощью объекта StandartAccountService вызываем функцию getUserAll(),
                который заполняет массив типа List<User> пользователями.
           2. Ручка addUser(), служит для добавления пользователей в базу данных.
        */

        String userAll(){return null;}


        String addUser(@RequestBody User user){return null;}
    }

    class UserDataController{

        /*

        */


        void Audio(){}


        void Dash(){}


        void VideoDash(){} 
    }


}



