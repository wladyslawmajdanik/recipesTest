package schibsted.recipestest.repository.local;

import java.util.List;

import schibsted.recipestest.model.recipes.Recipes;


public interface LocalRepository {
    List<Recipes> getRecipesFromDB();

    void saveRecipesToDB(List<Recipes> recipesList);

}
