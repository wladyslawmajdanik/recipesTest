package schibsted.recipestest.injection.components;


import dagger.Component;
import schibsted.recipestest.injection.modules.AppModule;
import schibsted.recipestest.injection.modules.ContextModule;
import schibsted.recipestest.injection.modules.NetworkModule;
import schibsted.recipestest.injection.modules.RealmModule;
import schibsted.recipestest.injection.scopes.AppScope;
import schibsted.recipestest.repository.local.LocalRepositoryImpl;
import schibsted.recipestest.ui.activities.recipedetails.RecipeDetailsActivity;
import schibsted.recipestest.ui.activities.recipeslist.RecipesListActivity;


@AppScope
@Component(modules = {AppModule.class, NetworkModule.class, RealmModule.class, ContextModule.class})
public interface AppComponent {


    void inject(LocalRepositoryImpl localRepository);

    void inject(RecipesListActivity recipesListActivity);

    void inject(RecipeDetailsActivity recipeDetailsActivity);
}
