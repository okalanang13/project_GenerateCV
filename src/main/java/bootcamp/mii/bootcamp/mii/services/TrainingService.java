/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.services;

import bootcamp.mii.bootcamp.mii.entities.Training;
import bootcamp.mii.bootcamp.mii.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    public Iterable<Training> findAllTraining() {
        return trainingRepository.findAll();
    }
}
