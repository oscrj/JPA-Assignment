package ec.ecutb.JPAAssignment.Service.Interface;

import ec.ecutb.JPAAssignment.Data.IngredientRepository;
import ec.ecutb.JPAAssignment.Model.Entity.Ingredient;

import ec.ecutb.JPAAssignment.Service.Interfaces.IngredientCreation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class IngredientCreationTest {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private IngredientCreation testObject;
    private String testIngredientName;

    @BeforeEach
    void setUp(){
        testIngredientName = "test";
    }

    /*
    @Test
    public void check_if_ingredient_is_saved_and_created(){
        Ingredient result = testObject.createAndSave(testIngredientName);

        assertEquals(result, ingredientRepository.findByIngredientNameIgnoreCase(testIngredientName));
    }

     */
}
