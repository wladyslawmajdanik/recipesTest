package schibsted.recipestest.ui.activities.recipeslist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.RelativeLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import schibsted.recipestest.R;
import schibsted.recipestest.RecipesApplication;
import schibsted.recipestest.model.recipes.Recipes;
import schibsted.recipestest.ui.activities.base.BaseActivity;
import schibsted.recipestest.ui.activities.recipeslist.adapter.RecipesListAdapter;

public class RecipesListActivity extends BaseActivity implements RecipesListView {
    List<Recipes> recipesList;
    RecipesListAdapter recipesListAdapter;
    @Inject
    public RecipesListPresenter recipesListPresenter;
    @BindView(R.id.recipes_list_container)
    RelativeLayout restaurantListContainer;
    @BindView(R.id.recipes_list_recycler)
    RecyclerView recipeRecycleView;
    @BindView(R.id.filter_recipes)
    SearchView filterRecipes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);
        ButterKnife.bind(this);
        ((RecipesApplication) getApplication()).getComponent().inject(this);
        recipesListPresenter.setView(this);
        getRecipes();

    }

    @Override
    public void onSuccessDownloadRecipesList(List<Recipes> recipesList) {
        recipesListPresenter.saveRecipesToDB(recipesList);
        setRecipesListAdapter(recipesList);
        hideWaitDialog();
    }

    @Override
    public void onErrorDownloadRecipesList() {
        getRecipesFromDB();
        hideWaitDialog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideWaitDialog();
    }

    private void addFilterListener() {
        filterRecipes.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recipesListAdapter.filter(newText);
                return false;
            }
        });
    }
    private void getRecipes() {
        if (isNetworkAvailable()) {
            waitDialog.show();
            recipesListPresenter.getRecipes();
        } else {
            getRecipesFromDB();
        }
    }

    private void getRecipesFromDB() {
        recipesList = recipesListPresenter.recipesFromDB();
        if (recipesList.size() > 0) {
            setRecipesListAdapter(recipesList);
        } else if (!isNetworkAvailable()) {
            handleNoInternetState(restaurantListContainer);
        } else {
            showError(restaurantListContainer);
        }
    }


    private void setRecipesListAdapter(List<Recipes> recipesList) {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recipeRecycleView.setLayoutManager(layoutManager);
        recipesListAdapter = new RecipesListAdapter(this, recipesList);
        recipeRecycleView.setAdapter(recipesListAdapter);
        addFilterListener();
    }


}
