/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.services;


import bootcamp.mii.bootcamp.mii.entities.Organization;
import bootcamp.mii.bootcamp.mii.repositories.OrganizationRepository;
import java.util.List;
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
    
    public List<Organization> findAllOrganization(){
        return organizationRepository.findOrganization();
    }
}
