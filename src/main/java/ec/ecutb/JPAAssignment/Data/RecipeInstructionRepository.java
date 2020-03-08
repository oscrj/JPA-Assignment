package ec.ecutb.JPAAssignment.Data;

import ec.ecutb.JPAAssignment.Model.Entity.RecipeInstruction;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, String> {
    Optional<RecipeInstruction> findByInstructions(String instruction);
}
