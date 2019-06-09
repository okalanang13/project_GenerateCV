/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.repositories;

import finalproject.finalproject.entities.EmployeeLanguage;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RR17
 */
@Repository
public interface EmployeeLanguageRepository extends CrudRepository<EmployeeLanguage, Integer>{
    @Query(value = "select * from employee_language where is_delete = 'false'", nativeQuery = true)
    List<EmployeeLanguage> getAll();
}
