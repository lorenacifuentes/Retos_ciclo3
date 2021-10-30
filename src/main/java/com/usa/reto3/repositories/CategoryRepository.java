package com.usa.reto3.repositories;

import com.usa.reto3.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lorena
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categorycrudrepository;
    
    public List<Category> getAll(){
        return (List<Category>) categorycrudrepository.findAll();
    }
    
    public Optional<Category> getCategory (int id){
        return categorycrudrepository.findById(id);
    }
    public Category save (Category category){
        return categorycrudrepository.save(category); 
    }
    public void delete (Category category){
        categorycrudrepository.delete(category);
    }
}
