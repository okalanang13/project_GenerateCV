/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.Language;
import finalproject.finalproject.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RR17
 */
@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageImplement;
    
    public Iterable<Language> getAllLanguage(){
        return languageImplement.getAll();
    }
}
