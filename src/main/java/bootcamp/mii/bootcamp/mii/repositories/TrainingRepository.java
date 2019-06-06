/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.repositories;

import bootcamp.mii.bootcamp.mii.entities.Training;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface TrainingRepository extends CrudRepository<Training, Integer>{
    @Query(value = "SELECT t.id, t.name, t.is_delete FROM training t"
           + " WHERE t.is_delete = '0'"
           ,nativeQuery = true)
    List<Training> findTraining();
}
