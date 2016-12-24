package br.com.zup.omdb.buscadorfilmes.view.activity.content;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.zup.omdb.buscadorfilmes.view.fragment.movielist.MovieListFragment;
import br.com.zup.omdb.buscadorfilmes.view.fragment.moviesearch.MovieSearchFragment;

/**
 * Created by wesleygoes on 23/12/16.
 */

public class ContentViewPagerAdapter extends FragmentPagerAdapter {


    private final String[] mTitles = {"Filmes","Inserir"};

    public ContentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MovieListFragment();
            case 1:
                return new MovieSearchFragment();
        }
        return null;

    }
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
