package Data;

import ec.ecutb.JPAAssignment.Data.RecipeCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RecipeCategoryRepositoryTest {

    @Autowired
    private RecipeCategoryRepository categoryRepository;

    @BeforeEach
    void setUp(){

    }

}