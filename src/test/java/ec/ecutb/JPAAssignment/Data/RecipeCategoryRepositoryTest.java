package ec.ecutb.JPAAssignment.Data;

import ec.ecutb.JPAAssignment.Model.Entity.RecipeCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
public class RecipeCategoryRepositoryTest {

    @Autowired
    private RecipeCategoryRepository categoryRepository;
    private RecipeCategory testRecipeCategory;

    @BeforeEach
    void setUp(){
        testRecipeCategory = new RecipeCategory("Mexican");
        categoryRepository.save(testRecipeCategory);
    }

    @Test
    public void find_by_category(){
        RecipeCategory result = categoryRepository.findByCategory("Mexican");

        assertNotNull(result);
        assertEquals("Mexican", result.getCategory());
    }

}
