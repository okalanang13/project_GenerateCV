/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.services;

import bootcamp.mii.bootcamp.mii.entities.UserAuthority;
import bootcamp.mii.bootcamp.mii.repositories.UserAuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class UserAuthorityService {
    @Autowired
    private UserAuthorityRepository user;
    
    public Iterable<UserAuthority> findAllUserAuthority(){
        return user.findAll();
    }
}
