package br.com.zup.omdb.buscadorfilmes.model.facade;

import android.app.Activity;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zup.omdb.buscadorfilmes.application.app.MovieApplication;
import br.com.zup.omdb.buscadorfilmes.application.utils.WrapperLog;
import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;

/**
 * Created by wesleygoes on 24/12/16.
 */

public class MovieBO {

    private static MovieBO        instance;
    private static final Object   SYNCOBJECT = new Object();
    private Movie                 movie;
    private MovieApplication      movieApplication;
    public List<Movie>            movies     = new ArrayList<Movie>();
    private Activity              context;
    private transient Dao<Movie,Integer>    movieDAO;

    public static MovieBO getInstance() {
        synchronized (SYNCOBJECT) {
            if (instance == null) {
                instance = new MovieBO();
            }
        }
        return instance;
    }

    // #############################################################
    // 							BOOK
    // #############################################################

    public boolean insertMovie(final Movie movie) {

        try {
            movieDAO = getMovieApplication().getMovieDAO();
            WrapperLog.info("Titulo criado com sucesso!!!");
            movieDAO.create(movie);
        } catch (SQLException e) {
            WrapperLog.info("error");
        }

        return true;
    }


    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public MovieApplication getMovieApplication() {
        return movieApplication;
    }

    public void setMovieApplication(MovieApplication movieApplication) {
        this.movieApplication = movieApplication;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }



    public Activity getContext() {
        return context;
    }

    public void setContext(Activity context) {
        this.context = context;
    }
}
