/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.services;

import bootcamp.mii.bootcamp.mii.entities.Certification;
import bootcamp.mii.bootcamp.mii.repositories.CertificationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class CertificationService {
    @Autowired
    private CertificationRepository certificationRepository;
    
    public List<Certification> findAllCertification(){
        return certificationRepository.findCertification();
    }
}
