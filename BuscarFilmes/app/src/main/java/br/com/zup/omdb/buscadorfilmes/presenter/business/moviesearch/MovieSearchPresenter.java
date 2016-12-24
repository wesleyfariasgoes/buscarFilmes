package br.com.zup.omdb.buscadorfilmes.presenter.business.moviesearch;

import br.com.zup.omdb.buscadorfilmes.application.utils.WrapperLog;
import br.com.zup.omdb.buscadorfilmes.view.fragment.moviesearch.OnMovieSearchView;

/**
 * Created by wesleygoes on 23/12/16.
 */

public class MovieSearchPresenter  implements OnMovieSearchPresenter, OnFinishSearchListener{

    private OnMovieSearchView onMovieSearchView;
    private OnSearchInteractor interactor;

    public MovieSearchPresenter(OnMovieSearchView onMovieSearchView) {
        this.onMovieSearchView = onMovieSearchView;
        this.interactor = new MovieSeaarchInteractor();
    }

    @Override
    public void insertUser(String title) {
//        if(title.equals("title")){
//
//        }
        WrapperLog.info("LOG AQUI"+ title);
        interactor.insert(title,this);
        onMovieSearchView.showMessage("Title "+title);
    }

    @Override
    public void onMovieError() {
        onMovieSearchView.setMovieError();
    }

    @Override
    public void listMovies() {

    }


}
