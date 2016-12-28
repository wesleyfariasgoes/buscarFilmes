package br.com.zup.omdb.buscadorfilmes.presenter.business.movielist;

import java.util.List;

import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;

/**
 * Created by wesleygoes on 23/12/16.
 */
public interface OnListMovieActionFinish {

    void onFinished(List<Movie> movies);
}
