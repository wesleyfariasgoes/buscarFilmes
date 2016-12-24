package br.com.zup.omdb.buscadorfilmes.presenter.business.moviesearch;

/**
 * Created by wesleygoes on 24/12/16.
 */

public interface OnFinishSearchListener {
    void onMovieError();
    void listMovies();
}
