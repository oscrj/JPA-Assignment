package ec.ecutb.JPAAssignment.Model.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            orphanRemoval = true,
            mappedBy = "recipe"
    )
    private List<RecipeIngredient> recipeIngredientList;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction instruction;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "category_recipe",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_category_id"))
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

    Recipe() {}

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
        //  If recipeIngredientList is empty, create an Arraylist.
        if(this.recipeIngredientList == null) recipeIngredientList = new ArrayList<>();

        if(recipeIngredientList != null){
            // Add recipe ingredients to List by calling addRecipeIngredients.
            recipeIngredientList.forEach(this::addRecipeIngredients);
        }else{
            // If recipeIngredientList is null, Set recipe to null in ingredients.
            recipeIngredientList.forEach(ingredient -> ingredient.setRecipe(null));
        }
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
        if(this.recipeCategoryList == null) this.recipeCategoryList = new ArrayList<>();
        if(recipeCategoryList == null){
            recipeCategoryList.forEach(recipeCategory -> recipeCategory.setRecipeList(null));
        }else{
            recipeCategoryList.forEach(this::addRecipeCategory);
        }
        this.recipeCategoryList = recipeCategoryList;
    }

    //  Adds recipe ingredients to recipe.
    public boolean addRecipeIngredients(RecipeIngredient ingredient){
        if(this.recipeIngredientList == null) recipeIngredientList = new ArrayList<>();
        if(ingredient == null) return false;
        if(recipeIngredientList.contains(ingredient)) return false;

        recipeIngredientList.add(ingredient);
        ingredient.setRecipe(this);
        return true;
    }

    // Remove recipe ingredients from recipe.
    public boolean removeRecipeIngredients(RecipeIngredient ingredient){
        if(this.recipeIngredientList == null) recipeIngredientList = new ArrayList<>();
        if(ingredient == null) return false;

        recipeIngredientList.remove(ingredient);
        ingredient.setRecipe(null);
        return true;
    }

    //  Add Category.
    public boolean addRecipeCategory(RecipeCategory category){
        if(this.recipeCategoryList == null) recipeCategoryList = new ArrayList<>();
        if(category == null) return false;

        recipeCategoryList.add(category);
        //category.setRecipeList(this);
        return true;
    }

    //  Remove Category.
    public boolean removeRecipeCategory(RecipeCategory category){
        if(this.recipeCategoryList == null) recipeCategoryList = new ArrayList<>();
        if(category == null) return false;

        recipeCategoryList.remove(category);
        //  category.setRecipeList(null);
        return true;
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
