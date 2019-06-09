/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.repositories;

import bootcamp.mii.bootcamp.mii.entities.Users;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, String>{
    public Optional<Users> findByUsername(String username);
    @Query(value = "SELECT u.id, u.username, u.password, u.email, u.id_employee, e.first_name, u.is_delete "
            + " FROM users u"
            + " Join Employee e"
            + " on u.id_employee=e.id"
           + " WHERE u.is_delete = '0'"
           ,nativeQuery = true)
    List<Users> findUser();
    
    Users findByEmail(String email);
}
