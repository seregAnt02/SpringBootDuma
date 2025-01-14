package duma.services;

import duma.model.User;
import duma.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class StandartAccountService {
    private static long sequence = 1L;
    private UserRepository repository;

    public StandartAccountService(UserRepository repository) {
        this.repository = repository;
        //addUser("admin", "pass", "admin");
    }

    public List<User> getUserAll(){
        List<User> user = null;
            try {
                user = repository.findAll();
            }catch (NoSuchElementException ex){
                ex.getStackTrace();
            }
        return user;
    }


    public void registerUser(User user){
        if(user != null){
            try{
                this.addUser(user.getLogin(), user.getPassword(), user.getRole());
                log.info("Добавлен пользователь: " + user.getLogin());
            }catch (NoSuchElementException ex){
                ex.getStackTrace();
            }
        }
    }

    private void addUser(String login, String password, String role){
        User user = new User();
        user.setId(++sequence);
        user.setLogin(login);
        user.setRole(role);
        user.setPassword(password);
        repository.save(user);
        System.out.println("findByLogin " + repository.findByLogin(login));
    }
}
