/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3.repositories;

import com.usa.reto3.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Lorena
 */
public interface CategoryCrudRepository extends CrudRepository<Category,Integer>{
    
}
