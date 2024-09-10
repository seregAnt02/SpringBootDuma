package duma.su.repository;

import duma.su.model.Dum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DumRepository extends JpaRepository<Dum, Long> {
}
