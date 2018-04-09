package schibsted.recipestest.ui.activities.recipedetails.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import schibsted.recipestest.R;
import schibsted.recipestest.model.recipes.Ingredient;


public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.OrderTabViewHolder> {
    private LayoutInflater layoutInflater;
    private Activity activity;
    private List<Ingredient> ingredients;

    public IngredientAdapter(Activity activity, List<Ingredient> ingredients) {
        this.activity = activity;
        this.layoutInflater = activity.getLayoutInflater();
        this.ingredients = ingredients;
    }

    @Override
    public IngredientAdapter.OrderTabViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.ingridient_item_view, viewGroup, false);

        return new IngredientAdapter.OrderTabViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final IngredientAdapter.OrderTabViewHolder viewHolder, int i) {
        viewHolder.ingredientName.setText(ingredients.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }


    public class OrderTabViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ingredient_name)
        TextView ingredientName;


        private OrderTabViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}


