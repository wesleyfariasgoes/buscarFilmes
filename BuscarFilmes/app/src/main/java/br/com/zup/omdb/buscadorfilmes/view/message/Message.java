package br.com.zup.omdb.buscadorfilmes.view.message;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by luccas.melo on 13/01/2016.
 */
public final class Message {
    public static void showToast(final Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void showToast(final Context context, String title, String msg) {
        Toast.makeText(context, title + "\n" + msg, Toast.LENGTH_LONG).show();
    }

    public static void showSnackBar(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).setAction("Action", null).show();

    }

    public static void showAlertCrouton(Activity context, String message) {
        Crouton.makeText(context, "\n" + message + "\n", Style.ALERT).show();
    }

    public static void showInfoCrouton(Activity context, String message) {
        Crouton.makeText(context, "\n" + message + "\n", Style.INFO).show();
    }

    public static void showConfirmationCrouton(Activity context, String message) {
        Crouton.makeText(context, "\n" + message + "\n", Style.CONFIRM).show();
    }
}
