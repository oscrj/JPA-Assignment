package ec.ecutb.JPAAssignment.Service.Interface;

import ec.ecutb.JPAAssignment.Data.RecipeCategoryRepository;

import ec.ecutb.JPAAssignment.Model.Entity.RecipeCategory;
import ec.ecutb.JPAAssignment.Service.Interfaces.RecipeCategoryCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
public class RecipeCategoryCreationTest {

    @Autowired
    private RecipeCategoryCreation testCategoryCreation;

    @Autowired
    private RecipeCategoryRepository categoryRepository;

    @Test
    public void check_if_category_is_saved_and_created(){
        RecipeCategory result = testCategoryCreation.saveAndCreate("testCategory");

        assertNotNull(result);
        assertEquals(result, categoryRepository.findByCategory("testCategory").get());
    }
}
