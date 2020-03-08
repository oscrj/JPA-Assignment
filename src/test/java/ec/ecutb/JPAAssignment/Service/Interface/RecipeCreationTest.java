package ec.ecutb.JPAAssignment.Service.Interface;

import ec.ecutb.JPAAssignment.Data.RecipeCategoryRepository;
import ec.ecutb.JPAAssignment.Data.RecipeIngredientRepository;
import ec.ecutb.JPAAssignment.Data.RecipeInstructionRepository;
import ec.ecutb.JPAAssignment.Data.RecipeRepository;
import ec.ecutb.JPAAssignment.Model.Entity.*;
import ec.ecutb.JPAAssignment.Model.Measurement;
import ec.ecutb.JPAAssignment.Service.Interfaces.RecipeCreation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
public class RecipeCreationTest {

    @Autowired
    private RecipeCreation testRecipeCreation;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeCategoryRepository categoryRepository;
    @Autowired
    private RecipeInstructionRepository instructionRepository;
    @Autowired
    private RecipeIngredientRepository ingredientRepository;

    private RecipeIngredient ingredient;
    private RecipeInstruction instruction;
    private RecipeCategory category;
    private List<RecipeIngredient> ingredientList;
    private List<RecipeCategory> categoryList;

    @BeforeEach
    void setUp(){
        instruction = new RecipeInstruction("testInstruction");

        ingredient = new RecipeIngredient(new Ingredient("Sugar"), 2.0, Measurement.DL);
        ingredientRepository.save(ingredient);

        category = new RecipeCategory("Test");
        categoryRepository.save(category);

        instructionRepository.save(instruction);

        ingredientList.add(ingredient);
        categoryList.add(category);
    }

    /**
     *
    @Test
    public void check_if_recipe_is_saved_and_created(){
        Recipe result = testRecipeCreation.saveAndCreate("testName", ingredientList, instruction, categoryList);

        assertNotNull(result);
        assertEquals(recipeRepository.findByRecipeName("testName").get(), result);
    }
    */

}
