package br.com.zup.omdb.buscadorfilmes.presenter.business.movielist;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;
import br.com.zup.omdb.buscadorfilmes.view.fragment.movielist.OnMovieListFragment;

/**
 * Created by wesleygoes on 25/12/16.
 */
public class MovieListPresenter implements OnListMoviePresenter, OnListMovieActionFinish, RecyclerView.OnItemTouchListener {
    //variable
    private OnListMovieInteractor onListBookInteractor;
    private Context context;
    private GestureDetector gestureDetector;
    private OnMovieListFragment mOnListMovieView;
//    OnMainActivityView onMainActivityView;


    public MovieListPresenter(Activity activity, final RecyclerView listBook, final OnMovieListFragment mOnListMovieView) {

        this.onListBookInteractor = new ListMovieInteractor();
        this.mOnListMovieView = mOnListMovieView;

        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {

                View cv = listBook.findChildViewUnder(e.getX(), e.getY());
                if (cv != null && mOnListMovieView != null) {
                    mOnListMovieView.onClickListener(cv, listBook.getChildAdapterPosition(cv));
                }
                return (true);
            }
        });

    }

    @Override
    public void onResume() {
        onListBookInteractor.findItems(this);
    }

    @Override
    public void onDelete(Movie movie) {
        onListBookInteractor.deletItem(movie,this);
    }

    @Override
    public void refreshView() {
        mOnListMovieView.refresh();
    }


    @Override
    public void showMessage() {
        mOnListMovieView.showMessage("Show my listBook!!!");
    }

    @Override
    public void onFinished(List<Movie> movies) {
        mOnListMovieView.setItems(movies);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }
}
