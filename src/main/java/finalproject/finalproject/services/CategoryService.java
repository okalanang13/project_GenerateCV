/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.finalproject.services;

import finalproject.finalproject.entities.Category;
import finalproject.finalproject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public Iterable<Category> findAllCategory(){
        return categoryRepository.findAll();
    }
}
