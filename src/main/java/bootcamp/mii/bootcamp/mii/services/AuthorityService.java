/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.services;

import bootcamp.mii.bootcamp.mii.entities.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bootcamp.mii.bootcamp.mii.repositories.AuthorityRepository;
import java.util.List;

/**
 *
 * @author ASUS
 */
@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository repository;

    public List<Authority> findAllRole() {
        return repository.findAuthority();
    }
}
