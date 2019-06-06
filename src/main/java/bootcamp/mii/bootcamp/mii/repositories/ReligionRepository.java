/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.repositories;

import bootcamp.mii.bootcamp.mii.entities.Religion;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface ReligionRepository extends CrudRepository<Religion, String>{
    @Query(value = "SELECT r.id, r.name, r.is_delete FROM religion r"
           + " WHERE r.is_delete = '0'"
           ,nativeQuery = true)
    List<Religion> findReligion();
}
