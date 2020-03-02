package ec.ecutb.JPAAssignment.Model.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;

    private List<RecipeIngredient> recipeIngredientList;

    private RecipeInstruction instruction;


    @ManyToMany //With recipeCategory.
    private List<RecipeCategory> recipeCategoryList;

    public Recipe(int recipeId, String recipeName, List<RecipeIngredient> recipeIngredientList, RecipeInstruction instruction, List<RecipeCategory> recipeCategoryList) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeIngredientList = recipeIngredientList;
        this.instruction = instruction;
        this.recipeCategoryList = recipeCategoryList;
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredientList, RecipeInstruction instruction, List<RecipeCategory> recipeCategoryList) {
        this(0, recipeName, null, null, null);
    }

    public Recipe() {}

    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredientList() {
        return recipeIngredientList;
    }

    public void setRecipeIngredientList(List<RecipeIngredient> recipeIngredientList) {
        this.recipeIngredientList = recipeIngredientList;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategory> getRecipeCategoryList() {
        return recipeCategoryList;
    }

    public void setRecipeCategoryList(List<RecipeCategory> recipeCategoryList) {
        this.recipeCategoryList = recipeCategoryList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipeId == recipe.recipeId &&
                Objects.equals(recipeName, recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Recipe{");
        sb.append("recipeId=").append(recipeId);
        sb.append(", recipeName='").append(recipeName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
