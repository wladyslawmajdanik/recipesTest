package schibsted.recipestest.ui.activities.recipedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import schibsted.recipestest.R;
import schibsted.recipestest.RecipesApplication;
import schibsted.recipestest.model.recipes.Ingredient;
import schibsted.recipestest.model.recipes.Recipes;
import schibsted.recipestest.ui.activities.base.BaseActivity;
import schibsted.recipestest.ui.activities.recipedetails.adapter.IngredientAdapter;

import static schibsted.recipestest.utils.Constants.RECIPES_DATA;


public class RecipeDetailsActivity extends BaseActivity implements RecipeDetailsView {
    @Inject
    public RecipeDetailsPresenter productsListPresenter;

    Recipes recipes;

    @BindView(R.id.recipe_name)
    TextView recipeName;
    @BindView(R.id.recipe_description)
    TextView recipeDescription;
    @BindView(R.id.recipe_image)
    ImageView restaurantImage;
    @BindView(R.id.ingridients_list_recycler)
    RecyclerView ingrediensRecycler;
    @BindView(R.id.recipe_list_cointainer)
    RelativeLayout productsListCointainer;
    @BindView(R.id.order_button_cointainer)
    RelativeLayout orderButtonCointainer;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        ButterKnife.bind(this);
        ((RecipesApplication) getApplication()).getComponent().inject(this);
        productsListPresenter.setView(this);
        recipes = getIntent().getParcelableExtra(RECIPES_DATA);

        initView();
        setIngredientsListAdapter(recipes.getIngredients());

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideWaitDialog();
    }


    private void initView() {
        recipeName.setText(recipes.getTitle());
        recipeDescription.setText(Html.fromHtml(recipes.getDescription()));
        try {
            Glide.with(this)
                    .load(recipes.getImages().get(0).getUrl())
                    .into(restaurantImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setIngredientsListAdapter(List<Ingredient> ingredientList) {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ingrediensRecycler.setLayoutManager(layoutManager);
        IngredientAdapter ingredientAdapter = new IngredientAdapter(this, ingredientList);
        ingrediensRecycler.setAdapter(ingredientAdapter);
    }

}
