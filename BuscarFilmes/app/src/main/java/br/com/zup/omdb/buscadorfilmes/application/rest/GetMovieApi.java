package br.com.zup.omdb.buscadorfilmes.application.rest;

import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;


public  interface GetMovieApi {

    //List Tax
    @GET("/")
    Call<Movie> getMovie(@Query("t") String q, @Query("plot") String sort, @Query("r") String type);

    @GET("/")
    void getMovies(@Query("t") String q, @Query("plot") String sort, @Query("r") String type, Callback<Movie> cb);
}
