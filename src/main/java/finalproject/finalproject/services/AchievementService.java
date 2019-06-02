/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.Achievement;
import finalproject.finalproject.repositories.AchievementRepository;
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
