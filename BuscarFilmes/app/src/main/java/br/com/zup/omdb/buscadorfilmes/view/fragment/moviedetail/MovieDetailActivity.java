package br.com.zup.omdb.buscadorfilmes.view.fragment.moviedetail;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import br.com.zup.omdb.buscadorfilmes.R;
import br.com.zup.omdb.buscadorfilmes.application.utils.WrapperLog;
import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;
import br.com.zup.omdb.buscadorfilmes.model.facade.MovieBO;

/**
 * Created by wesleygoes on 27/12/16.
 */

public class MovieDetailActivity extends AppCompatActivity {
    private TextView txtDirector;
    private TextView txtactor;
    private TextView txtType;
    private TextView txtPlot;
    private TextView txtWriter;
    private TextView txtGenre;
    private TextView txtYear;
    private TextView txtTime;
    private TextView txtCountry;
    private TextView txtReleased;
    private TextView txtawards;
    private ImageView poster;
    private Toolbar toolbar;
    private Movie filme;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_movie_detail);
        filme = MovieBO.getInstance().getMovieSelection();
        initCollapsingToolbarLayout();
        binds();
        if(filme != null){
            showViewData(filme);
        }
    }

    private void initCollapsingToolbarLayout() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(filme.getTitle());
        if (toolbar != null) {
            toolbar.setTitle(filme.getTitle());
        }
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

    }

    public void binds(){
        toolbar     = (Toolbar) findViewById(R.id.toolbarX);
        poster      = (ImageView) findViewById(R.id.backdrop);
        txtDirector = (TextView) findViewById(R.id.txt_director);
        txtactor    = (TextView) findViewById(R.id.txt_actors);
        txtGenre    = (TextView) findViewById(R.id.txt_genre);
        txtPlot     = (TextView) findViewById(R.id.txt_plot);
        txtType     = (TextView) findViewById(R.id.txt_type);
        txtWriter   = (TextView) findViewById(R.id.txt_writer);
        txtYear     = (TextView) findViewById(R.id.txt_year);
        txtTime     = (TextView) findViewById(R.id.txt_time);
        txtCountry  = (TextView) findViewById(R.id.txt_country);
        txtReleased = (TextView) findViewById(R.id.txt_released);
        txtawards   = (TextView) findViewById(R.id.txt_awards);


    }

    public void showViewData(Movie filme){

        Movie showMovie = MovieBO.getInstance().getSearch(filme);
        WrapperLog.info("SHOW_MOVIE "+showMovie.getTitle());
        if(showMovie != null && showMovie.getImdbID() != null) {
            txtDirector.setText(showMovie.getDirector());
            txtactor.setText(showMovie.getActors());
            txtPlot.setText(showMovie.getPlot());
            txtWriter.setText(showMovie.getWriter());
            txtGenre.setText(showMovie.getGenre());
            txtYear.setText(showMovie.getYear());
            txtType.setText(showMovie.getType());
            txtTime.setText(showMovie.getRuntime());
            txtTime.setText(showMovie.getRuntime());
            txtReleased.setText(showMovie.getReleased());
            txtCountry.setText(showMovie.getCountry());
            txtawards.setText(showMovie.getAwards());

            Glide.with(this).load(showMovie.getPoster())
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(poster);

        }else {

//            connectionTest();
        }
    }
}