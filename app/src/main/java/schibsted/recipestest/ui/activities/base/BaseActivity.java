package schibsted.recipestest.ui.activities.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import schibsted.recipestest.R;
import timber.log.Timber;

public class BaseActivity extends AppCompatActivity implements schibsted.recipestest.ui.View {

    public MaterialDialog waitDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildWaitDialog();

    }

    @Override
    public void showError(View view) {
        showErrorSnackBar(view, getResources().getString(R.string.error_occurred));

    }

    @Override
    public void handleNoInternetState(View view) {
        showErrorSnackBar(view, getResources().getString(R.string.no_internet_connection));

    }

    public void hideWaitDialog() {
        try {
            if (waitDialog != null && waitDialog.isShowing()) {
                waitDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildWaitDialog() {
        waitDialog = new MaterialDialog.Builder(this)
                .title(getResources().getString(R.string.please_wait))
                .progress(true, 0)
                .progressIndeterminateStyle(true)
                .widgetColorRes(R.color.colorPrimary)
                .cancelable(true)
                .canceledOnTouchOutside(false)
                .cancelListener(dialogInterface -> finish())
                .build();
    }

    protected void showErrorSnackBar(View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setMaxLines(5);
        textView.setTextColor(getResources().getColor(R.color.white));
        snackBarView.setBackgroundColor(getResources().getColor(R.color.errorColor));
        snackbar.show();
    }

    public boolean isNetworkAvailable() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        Timber.d("NETWORK AVAIBLE? %S", haveConnectedWifi || haveConnectedMobile);
        return haveConnectedWifi || haveConnectedMobile;
    }
}
