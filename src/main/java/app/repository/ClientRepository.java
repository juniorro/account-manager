package app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.*;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
