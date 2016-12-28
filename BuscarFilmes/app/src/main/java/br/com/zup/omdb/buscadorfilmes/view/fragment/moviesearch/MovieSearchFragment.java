package br.com.zup.omdb.buscadorfilmes.view.fragment.moviesearch;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.com.zup.omdb.buscadorfilmes.R;
import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;
import br.com.zup.omdb.buscadorfilmes.model.facade.MovieBO;
import br.com.zup.omdb.buscadorfilmes.presenter.business.moviesearch.MovieSearchPresenter;
import br.com.zup.omdb.buscadorfilmes.presenter.business.moviesearch.OnMovieSearchPresenter;
import br.com.zup.omdb.buscadorfilmes.view.activity.main.MainActivity;
import br.com.zup.omdb.buscadorfilmes.view.fragment.AbstractFragment;
import br.com.zup.omdb.buscadorfilmes.view.message.Message;

/**
 * Created by wesleygoes on 23/12/16.
 */
public class MovieSearchFragment extends AbstractFragment implements OnMovieSearchView, View.OnClickListener {

    private EditText               mEdtName;
    private EditText               mEdtGenre;
    private Button                 mBtSave;
    private OnMovieSearchPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_movie_search, (ViewGroup) null);
        onBackPress(null);
        binds(rootView);
        clear();
        return rootView;
    }

    private void binds(View view) {
        mEdtName             = (EditText) view.findViewById(R.id.edtName);
        mEdtGenre            = (EditText) view.findViewById(R.id.edt_genre);
        mBtSave              = (Button) view.findViewById(R.id.btn_save);
        presenter            = new MovieSearchPresenter(this);
        mBtSave              .setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setMovieError() {
        mEdtName.setError("endereco error");
    }

    @Override
    public void setTransfer() {
        Intent negativeActivity = new Intent(getActivity(), MainActivity.class);
        startActivity(negativeActivity);

    }

    @Override
    public void onClick(View view) {
        if(mEdtName.getText().toString() != null && !mEdtName.getText().toString().isEmpty()){
            Movie movie = new Movie();
            movie.setTitle(mEdtName.getText().toString());
            List<Movie> filmes = MovieBO.getInstance().getSearchMovies(movie.getTitle());
            if(filmes != null && filmes.size() > 0 && filmes.get(0).getTitle().equalsIgnoreCase(mEdtName.getText().toString())){
                Message.showAlertCrouton(getActivity(), getString(R.string.registerNo));
                mBtSave.setEnabled(true);
            }else{

                presenter.insertUser(mEdtName.getText().toString());
                clear();
                setTransfer();
                Message.showConfirmationCrouton(getActivity(),getString(R.string.registerOk));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        mBtSave.setEnabled(true);
                    }
                },1000);

            }
        }else{
            Toast.makeText(getContext(),"Digite o nome do Filme",Toast.LENGTH_SHORT).show();
        }

    }

    public void clear(){
        mEdtName.getText().clear();
    }
}
