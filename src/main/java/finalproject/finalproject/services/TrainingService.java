/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.Training;
import finalproject.finalproject.repositories.TrainingRepository;
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
