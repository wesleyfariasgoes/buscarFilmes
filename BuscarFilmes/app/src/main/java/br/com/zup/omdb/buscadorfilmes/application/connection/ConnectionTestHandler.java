package br.com.zup.omdb.buscadorfilmes.application.connection;

import android.os.Handler;
import android.os.Message;

import br.com.zup.omdb.buscadorfilmes.application.connection.listener.OnConnectionTestListener;


/**
 * 
 * Handler used to test Connection.
 * 
 * @author 
 *
 */
public class ConnectionTestHandler extends Handler {

	private final transient OnConnectionTestListener listener;

	/**
	 * Constructor
	 * 
	 * @param listener
	 */
	public ConnectionTestHandler(final OnConnectionTestListener listener) {
		super();
		this.listener = listener;
	}
	
	/**
	 * Constructor
	 * 
	 * @param listener
	 */

	/**
	 * @param msg
	 */
	@Override
	public void handleMessage(final Message msg) {
		boolean result;
		if (msg.what != 1) {
			result = false;
	    } else {
	    	result = true;
	    }
		listener.endConnectionTest(result);
	}

}