package br.com.zup.omdb.buscadorfilmes.business;

import java.sql.SQLException;
import java.util.List;

import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;

/**
 * Created by wesleygoes on 26/12/16.
 */

public interface OnMyMovieBusinessLogic {
    Movie getSearch(Movie movie) throws SQLException;

    List<Movie> getMovies() throws SQLException;

    List<Movie> getSearchMovies(String item) throws SQLException;

    void insertMovie(Movie research) throws SQLException, ObjectAlreadyExistException;

    void updateMovie(Movie movie) throws SQLException;

    void deleteMovie(Movie movie) throws SQLException;
}
