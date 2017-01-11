package br.com.zup.omdb.buscadorfilmes.view.fragment.content;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import br.com.zup.omdb.buscadorfilmes.R;
import br.com.zup.omdb.buscadorfilmes.view.activity.main.MainActivity;
import br.com.zup.omdb.buscadorfilmes.view.fragment.AbstractFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends AbstractFragment {


    protected BottomNavigationView bottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_content, (ViewGroup) null);
        onBackPress(null);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binds();
    }

    private void binds() {
        ((MainActivity)getActivity()).showMovieList();
        bottomNavigationView        = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        bottomNavigationView        .setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.list_movie) {
                    ((MainActivity)getActivity()).showMovieList();
                } else if (item.getItemId() == R.id.search_movie) {
                    ((MainActivity)getActivity()).showMovieSearch();
                }else if (item.getItemId() == R.id.home_movie) {
                    Toast.makeText(getActivity(),"Em construção",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }
}
