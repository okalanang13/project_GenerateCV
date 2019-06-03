/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.services;


import bootcamp.mii.bootcamp.mii.entities.Achievement;
import bootcamp.mii.bootcamp.mii.repositories.AchievementRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class AchievementService {
    @Autowired
    private AchievementRepository achievementRepository;
    
    public Iterable<Achievement> findAllAchievement(){
        return achievementRepository.findAll();
    }
    
    
}
