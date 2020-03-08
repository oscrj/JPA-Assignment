package ec.ecutb.JPAAssignment.Service.Interface;

import ec.ecutb.JPAAssignment.Data.RecipeInstructionRepository;
import ec.ecutb.JPAAssignment.Model.Entity.RecipeInstruction;
import ec.ecutb.JPAAssignment.Service.Interfaces.InstructionCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
public class InstructionCreationTest {

    @Autowired
    private InstructionCreation testCreateInstruction;
    @Autowired
    private RecipeInstructionRepository instructionRepository;

    @Test
    public void check_if_instruction_is_saved_and_created(){
        RecipeInstruction result = testCreateInstruction.createAndSave("testInstruction");

        assertNotNull(result);
        assertEquals(result, instructionRepository.findByInstructions("testInstruction").get());
    }
}
