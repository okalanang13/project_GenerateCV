/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.Organization;
import finalproject.finalproject.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;
    
    public Iterable<Organization> findAllOrganization(){
        return organizationRepository.findAll();
    }
}
