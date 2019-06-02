/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.Skill;
import finalproject.finalproject.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;
    
    public Iterable<Skill> findAllSkill(){
        return skillRepository.findAll();
    }
}
