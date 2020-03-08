package ec.ecutb.JPAAssignment.Data;

import ec.ecutb.JPAAssignment.Model.Entity.Ingredient;
import ec.ecutb.JPAAssignment.Model.Entity.RecipeIngredient;
import ec.ecutb.JPAAssignment.Model.Measurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class RecipeIngredientRepositoryTest {

    @Autowired
    private RecipeIngredientRepository ingredientRepository;
    private RecipeIngredient testRecipeIngredient;
    private Ingredient testIngredient;

    @BeforeEach
    void setUp(){
        testIngredient = new Ingredient("Sugar");
        testRecipeIngredient = new RecipeIngredient(testIngredient, 2.0, Measurement.DL);
        ingredientRepository.save(testRecipeIngredient);
    }

    @Test
    public void find_by_ingredient(){
       Optional<RecipeIngredient> result = ingredientRepository.findByIngredient(testIngredient);

        assertNotNull(result.get());
        assertEquals(testIngredient, result.get().getIngredient());
    }
}
