/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.Certification;
import finalproject.finalproject.repositories.CertificationRepository;
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
    
    public Iterable<Certification> findAllCertification(){
        return certificationRepository.findAll();
    }
}
