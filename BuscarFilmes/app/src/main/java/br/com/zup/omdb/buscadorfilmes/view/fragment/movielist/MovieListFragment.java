package br.com.zup.omdb.buscadorfilmes.view.fragment.movielist;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.zup.omdb.buscadorfilmes.R;

/**
 * Created by wesleygoes on 23/12/16.
 */

public class MovieListFragment extends Fragment implements OnMovieListFragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private FragmentActivity myContext;
    private FragmentManager fragmentManager;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        myContext=(FragmentActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        fragmentManager = myContext.getSupportFragmentManager();
        inicializaComponentesUi(view);
        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        exampleData = getArguments().getString(ARG_AXAMPLE);
    }

    private void inicializaComponentesUi(View view) {
        recyclerView    = (RecyclerView) view.findViewById(R.id.recycler_list);
        layoutManager   = new LinearLayoutManager(getActivity());
        recyclerView    .setLayoutManager(layoutManager);

        adapter         = new ListMovieAdapter(this);
        recyclerView    .setAdapter(adapter);
    }
    @Override
    public void replaceFragment(int position) {

    }
}
