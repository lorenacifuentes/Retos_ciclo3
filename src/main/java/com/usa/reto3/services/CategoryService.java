package com.usa.reto3.services;

import com.usa.reto3.model.Category;
import com.usa.reto3.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lorena
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRespository;
    
    public List<Category> getAll(){
        return categoryRespository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRespository.getCategory(id);
    }
    public Category saveCategory (Category category){
        if (category.getId()== null){
            return categoryRespository.save(category);
        }else{
            Optional<Category> CategoryNew= categoryRespository.getCategory(category.getId());
            if(!CategoryNew.isPresent()){
                return categoryRespository.save(category);
            } else{
                return category;
            }
        }
    }    
    public Category updateCategory (Category category){
    if(category.getId() != null){
        Optional<Category> CategoryActu= categoryRespository.getCategory(category.getId());
        if(CategoryActu.isPresent()){
            if(category.getName()!= null){
                CategoryActu.get().setName(category.getName());
            }
            if(category.getDescription()!=null){
                CategoryActu.get().setDescription(category.getDescription());
            }
            categoryRespository.save (CategoryActu.get());
            return CategoryActu.get();
        }else{
            return category;
            }
    }else{
        return category;
        }
    }   
    public boolean deleteCategory (int id){
        Optional<Category> CategoryBorr= getCategory(id);
        if(CategoryBorr.isPresent()){
           categoryRespository.delete(CategoryBorr.get()); 
           return true;
        }
        return false;
    } 
}
