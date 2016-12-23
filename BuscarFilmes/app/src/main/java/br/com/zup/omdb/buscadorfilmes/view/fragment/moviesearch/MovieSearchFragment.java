package br.com.zup.omdb.buscadorfilmes.view.fragment.moviesearch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.zup.omdb.buscadorfilmes.R;

/**
 * Created by wesleygoes on 23/12/16.
 */
public class MovieSearchFragment extends Fragment {


    public MovieSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_search, container, false);
    }

}
