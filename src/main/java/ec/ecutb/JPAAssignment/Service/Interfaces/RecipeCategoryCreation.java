package ec.ecutb.JPAAssignment.Service.Interfaces;

import ec.ecutb.JPAAssignment.Model.Entity.RecipeCategory;
import org.springframework.transaction.annotation.Transactional;

public interface RecipeCategoryCreation {

    @Transactional(rollbackFor = RuntimeException.class)
    RecipeCategory saveAndCreate(String category);
}
