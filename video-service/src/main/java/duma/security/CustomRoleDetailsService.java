package main.java.duma.security;

import main.java.duma.model.Role;
import main.java.duma.repository.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomRoleDetailsService {
    private static long sequence = 1L;
    private final RoleRepository repository;

    public CustomRoleDetailsService(RoleRepository repository) {
        this.repository = repository;
        addRole("admin");
        addRole("user");
        addRole("auth");
    }

    private void addRole(String nameRole){
        Role role = new Role();
        role.setId(sequence++);
        role.setName(nameRole);
        repository.save(role);
    }

}
