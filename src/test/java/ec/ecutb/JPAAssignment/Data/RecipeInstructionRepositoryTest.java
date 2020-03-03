package ec.ecutb.JPAAssignment.Data;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RecipeInstructionRepositoryTest {

    @Autowired
    private RecipeInstructionRepository instructionRepository;

    @BeforeEach
    void setUp(){

    }


}
