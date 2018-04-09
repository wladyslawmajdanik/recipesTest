package schibsted.recipestest.repository.local;

import java.util.List;

import io.realm.Realm;
import schibsted.recipestest.model.recipes.Recipes;


public class LocalRepositoryImpl implements LocalRepository {

    private Realm realm;

    public LocalRepositoryImpl(Realm realm) {
        this.realm = realm;
    }


    private void getRealmInstance() {
        if (realm.isClosed()) {
            realm = Realm.getDefaultInstance();
        }
    }

    @Override
    public void saveRecipesToDB(List<Recipes> recipesList) {
        getRealmInstance();
        realm.executeTransaction(realm -> realm.insertOrUpdate(recipesList));
    }

    @Override
    public List<Recipes> getRecipesFromDB() {
        getRealmInstance();
        return realm.where(Recipes.class).findAll();
    }

}
