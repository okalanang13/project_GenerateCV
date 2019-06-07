/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.services;

import bootcamp.mii.bootcamp.mii.entities.Users;
import bootcamp.mii.bootcamp.mii.repositories.UsersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class UsersService {
    @Autowired
    private UsersRepository u;
    
    public List<Users> findAllUsers(){
        return u.findUser();
    }
}
