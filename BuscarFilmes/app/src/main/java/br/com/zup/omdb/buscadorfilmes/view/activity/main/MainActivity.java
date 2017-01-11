package br.com.zup.omdb.buscadorfilmes.view.activity.main;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import br.com.zup.omdb.buscadorfilmes.R;
import br.com.zup.omdb.buscadorfilmes.application.enums.ControlFrags;
import br.com.zup.omdb.buscadorfilmes.view.fragment.content.ContentFragment;
import br.com.zup.omdb.buscadorfilmes.view.fragment.dashboard.DashBoardFragment;
import br.com.zup.omdb.buscadorfilmes.view.fragment.moviedetail.MovieDetailFragment;
import br.com.zup.omdb.buscadorfilmes.view.fragment.movielist.MovieListFragment;
import br.com.zup.omdb.buscadorfilmes.view.fragment.moviesearch.MovieSearchFragment;
import butterknife.ButterKnife;


public class MainActivity extends AbstractFragmentActivity {
    private TextView                 mTxtEmpty;
    private transient TextView       textLoading;
    private transient View           viewLoadingText;
    private transient View           viewLoading;
    protected BottomNavigationView   bottomNavigationView;
    private Toolbar                  toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
        showDashBoard();

    }


    private void binds() {
//        MovieListFragment fragment = (MovieListFragment) registerFragment(ControlFrags.LIST);
//        replaceFragment(ControlFrags.LIST,false);

//        bottomNavigationView        = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

//        bottomNavigationView        .setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if (item.getItemId() == R.id.list_movie) {
//                    MovieListFragment fragment = (MovieListFragment) registerFragment(ControlFrags.LIST);
//                    replaceFragment(ControlFrags.LIST,false);
//                } else if (item.getItemId() == R.id.search_movie) {
//                    MovieSearchFragment fragment1 = (MovieSearchFragment) registerFragment(ControlFrags.SEARCH);
//                    replaceFragment(ControlFrags.SEARCH,false);
//                }else if (item.getItemId() == R.id.home_movie) {
//                    Toast.makeText(MainActivity.this,"Em construção",Toast.LENGTH_SHORT).show();
//                }
//                return false;
//            }
//        });

    }


    @Override
    public void showMovieDetail() {
        MovieDetailFragment fragment = (MovieDetailFragment) registerFragment(ControlFrags.DETAIL);
        replaceFragment(ControlFrags.DETAIL,true);
    }

    @Override
    public void showContentFrag() {
        ContentFragment fragment = (ContentFragment) registerFragment(ControlFrags.CONTENT);
        replaceFragment(ControlFrags.CONTENT,true);
    }

    @Override
    public void showMovieList() {
        MovieListFragment fragment = (MovieListFragment) registerFragment(ControlFrags.LIST);
        replaceFragment(ControlFrags.LIST,R.id.layout_content_frag,true);
    }

    @Override
    public void showDashBoard() {
        if (fragMan.getBackStackEntryCount() > 0) {
            popBackStackStart();
        }
        DashBoardFragment fragment = (DashBoardFragment) registerFragment(ControlFrags.DASH_BOARD);
        replaceFragment(ControlFrags.DASH_BOARD, false);
    }

    @Override
    public void showMovieSearch() {
        MovieSearchFragment fragment = (MovieSearchFragment) registerFragment(ControlFrags.SEARCH);
        replaceFragment(ControlFrags.SEARCH,R.id.layout_content_frag,true);
    }

    @Override
    public void showLoading(boolean visible) {
//        if (!visible) {
//            viewLoadingText.setVisibility(View.GONE);
//            viewLoading.setVisibility(View.GONE);
//        } else {
//            viewLoading.setVisibility(View.VISIBLE);
//        }
    }
}
