package br.com.zup.omdb.buscadorfilmes.presenter.business.movielist;

import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;

/**
 * Created by wesleygoes on 25/12/16.
 */
public interface OnListMovieInteractor {

    void findItems(OnListMovieActionFinish listener);

    void deletItem(Movie movie);
}
