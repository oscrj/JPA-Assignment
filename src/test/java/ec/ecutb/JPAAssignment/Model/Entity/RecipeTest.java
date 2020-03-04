package ec.ecutb.JPAAssignment.Model.Entity;

import ec.ecutb.JPAAssignment.Model.Measurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class RecipeTest {

    private Recipe testObject;
    private RecipeIngredient testIngredients;
    private RecipeCategory testCategory;

    @BeforeEach
    void setUp(){
        testObject = new Recipe("TestRecipe", null, null, null);
        testIngredients = new RecipeIngredient(new Ingredient("TestSalt"), 2.0, Measurement.KM);
        testCategory = new RecipeCategory("Mexican");
    }


    @Test
    public void check_if_recipeIngredients_was_added(){
        boolean isAdded = testObject.addRecipeIngredients(testIngredients);
        assertTrue(isAdded);
    }

    @Test
    public void check_if_ingredient_equals_null_is_not_added(){
        testIngredients = null;
        boolean notAdded = testObject.addRecipeIngredients(testIngredients);
        assertFalse(notAdded);
    }

    @Test
    public void check_if_recipeIngredients_was_removed(){
        testObject.addRecipeIngredients(testIngredients);
        boolean isRemoved = testObject.removeRecipeIngredients(testIngredients);
        assertTrue(isRemoved);
    }

    @Test
    public void check_if_ingredients_equals_null_was_not_removed(){
        testIngredients = null;
        boolean notRemoved = testObject.removeRecipeIngredients(testIngredients);
        assertFalse(notRemoved);
    }

    @Test
    public void check_if_category_was_added(){
        boolean isAdded = testObject.addRecipeCategory(testCategory);
        assertTrue(isAdded);
    }

    @Test
    public void check_if_category_equals_null_was_not_added(){
        testCategory = null;
        boolean notAdded = testObject.addRecipeCategory(testCategory);
        assertFalse(notAdded);
    }

    @Test
    public void check_if_category_was_removed(){
        boolean isRemoved = testObject.removeRecipeCategory(testCategory);
        assertTrue(isRemoved);
    }

    @Test
    public void check_if_category_equals_null_not_removed(){
        testCategory = null;
        boolean notRemoved = testObject.removeRecipeCategory(testCategory);
        assertFalse(notRemoved);
    }
}
