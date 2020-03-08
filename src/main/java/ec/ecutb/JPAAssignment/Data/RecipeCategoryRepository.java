package ec.ecutb.JPAAssignment.Data;

import ec.ecutb.JPAAssignment.Model.Entity.RecipeCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {
    Optional<RecipeCategory> findByCategory(String category);
}
