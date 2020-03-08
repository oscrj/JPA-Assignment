package ec.ecutb.JPAAssignment.Data;

import ec.ecutb.JPAAssignment.Model.Entity.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    private Ingredient testFlour;
    private Ingredient testSalt;
    private Ingredient testMilk;


    @BeforeEach
    void setUp(){
        testFlour = new Ingredient("testFlour");
        testSalt = new Ingredient("testSalt");
        testMilk = new Ingredient("testMilk");
        ingredientRepository.save(testFlour);
        ingredientRepository.save(testSalt);
        ingredientRepository.save(testMilk);
    }

    @Test
    public void find_ingredient_by_given_name(){
        Optional<Ingredient> result = ingredientRepository.findByIngredientNameIgnoreCase("testflour");

        assertTrue(result.isPresent());
        assertEquals(testFlour, result.get());
    }

    @Test
    public void find_ingredients_by_string_containing_part_of_name(){
        List<Ingredient> result = ingredientRepository.findByIngredientNameContainingIgnoreCase("st");

        assertNotNull(result);
        assertEquals(3, result.size());
    }

}
