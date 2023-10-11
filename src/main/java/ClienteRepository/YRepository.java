package ClienteRepository;


import ClienteEntity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YRepository extends JpaRepository<Cliente, Long> {
}
