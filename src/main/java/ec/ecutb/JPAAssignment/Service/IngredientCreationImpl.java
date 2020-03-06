package ec.ecutb.JPAAssignment.Service;

import ec.ecutb.JPAAssignment.Data.IngredientRepository;
import ec.ecutb.JPAAssignment.Model.Entity.Ingredient;
import ec.ecutb.JPAAssignment.Service.Interfaces.IngredientCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientCreationImpl implements IngredientCreation {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientCreationImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient createAndSave(String ingredientName) {
        if(ingredientName == null){
            throw new RuntimeException("You have to enter an ingredient");
        }

        if(ingredientRepository.findByIngredientNameIgnoreCase(ingredientName).getIngredientName().equals(ingredientName)){
            throw new RuntimeException("This ingredient already exist");
        }

        Ingredient ingredient = new Ingredient(ingredientName);
        return ingredientRepository.save(ingredient);
    }
}
