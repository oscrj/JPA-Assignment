package ec.ecutb.JPAAssignment.Service.Interfaces;

import ec.ecutb.JPAAssignment.Model.Entity.RecipeInstruction;
import org.springframework.transaction.annotation.Transactional;

public interface InstructionCreation {

    @Transactional(rollbackFor = RuntimeException.class)
    RecipeInstruction createAndSave(String instructions);
}
