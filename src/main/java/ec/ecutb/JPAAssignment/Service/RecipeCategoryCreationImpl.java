package ec.ecutb.JPAAssignment.Service;

import ec.ecutb.JPAAssignment.Data.RecipeCategoryRepository;
import ec.ecutb.JPAAssignment.Model.Entity.RecipeCategory;
import ec.ecutb.JPAAssignment.Service.Interfaces.RecipeCategoryCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeCategoryCreationImpl implements RecipeCategoryCreation {

    private RecipeCategoryRepository categoryRepository;

    @Autowired
    public RecipeCategoryCreationImpl(RecipeCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public RecipeCategory saveAndCreate(String category) {
        if(category.isEmpty()) throw new RuntimeException("You have to enter category");

        RecipeCategory recipeCategory = new RecipeCategory(category);
        categoryRepository.save(recipeCategory);
        return recipeCategory;
    }
}