package ec.ecutb.JPAAssignment.Model.Entity;

import ec.ecutb.JPAAssignment.Model.Measurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class RecipeCategoryTest {

    private RecipeCategory testObject;
    private Recipe testRecipe;
    private List<RecipeIngredient> testIngredientList;
    private RecipeInstruction testInstruction;
    private List<RecipeCategory> testCategoryList;

    @BeforeEach
    void setup(){
        testObject = new RecipeCategory(null);
        testIngredientList = Arrays.asList(
                new RecipeIngredient(new Ingredient("Salt") , 2.0, Measurement.KM),
                new RecipeIngredient(new Ingredient("Sugar"), 5.0, Measurement.DL)
        );
        testInstruction = new RecipeInstruction("Put everything in a bowl");
        testCategoryList = Arrays.asList(
                new RecipeCategory("Weekend"),
                new RecipeCategory("Cookie"));

        testRecipe = new Recipe("Grandmas secret Cookie dough", testIngredientList, testInstruction, testCategoryList);
    }

    @Test
    public void check_if_recipe_is_added(){
        boolean isAdded = testObject.addRecipe(testRecipe);
        assertTrue(isAdded);
    }

    @Test
    public void check_if_recipe_equals_null_is_not_added(){
        testRecipe = null;
        boolean isNotAdded = testObject.addRecipe(testRecipe);
        assertFalse(isNotAdded);
    }

    @Test
    public void check_if_recipe_is_removed(){
        testObject.addRecipe(testRecipe);
        boolean isRemoved = testObject.removeRecipe(testRecipe);
        assertTrue(isRemoved);
    }

    @Test
    public void check_if_recipe_equals_null_not_removed(){
        testRecipe = null;
        boolean isNotRemoved = testObject.removeRecipe(testRecipe);
    }

}
