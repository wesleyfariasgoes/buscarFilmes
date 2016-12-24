package br.com.zup.omdb.buscadorfilmes.presenter.business.moviesearch;

import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;
import br.com.zup.omdb.buscadorfilmes.model.facade.MovieBO;

/**
 * Created by wesleygoes on 24/12/16.
 */

public class MovieSeaarchInteractor implements OnSearchInteractor{
    @Override
    public void insert(String title, OnFinishSearchListener listener) {
        Movie movie = new Movie();
        movie.setTitle(title);
        MovieBO.getInstance().insertMovie(movie);
    }
}
