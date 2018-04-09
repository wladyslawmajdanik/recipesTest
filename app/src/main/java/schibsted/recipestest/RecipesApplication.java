package schibsted.recipestest;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.facebook.stetho.Stetho;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import schibsted.recipestest.injection.components.AppComponent;
import schibsted.recipestest.injection.components.DaggerAppComponent;
import schibsted.recipestest.injection.modules.AppModule;
import schibsted.recipestest.injection.modules.ContextModule;
import schibsted.recipestest.injection.modules.NetworkModule;
import schibsted.recipestest.injection.modules.RealmModule;
import schibsted.recipestest.utils.Constants;


public class RecipesApplication extends MultiDexApplication {

    private static RecipesApplication instance;
    private AppComponent component;

    public RecipesApplication() {
        instance = this;
    }

    public static RecipesApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        Realm.getInstance(config);

        Stetho.initializeWithDefaults(this);

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .contextModule(new ContextModule(this))
                .realmModule(new RealmModule())
                .networkModule(new NetworkModule(Constants.getBaseUrl()))
                .build();

    }


    public AppComponent getComponent() {
        return component;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


}