package br.com.zup.omdb.buscadorfilmes.application.app;

import android.app.Application;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;
import br.com.zup.omdb.buscadorfilmes.persistence.DataBaseHelper;

/**
 * Created by wesleygoes on 24/12/16.
 */

public class MovieApplication extends Application {
    private DataBaseHelper databaseHelper = null;
    private Dao<Movie, Integer> movieDAO = null;

    @Override
    public void onCreate() {
        super.onCreate();
        databaseHelper = new DataBaseHelper(this);
    }

    public Dao<Movie, Integer> getMovieDAO() throws SQLException{
        if(movieDAO == null){
            movieDAO = databaseHelper.getDao(Movie.class);
        }
        return movieDAO;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }
}
