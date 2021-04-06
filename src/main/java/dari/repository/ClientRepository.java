package dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dari.entity.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
