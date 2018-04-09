package schibsted.recipestest.utils;

import schibsted.recipestest.BuildConfig;

public class Constants {

    public final static String SHARED_PREFERENCES = "shared_preferences";
    public final static String RECIPES_DATA = "recipes_data";

    public static String getBaseUrl() {
        return BuildConfig.BASE_URL;
    }


}
