package schibsted.recipestest.repository.remote;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import schibsted.recipestest.model.recipes.Recipes;

public interface RemoteRepository {


    @GET("getRecipesListDetailed?tags=&size=thumbnail-medium&ratio=1&limit=50&from=0")
    Observable<List<Recipes>> getRecipes();

}
