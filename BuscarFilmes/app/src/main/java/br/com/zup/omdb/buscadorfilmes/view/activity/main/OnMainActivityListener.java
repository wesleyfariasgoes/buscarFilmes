package br.com.zup.omdb.buscadorfilmes.view.activity.main;


import android.os.Bundle;

import br.com.zup.omdb.buscadorfilmes.application.enums.ControlFrags;
import br.com.zup.omdb.buscadorfilmes.view.fragment.AbstractFragment;

public interface OnMainActivityListener {

    String lastFragmentName();
    String recentFragmentName();
    void popBackStack(ControlFrags frags);
    void popBackStack();
    void showMovieDetail();
    void showMovieList();
    void showPutMovieList(Bundle args);
    void showMovieSearch();
    void showLoading(final boolean visible);
    AbstractFragment getAFragment(ControlFrags frag);


}
