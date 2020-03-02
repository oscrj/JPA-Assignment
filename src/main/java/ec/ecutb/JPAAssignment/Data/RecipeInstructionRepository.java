package ec.ecutb.JPAAssignment.Data;

import ec.ecutb.JPAAssignment.Model.Entity.RecipeInstruction;
import org.springframework.data.repository.CrudRepository;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, String> {

}
