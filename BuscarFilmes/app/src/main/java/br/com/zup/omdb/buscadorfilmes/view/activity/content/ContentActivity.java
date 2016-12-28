package br.com.zup.omdb.buscadorfilmes.view.activity.content;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.zup.omdb.buscadorfilmes.R;


/**
 * Created by wesleygoes on 23/12/16.
 */

public class ContentActivity extends AppCompatActivity  {

    private Toolbar toolbar;
    private ViewPager mViewpager;
    private TabLayout    mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Filmes OMDb");
        setSupportActionBar(toolbar);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewpager.setAdapter(new ContentViewPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewpager);

        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_done_black_24dp);
    }

}
