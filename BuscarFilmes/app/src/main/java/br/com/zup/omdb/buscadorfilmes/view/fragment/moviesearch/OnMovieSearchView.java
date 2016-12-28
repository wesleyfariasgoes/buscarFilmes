package br.com.zup.omdb.buscadorfilmes.view.fragment.moviesearch;

/**
 * Created by wesleygoes on 23/12/16.
 */
public interface OnMovieSearchView {
    void showMessage(String message);
    void setMovieError();
    void setTransfer();
}
