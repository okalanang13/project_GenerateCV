/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.repositories;

import bootcamp.mii.bootcamp.mii.entities.EmployeeCertification;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface EmployeeCertificationRepository extends CrudRepository<EmployeeCertification, Integer>{
    @Query(value = "SELECT ec.id, ec.name, ec.description, ec.start_date, ec.end_date, ec.id_employee, e.first_name, ec.id_certification, c.name, ec.is_delete"
            + " FROM employee_certification ec"
            + " JOIN employee e on ec.id_employee = e.id"
            + " JOIN certification c on ec.id_certification = c.id"
            + " WHERE ec.is_delete = '0'",
            nativeQuery = true)
            
    List<EmployeeCertification> findAllEmployeeCertification();
}
