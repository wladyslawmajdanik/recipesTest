package schibsted.recipestest.injection.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import schibsted.recipestest.injection.scopes.AppScope;
import schibsted.recipestest.repository.local.LocalRepository;
import schibsted.recipestest.repository.local.LocalRepositoryImpl;
import schibsted.recipestest.repository.remote.RemoteRepository;
import schibsted.recipestest.ui.activities.recipedetails.RecipeDetailsPresenter;
import schibsted.recipestest.ui.activities.recipedetails.RecipeDetailsPresenterImpl;
import schibsted.recipestest.ui.activities.recipeslist.RecipesListPresenter;
import schibsted.recipestest.ui.activities.recipeslist.RecipesListPresenterImpl;
import schibsted.recipestest.utils.Constants;

@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application app) {
        mApplication = app;
    }

    @Provides
    @AppScope
    public LocalRepository provideLocalRepository(Realm realm) {
        return new LocalRepositoryImpl(realm);
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }


    @Provides
    public RecipesListPresenter recipesListPresenter(RemoteRepository remoteRepository, LocalRepository localRepository) {
        return new RecipesListPresenterImpl(remoteRepository, localRepository);
    }

    @Provides
    public RecipeDetailsPresenter recipeDetailsPresenter(RemoteRepository remoteRepository, LocalRepository localRepository) {
        return new RecipeDetailsPresenterImpl(remoteRepository, localRepository);
    }
}
