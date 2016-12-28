package br.com.zup.omdb.buscadorfilmes.view.fragment.moviedetail;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import br.com.zup.omdb.buscadorfilmes.R;
import br.com.zup.omdb.buscadorfilmes.application.utils.WrapperLog;
import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;
import br.com.zup.omdb.buscadorfilmes.model.facade.MovieBO;
import br.com.zup.omdb.buscadorfilmes.view.fragment.AbstractFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends AbstractFragment {

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
    private Movie filme;

    public MovieDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        filme = MovieBO.getInstance().getMovieSelection();
        WrapperLog.info("DETAil "+getClass().getName()+ " - "+ filme.getTitle());
        initCollapsingToolbarLayout(view);
        binds(view);
        if(filme != null){
            showViewData(filme);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    private void initCollapsingToolbarLayout(View view) {

        final AppCompatActivity activity = initActionBar();
        if (toolbar != null) {
            toolbar.setTitle(filme.getTitle());
        }

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(filme.getTitle());

    }

    public void binds(View view){
        poster      = (ImageView) view.findViewById(R.id.backdrop);
        txtDirector = (TextView) view.findViewById(R.id.txt_director);
        txtactor    = (TextView) view.findViewById(R.id.txt_actors);
        txtGenre    = (TextView) view.findViewById(R.id.txt_genre);
        txtPlot     = (TextView) view.findViewById(R.id.txt_plot);
        txtType     = (TextView) view.findViewById(R.id.txt_type);
        txtWriter   = (TextView) view.findViewById(R.id.txt_writer);
        txtYear     = (TextView) view.findViewById(R.id.txt_year);
        txtTime     = (TextView) view.findViewById(R.id.txt_time);
        txtCountry  = (TextView) view.findViewById(R.id.txt_country);
        txtReleased = (TextView) view.findViewById(R.id.txt_released);
        txtawards   = (TextView) view.findViewById(R.id.txt_awards);


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

            Glide.with(getActivity()).load(showMovie.getPoster())
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(poster);

        }else {

//            connectionTest();
        }
    }
}
