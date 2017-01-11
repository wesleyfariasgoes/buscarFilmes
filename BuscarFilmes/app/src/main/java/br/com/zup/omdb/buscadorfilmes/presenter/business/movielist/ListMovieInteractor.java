package br.com.zup.omdb.buscadorfilmes.presenter.business.movielist;

import java.util.List;

import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;
import br.com.zup.omdb.buscadorfilmes.model.facade.MovieBO;

/**
 * Created by wesleygoes on 25/12/16.
 */
public class ListMovieInteractor implements OnListMovieInteractor {

    /**
     * method to get list of the data base
     */
    @Override
    public void findItems(final OnListMovieActionFinish listener) {
        List<Movie> movieList = MovieBO.getInstance().getMovies();
        listener.onFinished(movieList);

    }

    @Override
    public void deletItem(Movie movie,OnListMoviePresenter listener) {
        MovieBO.getInstance().deleteInventory(movie);
        listener.refreshView();
    }
}
