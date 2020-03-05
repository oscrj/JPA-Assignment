package ec.ecutb.JPAAssignment.Service;

import ec.ecutb.JPAAssignment.Data.RecipeInstructionRepository;
import ec.ecutb.JPAAssignment.Model.Entity.RecipeInstruction;
import ec.ecutb.JPAAssignment.Service.Interfaces.InstructionCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructionCreationImpl implements InstructionCreation {

    private RecipeInstructionRepository instructionRepository;

    @Autowired
    public InstructionCreationImpl(RecipeInstructionRepository instructionRepository) {
        this.instructionRepository = instructionRepository;
    }

    @Override
    public RecipeInstruction createAndSave(String instructions) {
        if(instructions.isEmpty()){
            throw new RuntimeException("You have to enter a instruction");
        }

        RecipeInstruction instruction = new RecipeInstruction(instructions);
        return instructionRepository.save(instruction);
    }
}
