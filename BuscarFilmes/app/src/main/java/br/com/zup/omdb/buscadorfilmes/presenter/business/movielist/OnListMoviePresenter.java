package br.com.zup.omdb.buscadorfilmes.presenter.business.movielist;

import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;

/**
 * Created by wesleygoes on 23/12/16.
 */
public interface OnListMoviePresenter {
    void showMessage();
    void onResume();
    void onDelete(Movie movie);
}
