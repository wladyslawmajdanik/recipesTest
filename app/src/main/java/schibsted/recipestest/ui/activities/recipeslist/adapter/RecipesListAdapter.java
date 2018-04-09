package schibsted.recipestest.ui.activities.recipeslist.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import schibsted.recipestest.R;
import schibsted.recipestest.model.recipes.Recipes;
import schibsted.recipestest.ui.activities.recipedetails.RecipeDetailsActivity;

import static schibsted.recipestest.utils.Constants.RECIPES_DATA;

public class RecipesListAdapter extends RecyclerView.Adapter<RecipesListAdapter.OrderTabViewHolder> {
    private LayoutInflater layoutInflater;
    private Activity activity;
    private List<Recipes> recipesList;

    public RecipesListAdapter(Activity activity, List<Recipes> recipesList) {
        this.activity = activity;
        this.layoutInflater = activity.getLayoutInflater();
        this.recipesList = recipesList;
    }

    @Override
    public OrderTabViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.recipies_list_item_view, viewGroup, false);

        return new OrderTabViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final OrderTabViewHolder viewHolder, int i) {
        viewHolder.restaurantName.setText(recipesList.get(i).getTitle());

         try {
             Glide.with(activity)
                     .load(recipesList.get(i).getImages().get(0).getUrl())
                     .into(viewHolder.restaurantImage);
         }catch (Exception e){e.printStackTrace();}

        viewHolder.cardView.setOnClickListener(v ->
                activity.startActivity(new Intent(activity, RecipeDetailsActivity.class).putExtra(RECIPES_DATA, recipesList.get(i))));
    }

    @Override
    public int getItemCount() {
        return recipesList.size();
    }


    public class OrderTabViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.restaurant_name)
        TextView restaurantName;
        @BindView(R.id.restaurant_image)
        ImageView restaurantImage;
        @BindView(R.id.card_view)
        CardView cardView;

        private OrderTabViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}

