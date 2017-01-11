package br.com.zup.omdb.buscadorfilmes.application.enums;

import java.io.Serializable;

import br.com.zup.omdb.buscadorfilmes.view.fragment.AbstractFragment;
import br.com.zup.omdb.buscadorfilmes.view.fragment.content.ContentFragment;
import br.com.zup.omdb.buscadorfilmes.view.fragment.dashboard.DashBoardFragment;
import br.com.zup.omdb.buscadorfilmes.view.fragment.moviedetail.MovieDetailFragment;
import br.com.zup.omdb.buscadorfilmes.view.fragment.movielist.MovieListFragment;
import br.com.zup.omdb.buscadorfilmes.view.fragment.moviesearch.MovieSearchFragment;


public enum ControlFrags implements Serializable {

	CONTENT     (ContentFragment.class),
	DASH_BOARD  (DashBoardFragment.class),
	DETAIL      (MovieDetailFragment.class),
	LIST        (MovieListFragment.class),
	SEARCH      (MovieSearchFragment.class);

	private final Class<? extends AbstractFragment> classFrag;

	ControlFrags(final Class<? extends AbstractFragment> classFrag) {
		this.classFrag = classFrag;
	}



	public String getName() {
		return classFrag.getSimpleName();
	}
	public Class<? extends AbstractFragment> getClassFrag() {
		return classFrag;
	}
}
