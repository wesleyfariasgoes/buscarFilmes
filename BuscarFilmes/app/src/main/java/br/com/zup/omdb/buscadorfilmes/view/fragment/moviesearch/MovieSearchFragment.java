package br.com.zup.omdb.buscadorfilmes.view.fragment.moviesearch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.zup.omdb.buscadorfilmes.R;
import br.com.zup.omdb.buscadorfilmes.application.utils.WrapperLog;
import br.com.zup.omdb.buscadorfilmes.presenter.business.moviesearch.MovieSearchPresenter;
import br.com.zup.omdb.buscadorfilmes.presenter.business.moviesearch.OnMovieSearchPresenter;

/**
 * Created by wesleygoes on 23/12/16.
 */
public class MovieSearchFragment extends Fragment implements OnMovieSearchView, View.OnClickListener {

    private EditText               mEdtName;
    private EditText               mEdtGenre;
    private Button                 mBtSave;
    private OnMovieSearchPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_movie_search, container, false);
        binds(view);
        return view;
    }

    private void binds(View view) {
        mEdtName             = (EditText) view.findViewById(R.id.edtName);
        mEdtGenre            = (EditText) view.findViewById(R.id.edt_genre);
//        mBtSave              = (Button) view.findViewById(R.id.btn_save);
        view.findViewById(R.id.btn_save).setOnClickListener(this);
        presenter            = new MovieSearchPresenter(this);

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
    public void onClick(View view) {

        presenter.insertUser(mEdtName.getText().toString());
    }
}
