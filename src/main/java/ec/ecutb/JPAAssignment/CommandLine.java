package ec.ecutb.JPAAssignment;

import ec.ecutb.JPAAssignment.Model.Entity.Ingredient;
import ec.ecutb.JPAAssignment.Model.Entity.Recipe;
import ec.ecutb.JPAAssignment.Model.Entity.RecipeIngredient;
import ec.ecutb.JPAAssignment.Model.Measurement;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CommandLine implements CommandLineRunner {

    @Override
    @Transactional
    public void run(String... args) throws Exception {
       /* Recipe test
        RecipeIngredient testIngredients = new RecipeIngredient(new Ingredient("TestSalt"), 2.0, Measurement.KM);

        test.addRecipeIngredients(testIngredients);

        */
    }
}
