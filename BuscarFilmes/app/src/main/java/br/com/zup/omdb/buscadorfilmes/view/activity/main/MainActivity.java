package br.com.zup.omdb.buscadorfilmes.view.activity.main;

import android.content.Intent;
import android.os.Bundle;

import br.com.zup.omdb.buscadorfilmes.R;
import br.com.zup.omdb.buscadorfilmes.application.app.MovieApplication;
import br.com.zup.omdb.buscadorfilmes.model.facade.MovieBO;
import br.com.zup.omdb.buscadorfilmes.view.activity.AbstractActivity;
import br.com.zup.omdb.buscadorfilmes.view.activity.content.ContentActivity;

public class MainActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent negativeActivity = new Intent(MainActivity.this, ContentActivity.class);
        startActivity(negativeActivity);

        MovieBO.getInstance().setMovieApplication((MovieApplication) getApplication());
        MovieBO.getInstance().setContext(this);
    }
}
