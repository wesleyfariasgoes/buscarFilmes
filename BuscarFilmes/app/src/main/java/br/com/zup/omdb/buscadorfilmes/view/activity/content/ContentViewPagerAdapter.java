package br.com.zup.omdb.buscadorfilmes.view.activity.content;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import br.com.zup.omdb.buscadorfilmes.view.fragment.movielist.MovieListFragment;

/**
 * Created by wesleygoes on 23/12/16.
 */

public class ContentViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragmentList =  new ArrayList<>();
    private ArrayList<String> mFragmentListTitles = new ArrayList<>();

    private final String[] mTitles = {"Filmes","Inserir"};

    public ContentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: //BalanceFragment
                return new MovieListFragment();
            case 1: //NextPaymentFragment
                return new MovieListFragment();
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
