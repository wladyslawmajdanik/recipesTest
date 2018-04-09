package schibsted.recipestest.repository.remote;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import schibsted.recipestest.model.recipes.Recipes;

public interface RemoteRepository {


    @FormUrlEncoded
    @POST("getRecipesListDetailed")
    Observable<List<Recipes>> getRecipes(@Field("limit") int limit, @Field("from") int from);
//@Field("tags") String tags, @Field("size") String size,@Field("ratio") String ratio,

}
