/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.repositories;

import bootcamp.mii.bootcamp.mii.entities.EmployeeTraining;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface EmployeeTrainingRepository extends CrudRepository<EmployeeTraining, String>{
    @Query(value = "SELECT et.id, et.name, et.description, et.start_date, et.end_date, et.id_employee, e.first_name, et.id_training, t.name, et.is_delete"
            + " FROM employee_training et"
            + " JOIN employee e on et.id_employee = e.id"
            + " JOIN training t on et.id_training = t.id"
            + " WHERE et.is_delete = '0'",
            nativeQuery = true)
            
    List<EmployeeTraining> findAllEmployeeTraining();

}