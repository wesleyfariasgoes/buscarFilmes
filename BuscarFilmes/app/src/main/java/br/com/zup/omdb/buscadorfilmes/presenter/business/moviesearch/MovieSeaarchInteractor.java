package br.com.zup.omdb.buscadorfilmes.presenter.business.moviesearch;

import br.com.zup.omdb.buscadorfilmes.application.rest.RestClient;
import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;
import br.com.zup.omdb.buscadorfilmes.model.facade.MovieBO;

/**
 * Created by wesleygoes on 24/12/16.
 */

public class MovieSeaarchInteractor implements OnSearchInteractor {
    private RestClient mRestClient;
    private Movie movie;

    @Override
    public void insert(final String title, OnFinishSearchListener listener) {
        movie = new Movie();
        movie.setTitle(title);
        MovieBO.getInstance().addFilmes(movie);
    }


}

