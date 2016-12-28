package br.com.zup.omdb.buscadorfilmes.application.connection.listener;


public interface OnConnectionTestListener {

	/**
	 * Finish the progress Dialog
	 * 
	 * @param connection Boolean
	 */
	void endConnectionTest(final Boolean connection);
}
