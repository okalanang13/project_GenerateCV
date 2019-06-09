/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.WorkAssignment;
import finalproject.finalproject.repositories.WorkAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RR17
 */
@Service
public class WorkAssignmentService {
    @Autowired
    private WorkAssignmentRepository workAssImplement;
    
    public Iterable<WorkAssignment> getAllWorkAss(){
        return workAssImplement.getAll();
    }
}
