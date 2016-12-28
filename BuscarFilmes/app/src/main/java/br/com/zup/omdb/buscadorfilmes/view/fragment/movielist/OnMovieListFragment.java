package br.com.zup.omdb.buscadorfilmes.view.fragment.movielist;

import android.view.View;

import java.util.List;

import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;

/**
 * Created by wesleygoes on 23/12/16.
 */
public interface OnMovieListFragment {
    void replaceFragment(int position);
    void showMessage(String message);
    void setItems(List<Movie> movies);
    void onClickListener(View view, int position);
    void upDateList(Movie movie,String title);
    void onSetItemMovie(Movie itemMovie);
    void setDeleteButton(Movie movie);
}
