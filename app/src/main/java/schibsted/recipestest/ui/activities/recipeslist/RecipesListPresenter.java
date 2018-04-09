package schibsted.recipestest.ui.activities.recipeslist;


import java.util.List;

import schibsted.recipestest.model.recipes.Recipes;

public interface RecipesListPresenter {

    void setView(RecipesListView view);

    void getRecipes();

    void saveRecipesToDB(List<Recipes> recipesList);

    List<Recipes> recipesFromDB();
}
