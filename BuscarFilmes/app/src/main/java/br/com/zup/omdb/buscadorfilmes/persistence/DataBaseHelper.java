package br.com.zup.omdb.buscadorfilmes.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;

public class DataBaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "movie.sqlite";
	private static final int DATABASE_VERSION = 1;

	public DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, Movie.class);
			
		} catch (java.sql.SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
						  int oldVersion, int newVersion) {
		try {
			TableUtils.dropTable(connectionSource, Movie.class, true);
			onCreate(db, connectionSource);
		} catch (java.sql.SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void close() {
		super.close();
	}
	
}

