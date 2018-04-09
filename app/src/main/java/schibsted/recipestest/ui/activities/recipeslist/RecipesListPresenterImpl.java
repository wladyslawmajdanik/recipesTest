package schibsted.recipestest.ui.activities.recipeslist;


import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import schibsted.recipestest.model.recipes.Recipes;
import schibsted.recipestest.repository.local.LocalRepository;
import schibsted.recipestest.repository.remote.RemoteRepository;
import schibsted.recipestest.ui.Presenter;
import timber.log.Timber;

public class RecipesListPresenterImpl implements RecipesListPresenter, Presenter {

    private LocalRepository localRepository;
    private RemoteRepository remoteRepository;
    private RecipesListView view;
    private CompositeDisposable disposable;

    public RecipesListPresenterImpl(RemoteRepository remoteRepository, LocalRepository localRepository) {
        this.remoteRepository = remoteRepository;
        this.localRepository = localRepository;
        disposable = new CompositeDisposable();
    }

    @Override
    public void clearRx() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void setView(RecipesListView view) {
        this.view = view;
    }

    @Override
    public void getRecipes() {
        disposable.add(getRecipesObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetRecipesSuccess, this::onGetRecipesError));
    }

    @Override
    public List<Recipes> recipesFromDB() {
        return localRepository.getRecipesFromDB();
    }

    @Override
    public void saveRecipesToDB(List<Recipes> recipesList) {
        localRepository.saveRecipesToDB(recipesList);
    }

    private Observable<List<Recipes>> getRecipesObservable() {
//"","thumbnail-medium","1",
        return remoteRepository.getRecipes(5, 2)
                .subscribeOn(Schedulers.io());
    }

    private void onGetRecipesSuccess(List<Recipes> recipesList) {
        view.onSuccessDownloadRecipesList(recipesList);
    }

    private void onGetRecipesError(Throwable throwable) {
        view.onErrorDownloadRecipesList();
        Timber.e(throwable);
    }


}
