package ec.ecutb.JPAAssignment.Data;

import ec.ecutb.JPAAssignment.Data.RecipeIngredientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RecipeIngredientRepositoryTest {

    @Autowired
    private RecipeIngredientRepository ingredientRepository;

    @BeforeEach
    void setUp(){

    }
}
