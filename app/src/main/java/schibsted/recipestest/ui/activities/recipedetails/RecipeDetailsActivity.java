package schibsted.recipestest.ui.activities.recipedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import schibsted.recipestest.R;
import schibsted.recipestest.RecipesApplication;
import schibsted.recipestest.model.recipes.Recipes;
import schibsted.recipestest.ui.activities.base.BaseActivity;

import static schibsted.recipestest.utils.Constants.RECIPES_DATA;


public class RecipeDetailsActivity extends BaseActivity implements RecipeDetailsView {
    @Inject
    public RecipeDetailsPresenter productsListPresenter;

    Recipes recipes;

    @BindView(R.id.restaurant_name)
    TextView restaurantName;
    @BindView(R.id.restaurant_image)
    ImageView restaurantImage;
    @BindView(R.id.products_list_cointainer)
    RelativeLayout productsListCointainer;
    @BindView(R.id.order_button_cointainer)
    RelativeLayout orderButtonCointainer;
    @BindView(R.id.products_list_recycler)
    RecyclerView productsRecycler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        ButterKnife.bind(this);
        ((RecipesApplication) getApplication()).getComponent().inject(this);
        productsListPresenter.setView(this);
        recipes = getIntent().getParcelableExtra(RECIPES_DATA);

        initView();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideWaitDialog();
    }


    private void initView() {
        restaurantName.setText(recipes.getTitle());
        try {
            Glide.with(this)
                    .load(recipes.getImages().get(0).getUrl())
                    .into(restaurantImage);
        }catch (Exception e){e.printStackTrace();}

    }

}
