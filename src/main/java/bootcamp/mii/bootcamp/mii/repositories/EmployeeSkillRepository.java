/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.repositories;

import bootcamp.mii.bootcamp.mii.entities.EmployeeSkill;
import bootcamp.mii.bootcamp.mii.entities.Skill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface EmployeeSkillRepository extends CrudRepository<EmployeeSkill, Integer>{
    @Query(value = "SELECT es.id, es.rating, es.id_employee, e.first_name, es.id_skill, s.name, es.is_delete "
            + " FROM employee_skill es "
            + " JOIN employee e ON es.id_employee=e.id"
            + " JOIN skill s ON es.id_skill=s.id"
           + " WHERE es.is_delete = '0'"
           ,nativeQuery = true)
   List<EmployeeSkill> findEmployeeSkill();
}
