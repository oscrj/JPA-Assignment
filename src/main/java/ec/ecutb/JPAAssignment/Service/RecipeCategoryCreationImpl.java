package ec.ecutb.JPAAssignment.Service;

import ec.ecutb.JPAAssignment.Data.RecipeCategoryRepository;
import ec.ecutb.JPAAssignment.Model.Entity.RecipeCategory;
import ec.ecutb.JPAAssignment.Service.Interfaces.RecipeCategoryCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeCategoryCreationImpl implements RecipeCategoryCreation {

    private RecipeCategoryRepository categoryRepository;

    @Autowired
    public RecipeCategoryCreationImpl(RecipeCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeCategory saveAndCreate(String category) {
        if(category.isEmpty()) throw new RuntimeException("You have to enter category");

        if(categoryRepository.findByCategory(category).isPresent()){
            throw new RuntimeException("This category already exists");
        }

        RecipeCategory recipeCategory = new RecipeCategory(category);
        return categoryRepository.save(recipeCategory);
    }
}
