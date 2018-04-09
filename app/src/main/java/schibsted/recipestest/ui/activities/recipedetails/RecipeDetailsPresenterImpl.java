package schibsted.recipestest.ui.activities.recipedetails;


import io.reactivex.disposables.CompositeDisposable;
import schibsted.recipestest.repository.local.LocalRepository;
import schibsted.recipestest.repository.remote.RemoteRepository;
import schibsted.recipestest.ui.Presenter;

public class RecipeDetailsPresenterImpl implements RecipeDetailsPresenter, Presenter {


    private RemoteRepository remoteRepository;
    private LocalRepository localRepository;
    private RecipeDetailsView view;
    private CompositeDisposable disposable;

    public RecipeDetailsPresenterImpl(RemoteRepository remoteRepository, LocalRepository localRepository) {
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
    public void setView(RecipeDetailsView view) {
        this.view = view;
    }


}
