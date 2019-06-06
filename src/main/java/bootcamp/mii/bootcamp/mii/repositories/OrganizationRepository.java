/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.repositories;

import bootcamp.mii.bootcamp.mii.entities.Organization;
import bootcamp.mii.bootcamp.mii.entities.Skill;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Integer>{
    @Query(value = "SELECT o.id, o.name, o.position, o.start_date, o.end_date, o.id_employee, e.first_name, o.is_delete "
            + " FROM organization o "
            + " JOIN employee e ON o.id_employee=e.id"
           + " WHERE o.is_delete = '0'"
           ,nativeQuery = true)
   List<Organization> findOrganization();
}
