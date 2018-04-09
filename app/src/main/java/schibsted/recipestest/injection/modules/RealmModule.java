package schibsted.recipestest.injection.modules;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import schibsted.recipestest.injection.scopes.AppScope;


@Module
public class RealmModule {

    @Provides
    @AppScope
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }
}
