package bootcamp.mii.bootcamp.mii.repositories;

import bootcamp.mii.bootcamp.mii.entities.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
    public Optional<User> findByUsername(String username);
}