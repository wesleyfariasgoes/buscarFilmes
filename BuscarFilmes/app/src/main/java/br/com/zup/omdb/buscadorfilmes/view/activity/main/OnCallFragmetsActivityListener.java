package br.com.zup.omdb.buscadorfilmes.view.activity.main;


import br.com.zup.omdb.buscadorfilmes.application.enums.ControlFrags;

public interface OnCallFragmetsActivityListener {
	boolean replaceFragment(final ControlFrags frag, final int resId);
	boolean replaceFragment(final ControlFrags frag, final int resId, final boolean addBackStack);
	void replaceFragment(final ControlFrags frag, final boolean addBackStack);
	boolean replaceFragment(final ControlFrags frag, final int resId, final boolean addBackStack, final Integer animResIdEnter, final Integer animResIdExit);

}
