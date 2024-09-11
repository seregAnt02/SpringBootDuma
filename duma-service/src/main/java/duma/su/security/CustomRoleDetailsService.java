package duma.su.security;

import duma.su.model.Role;
import duma.su.repository.RoleRepository;
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
