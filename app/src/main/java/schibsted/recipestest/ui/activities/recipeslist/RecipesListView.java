package schibsted.recipestest.ui.activities.recipeslist;


import java.util.List;

import schibsted.recipestest.model.recipes.Recipes;
import schibsted.recipestest.ui.View;


public interface RecipesListView extends View {
    void onSuccessDownloadRecipesList(List<Recipes> recipesList);

    void onErrorDownloadRecipesList();
}
