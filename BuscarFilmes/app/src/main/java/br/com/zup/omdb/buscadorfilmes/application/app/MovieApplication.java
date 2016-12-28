package br.com.zup.omdb.buscadorfilmes.application.app;

import android.app.Application;
import android.content.Context;

import java.util.HashMap;

import br.com.zup.omdb.buscadorfilmes.business.AmbienteManager;

/**
 * Created by wesleygoes on 24/12/16.
 */

public class MovieApplication extends Application {
    private static MovieApplication singleton = null;
    private HashMap<String, Object> attributes = new HashMap<String, Object>();
    private final String OMDB = "OMDB";

    public static MovieApplication getInstance() {
        return singleton;
    }

    public MovieApplication() {
        singleton = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AmbienteManager ambienteManager = AmbienteManager.getInstance();
        ambienteManager.startSession( getApplicationContext() );
        put(AmbienteManager.KEY, ambienteManager);
        singleton = this;

    }

    public Context getContext(){
        return getApplicationContext();
    }

    public void setAttributes(HashMap<String, Object> attributes) {
        this.attributes = attributes;
    }

    public HashMap<String, Object> getAttributes() {
        return attributes;
    }

    public void put(final String key, final Object value) {
        this.attributes.put(key, value);
    }

    public Object get(final String key) {
        return this.attributes.get(key);
    }

}

