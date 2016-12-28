package br.com.zup.omdb.buscadorfilmes.model.facade;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zup.omdb.buscadorfilmes.application.app.MovieApplication;
import br.com.zup.omdb.buscadorfilmes.application.utils.WrapperLog;
import br.com.zup.omdb.buscadorfilmes.business.AmbienteManager;
import br.com.zup.omdb.buscadorfilmes.business.ObjectAlreadyExistException;
import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;

/**
 * Created by wesleygoes on 24/12/16.
 */

public class MovieBO {

    private static MovieBO instance = null;
    private static final Object SYNCOBJECT = new Object();

    private boolean isTablet;
    private boolean isClickable = true;
    private long clickLockKey = 0;
    private AmbienteManager ambienteManager;
    private Movie movieSelection;


    public static MovieBO getInstance() {
        synchronized (SYNCOBJECT) {
            if (instance == null) {
                instance = new MovieBO();
            }
        }
        return instance;
    }

    public void hidKeyboad(final View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    synchronized public boolean isClickable(long time) {
        return (time == clickLockKey);
    }

    synchronized public long setClickable() {
        if ( isClickable ) {
            isClickable = false;
            clickLockKey = System.currentTimeMillis() + 500;
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isClickable = true;
                }
            }, 500);

            return clickLockKey;
        }

        return 0;
    }


    public void vibrate(final Context context) {
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
    }


    public void animateView(final ViewGroup view, final String property, final int duration) {
        final boolean isOpening = View.GONE == view.getVisibility();
        int size = getSize(view, property);
        final float start = isOpening ? size : 0;
        final float end = isOpening ? 0 : size;

        ObjectAnimator animator = ObjectAnimator.ofFloat(view, property, start, end);
        animator.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                if ( isOpening ) {
                    view.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onAnimationRepeat(Animator animation) {}

            @Override
            public void onAnimationEnd(Animator animation) {
                if ( !isOpening ) {
                    view.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {}
        });
        animator.setDuration(duration);
        animator.start();
    }


    public void animateView(final ViewGroup view, final String property, final int duration, final float startAxisPosition, final float finalAxisPosition) {
        final float start = startAxisPosition;
        final float end = finalAxisPosition;

        ObjectAnimator animator = ObjectAnimator.ofFloat(view, property, start, end);
        animator.setDuration(duration);
        animator.start();
    }

    private int getSize(ViewGroup view, String property) {
        int size = 0;
        if ( property.equals("translationX") ) {
            size = view.getWidth();
        } else if (property.equals("translationY")) {
            size = view.getHeight();
        }

        return size;
    }


    public void addFilmes(Movie movie) {
        ambienteManager = (AmbienteManager) MovieApplication.getInstance().get(AmbienteManager.KEY);
        try {
            ambienteManager.insertMovie(movie);
        } catch (SQLException e) {
            WrapperLog.info("Erro ao adicionar uma nova pesquisa " + e.getMessage());
        } catch (ObjectAlreadyExistException e) {
            WrapperLog.info("Dados já foram inseridos" + e.getMessage());
        } catch (Exception e) {
            WrapperLog.info("Erro:" + e.getMessage());
        }
    }

    public void updateMoviesUrl(Movie movie) {
        ambienteManager = (AmbienteManager) MovieApplication.getInstance().get(AmbienteManager.KEY);
        try {
            ambienteManager.updateMovie(movie);
        } catch (SQLException e) {
            Log.i("","Erro ao atualizar Url " + e.getMessage());
        }
    }

    public Movie getSearch(Movie movie) {

        ambienteManager = (AmbienteManager) MovieApplication.getInstance().get(AmbienteManager.KEY);
        Movie result = null;
        try {
            result = ambienteManager.getSearch(movie);
        } catch (SQLException e) {
            Log.i(""," Não foi possível consultar dados cadastrados. " + e.getMessage());
        }
        return result;
    }

    public List<Movie> getMovies() {
        ambienteManager = (AmbienteManager) MovieApplication.getInstance().get(AmbienteManager.KEY);
        List<Movie> questions = new ArrayList<Movie>();
        try {
            questions = ambienteManager.getMovies();
        } catch (SQLException e) {
            Log.i(""," Não foi possível consultar dados cadastrados. " + e.getMessage());
        }
        return questions;
    }

    public List<Movie> getSearchMovies(String title) {
        ambienteManager = (AmbienteManager) MovieApplication.getInstance().get(AmbienteManager.KEY);
        List<Movie> movie = new ArrayList<>();
        try {
            movie = ambienteManager.getSearchMovies(title);
        } catch (SQLException e) {
            WrapperLog.info("Error " + e.getMessage());
        }
        return movie;
    }

    public void deleteInventory(final Movie movie) {
        ambienteManager = (AmbienteManager) MovieApplication.getInstance().get(AmbienteManager.KEY);
        try {
            ambienteManager.deleteMovie(movie);
        } catch (SQLException e) {
            WrapperLog.info("Erro ao excluir um Item" + e.getMessage());
        }
    }
    public Movie getMovieSelection() {
        return movieSelection;
    }

    public void setMovieSelection(Movie filmeSelection) {
        this.movieSelection = filmeSelection;
    }
}
