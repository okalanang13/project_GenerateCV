/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.repositories;

import bootcamp.mii.bootcamp.mii.entities.Certification;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface CertificationRepository extends CrudRepository<Certification, Integer>{
    @Query(value = "SELECT c.id, c.name, c.is_delete FROM certification c"
           + " WHERE c.is_delete = '0'"
           ,nativeQuery = true)
    List<Certification> findCertification();
}
