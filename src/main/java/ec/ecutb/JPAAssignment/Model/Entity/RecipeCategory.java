package ec.ecutb.JPAAssignment.Model.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeCategoryId;
    private String category;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "category_recipe",
            joinColumns = @JoinColumn(name = "recipe_category_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    List<Recipe> recipeList;

    public RecipeCategory(int recipeCategoryId, String category, List<Recipe> recipeList) {
        this.recipeCategoryId = recipeCategoryId;
        this.category = category;
        this.recipeList = recipeList;
    }

    public RecipeCategory(String category) {
        this(0, category, null);
    }

    RecipeCategory() {}

    public int getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        if(this.recipeList == null) this.recipeList = new ArrayList<>();
        if(recipeList == null){
            recipeList.forEach(recipe -> recipe.setRecipeCategoryList(null));
        }else {
            recipeList.forEach(this::addRecipe);
        }
        this.recipeList = recipeList;
    }

    public boolean addRecipe(Recipe recipe){
        if(recipeList == null) recipeList = new ArrayList<>();
        if(recipe == null) return false;

        recipeList.add(recipe);
        // recipe.setRecipeCategoryList(recipe);
        return true;
    }

    public boolean removeRecipe(Recipe recipe){
        if(this.recipeList == null) recipeList = new ArrayList<>();
        if(recipe == null) return false;

        recipeList.remove(recipe);
        recipe.setRecipeCategoryList(null);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return recipeCategoryId == that.recipeCategoryId &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeCategoryId, category);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RecipeCategory{");
        sb.append("recipeCategoryId=").append(recipeCategoryId);
        sb.append(", category='").append(category).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
