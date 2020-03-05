package ec.ecutb.JPAAssignment.Data;

import ec.ecutb.JPAAssignment.Model.Entity.*;
import ec.ecutb.JPAAssignment.Model.Measurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;

    private RecipeInstruction testInstruction;
    private Recipe testTaco;
    private Recipe testHamburger;
    private Recipe testPizza;

    @BeforeEach
    void setUp(){

        testInstruction = new RecipeInstruction("Put everything together");

        testTaco = new Recipe("Taco", null, null, null);
        testHamburger = new Recipe("Hamburger",null,null,null);
        testPizza = new Recipe("Pizza",null,null,null);

        testTaco.addRecipeIngredients(new RecipeIngredient(new Ingredient("Meat"), 0.5 ,Measurement.KG));
        testTaco.addRecipeIngredients(new RecipeIngredient(new Ingredient("Bread"), 4.0 ,Measurement.ST));
        testTaco.addRecipeIngredients(new RecipeIngredient(new Ingredient("Tomato"), 3.0 ,Measurement.ST));

        testTaco.setInstruction(testInstruction);
        testHamburger.setInstruction(testInstruction);
        testPizza.setInstruction(testInstruction);

        testTaco.addRecipeCategory(new RecipeCategory("Weekend"));
        testTaco.addRecipeCategory(new RecipeCategory("Mexican"));
        testTaco.addRecipeCategory(new RecipeCategory("FastFood"));

        testHamburger.addRecipeCategory(new RecipeCategory("American"));
        testHamburger.addRecipeCategory(new RecipeCategory("FastFood"));

        testPizza.addRecipeCategory(new RecipeCategory("Italian"));
        testPizza.addRecipeCategory(new RecipeCategory("FastFood"));

        recipeRepository.save(testTaco);
        recipeRepository.save(testHamburger);
        recipeRepository.save(testPizza);
    }

    @Test
    public void find_recipes_by_string_containing_part_of_name(){
        List<Recipe> result = recipeRepository.findByRecipeNameContainingIgnoreCase("burg");

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void find_recipe_by_ingredient_name(){
        List<Recipe> result = recipeRepository.findRecipeByIngredientNameIgnoreCase("Meat");

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void find_recipe_by_category(){
        List<Recipe> result = recipeRepository.findRecipeByCategory("Mexican");

        assertNotNull(result);
        assertEquals(1,result.size());
    }

    @Test
    public void find_recipe_by_categories(){
        List<Recipe> result = recipeRepository.findRecipeByCategories("Mexican", "American", "Italian");

        assertNotNull(result);
        assertEquals(3, result.size());
    }

}
