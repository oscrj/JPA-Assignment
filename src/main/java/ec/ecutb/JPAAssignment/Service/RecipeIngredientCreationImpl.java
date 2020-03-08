package ec.ecutb.JPAAssignment.Service;

import ec.ecutb.JPAAssignment.Data.RecipeIngredientRepository;
import ec.ecutb.JPAAssignment.Model.Entity.Ingredient;

import ec.ecutb.JPAAssignment.Model.Entity.RecipeIngredient;
import ec.ecutb.JPAAssignment.Model.Measurement;
import ec.ecutb.JPAAssignment.Service.Interfaces.RecipeIngredientCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Objects;

public class RecipeIngredientCreationImpl implements RecipeIngredientCreation {

    private RecipeIngredientRepository ingredientRepository;

    @Autowired
    public RecipeIngredientCreationImpl(RecipeIngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeIngredient createAndSave(Ingredient ingredient, Double amount, Measurement measurement) {
        if(hasNull(ingredient, amount, measurement)){
            throw new RuntimeException("One or many parameters is null");
        }

        if(ingredientRepository.findByIngredient(ingredient).isPresent()) {
            throw new RuntimeException("This ingredient already exists");
        }

        RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient, amount, measurement);
        return ingredientRepository.save(recipeIngredient);
    }

    public static boolean hasNull(Object...objects){
        return Arrays.stream(objects)
                .anyMatch(o -> Objects.isNull(o));
    }
}
