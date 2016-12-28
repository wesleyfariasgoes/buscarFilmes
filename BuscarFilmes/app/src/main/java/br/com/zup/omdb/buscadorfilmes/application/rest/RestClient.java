package br.com.zup.omdb.buscadorfilmes.application.rest;


import br.com.zup.omdb.buscadorfilmes.application.utils.MovieConstants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    protected Retrofit retrofit;
    protected GetMovieApi mApi;

    public RestClient() {
         retrofit  = new Retrofit.Builder()
                .baseUrl(MovieConstants.REST_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        mApi = retrofit.create(GetMovieApi.class);
    }

    public GetMovieApi getApi() {
        return mApi;
    }
}
