/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.repositories;

import finalproject.finalproject.entities.EmployeeEducation;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RR17
 */
@Repository
public interface EmployeeEducationRepository extends CrudRepository<EmployeeEducation, Integer>{
    @Query(value = "select * from employee_education where is_delete = 'false'", nativeQuery = true)
    List<EmployeeEducation> getAll();
}
