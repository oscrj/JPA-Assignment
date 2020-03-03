package ec.ecutb.JPAAssignment.Data;

import ec.ecutb.JPAAssignment.Model.Entity.Recipe;
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

    private Recipe testTaco;
    private Recipe testHamburger;
    private Recipe testPizza;


    @BeforeEach
    void setUp(){
        testTaco = new Recipe("Taco",null,null,null);
        testHamburger = new Recipe("Hamburger",null,null,null);
        testPizza = new Recipe("Pizza",null,null,null);

        recipeRepository.save(testTaco);
        recipeRepository.save(testHamburger);
        recipeRepository.save(testPizza);
    }

    @Test
    public void find_ingredients_by_string_containing_part_of_name(){
        List<Recipe> result = recipeRepository.findByRecipeNameContainingIgnoreCase("burg");

        assertNotNull(result);
        assertEquals(1, result.size());
    }
}
