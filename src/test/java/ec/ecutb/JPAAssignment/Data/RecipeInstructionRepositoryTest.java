package ec.ecutb.JPAAssignment.Data;

import ec.ecutb.JPAAssignment.Model.Entity.RecipeInstruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class RecipeInstructionRepositoryTest {

    @Autowired
    private RecipeInstructionRepository instructionRepository;
    private RecipeInstruction testInstruction;

    @BeforeEach
    void setUp(){
        testInstruction = new RecipeInstruction("Do something");

        instructionRepository.save(testInstruction);
    }

    @Test
    public void find_by_instruction(){
        Optional<RecipeInstruction> result = instructionRepository.findByInstructions("Do something");

        assertNotNull(result.get());
        assertEquals("Do something", result.get().getInstructions());
    }


}
