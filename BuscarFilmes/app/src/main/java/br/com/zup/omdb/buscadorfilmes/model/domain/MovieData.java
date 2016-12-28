
package br.com.zup.omdb.buscadorfilmes.model.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class MovieData {

    @SerializedName("movies")
    @Expose
    private List<Movie> movies = new ArrayList<Movie>();

    /**
     * 
     * @return
     *     The movies
     */
    public List<Movie> getCursos() {
        return movies;
    }

    /**
     * 
     * @param movies
     *     The movies
     */
    public void setCursos(List<Movie> movies) {
        this.movies = movies;
    }

}
