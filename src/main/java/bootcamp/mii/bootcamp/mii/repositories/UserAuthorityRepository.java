/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.repositories;

import bootcamp.mii.bootcamp.mii.entities.UsersAuthority;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface UserAuthorityRepository extends CrudRepository<UsersAuthority, String>{
    @Query(value = "select ua.id, ua.id_user, u.username, ua.id_authority, a.name, ua.is_delete"
            + " FROM users_authority ua "
            + " JOIN users u ON ua.id_user=u.id"
            + " JOIN authority a ON ua.id_authority=a.id"
             + " WHERE ua.is_delete='0'"
           ,nativeQuery = true)
    List<UsersAuthority> findUserAuthority();
}
