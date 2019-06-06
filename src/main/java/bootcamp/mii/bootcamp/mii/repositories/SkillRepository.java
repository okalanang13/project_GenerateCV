/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.repositories;

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
public interface SkillRepository extends CrudRepository<Skill, Integer>{
   @Query(value = "SELECT s.id, s.name, s.id_category, c.name, s.is_delete FROM skill s JOIN category c ON s.id_category=c.id"
           + " WHERE s.is_delete = '0'"
           ,nativeQuery = true)
   List<Skill> findSkill();
   }


