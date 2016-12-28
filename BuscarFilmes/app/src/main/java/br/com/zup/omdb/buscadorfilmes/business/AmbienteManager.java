package br.com.zup.omdb.buscadorfilmes.business;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;
import br.com.zup.omdb.buscadorfilmes.persistence.DataBaseHelper;

/**
 * Created by wesleygoes on 26/12/16.
 */

public class AmbienteManager implements OnMyMovieBusinessLogic{
    public static final String KEY = "ModelBO";
    private DataBaseHelper dataBaseHelper;
    private static AmbienteManager SINGLETON;

    public static AmbienteManager getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new AmbienteManager();
        }
        return SINGLETON;
    }

    public void startSession(Context ctx) {
        dataBaseHelper = new DataBaseHelper(ctx);
        dataBaseHelper.getWritableDatabase();
    }

    @Override
    public Movie getSearch(Movie movie) throws SQLException {
        QueryBuilder<Movie, Integer> queryBuilder = (QueryBuilder<Movie, Integer>) dataBaseHelper.getDao(Movie.class).queryBuilder();
        queryBuilder.where().eq("id", movie.getId());
        queryBuilder.limit(1);
        movie = queryBuilder.queryForFirst();
        return movie;
    }

    @Override
    public List<Movie> getMovies() throws SQLException {
        List<Movie> result = null;
        QueryBuilder queryBuilder = dataBaseHelper.getDao(Movie.class).queryBuilder();
        result = queryBuilder.query();
        return result;
    }

    @Override
    public List<Movie> getSearchMovies(String item) throws SQLException {
        List<Movie> result = null;
        QueryBuilder queryBuilder = dataBaseHelper.getDao(Movie.class).queryBuilder();
        queryBuilder.where().eq("title", item);
        queryBuilder.limit(1);
        result = queryBuilder.query();
        return result;
    }

    @Override
    public void insertMovie(Movie research) throws SQLException, ObjectAlreadyExistException {
        Dao<Movie, Long> dao = dataBaseHelper.getDao(Movie.class);
        dataBaseHelper.getDao(Movie.class).createOrUpdate(research);
    }

    @Override
    public void updateMovie(Movie filmes) throws SQLException {

    }

    @Override
    public void deleteMovie(Movie movie) throws SQLException {
        dataBaseHelper.getDao(Movie.class).delete(movie);
    }
}
