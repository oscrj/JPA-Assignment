package Data;

import ec.ecutb.JPAAssignment.Data.IngredientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    @BeforeEach
    void setUp(){

    }


}
