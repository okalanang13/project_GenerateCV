/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.repositories;


import bootcamp.mii.bootcamp.mii.entities.Achievement;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 *
 * @author ASUS
 */
@Repository
public interface AchievementRepository extends CrudRepository<Achievement, Integer>{
    @Query(value = "SELECT a.`id`, a.`name`, a.`description`, a.`date_achiev`, a.`id_employee`,b.`first_name`, a.`is_delete` "
            + " FROM achievement a "
            + " join employee b "
            + " on a.`id_employee` = b.`id`"
            + " WHERE a.is_delete='0'",
            nativeQuery = true)
    List<Achievement> findAllAchiev();

}