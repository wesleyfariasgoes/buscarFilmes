package br.com.zup.omdb.buscadorfilmes.view.fragment.moviesearch;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.com.zup.omdb.buscadorfilmes.R;
import br.com.zup.omdb.buscadorfilmes.application.utils.WrapperLog;
import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;
import br.com.zup.omdb.buscadorfilmes.model.facade.MovieBO;
import br.com.zup.omdb.buscadorfilmes.presenter.business.moviesearch.MovieSearchPresenter;
import br.com.zup.omdb.buscadorfilmes.presenter.business.moviesearch.OnMovieSearchPresenter;
import br.com.zup.omdb.buscadorfilmes.view.activity.main.MainActivity;
import br.com.zup.omdb.buscadorfilmes.view.fragment.AbstractFragment;
import br.com.zup.omdb.buscadorfilmes.view.message.Message;
import butterknife.ButterKnife;

/**
 * Created by wesleygoes on 23/12/16.
 */
public class MovieSearchFragment extends AbstractFragment implements OnMovieSearchView, View.OnClickListener {

    EditText               mEdtName;
    EditText               mEdtGenre;
    Button                 mBtSave;
    private int            contador = 0;
    private OnMovieSearchPresenter presenter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        WrapperLog.info("Script "+ "HOST S "+activity.getClass().getName());
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        WrapperLog.info("Script "+ "onCreate S "+savedInstance);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        if(savedInstanceState != null){
            contador = savedInstanceState.getInt("contador");
        }
        WrapperLog.info("Script "+ "CONTADOR  S"+contador);
        rootView = inflater.inflate(R.layout.fragment_movie_search, (ViewGroup) null);
        onBackPress(null);
        ButterKnife.bind(this,rootView);
        binds(rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        clear();
        WrapperLog.info("Script "+ "onActivityCreated S "+savedInstanceState);
    }

    private void binds(View view) {
        mEdtName             = (EditText) view.findViewById(R.id.edtName);
        mEdtGenre            = (EditText) view.findViewById(R.id.edt_genre);
        mBtSave              = (Button) view.findViewById(R.id.btn_save);
        presenter            = new MovieSearchPresenter(this);
        mBtSave              .setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
//        WrapperLog.info("Script "+ "onStart() S");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        WrapperLog.info("Script "+ "onDestroyView() S");
    }

    @Override
    public void onResume() {
        super.onResume();
        contador++;
        WrapperLog.info("Script "+ "onResume() S "+contador);
    }

    @Override
    public void onPause() {
        super.onPause();
//        getActivity().getSupportFragmentManager().popBackStack();
//        WrapperLog.info("Script "+ "onPause() S");
    }

    @Override
    public void onStop() {
        super.onStop();
//        getActivity().getSupportFragmentManager().popBackStack();
//        WrapperLog.info("Script "+ "onStop() S");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        WrapperLog.info("Script "+ "onDestroy() S");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        WrapperLog.info("Script "+ "onSaveInstanceState S"+outState);
        outState.putInt("contador",contador);
    }

    @Override
    public void showMessage(String message) {
        Message.showConfirmationCrouton(getActivity(),message+" "+getString(R.string.registerOk));
    }

    @Override
    public void setMovieError() {
        mEdtName.setError("endereco error");
    }

    @Override
    public void setTransfer() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent negativeActivity = new Intent(getActivity(), MainActivity.class);
                startActivity(negativeActivity);
            }
        },1000);


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
                hideKeyboard();
                clear();
//                setTransfer();

            }
        }else{
            Toast.makeText(getContext(),"Digite o nome do Filme",Toast.LENGTH_SHORT).show();
        }

    }

    public void clear(){
        mEdtName.getText().clear();
    }

    private void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
