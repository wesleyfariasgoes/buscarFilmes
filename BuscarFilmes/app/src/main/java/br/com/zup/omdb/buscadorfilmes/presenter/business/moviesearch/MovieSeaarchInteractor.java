package br.com.zup.omdb.buscadorfilmes.presenter.business.moviesearch;

import br.com.zup.omdb.buscadorfilmes.application.rest.RestClient;
import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;
import br.com.zup.omdb.buscadorfilmes.model.facade.MovieBO;

/**
 * Created by wesleygoes on 24/12/16.
 */

public class MovieSeaarchInteractor implements OnSearchInteractor{
    private RestClient mRestClient;
    private Movie movie;
    @Override
    public void insert(final String title, OnFinishSearchListener listener) {
        movie = new Movie();
        movie.setTitle(title);
        MovieBO.getInstance().addFilmes(movie);
//        mRestClient         = new RestClient();
//        Call<Movie> call =mRestClient.getApi().getMovie(movie.getTitle().toString().trim(), "sort", "json");
//        call.enqueue(new Callback<Movie>() {
//            @Override
//            public void onResponse(Call<Movie> call, Response<Movie> response) {
//                Movie sucessJSON = response.body();
//                if (sucessJSON == null) {
//
//                    ResponseBody responseBody = response.errorBody();
//                    if (responseBody != null) {
////                        Toast.makeText(getContext(), "responseBody:" + responseBody, Toast.LENGTH_SHORT).show();
//                        //                            Toast.makeText(getContext(), "responseBody = " + responseBody.string(), Toast.LENGTH_SHORT).show();
//                    } else {
////                        Toast.makeText(getContext(), "responseBody = " + responseBody, Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    if (sucessJSON.getResponse() != null && sucessJSON.getResponse().equalsIgnoreCase("True")){
//                        Movie item = new Movie();
//                        item.setId(movie.getId());
//                        item.setTitle(movie.getTitle());
//                        item.setActors(sucessJSON.getActors());
//                        item.setDirector(sucessJSON.getDirector());
//                        item.setGenre(sucessJSON.getGenre());
//                        item.setPlot(sucessJSON.getPlot());
//                        item.setAwards(sucessJSON.getAwards());
//                        item.setImdbID(sucessJSON.getImdbID());
//                        item.setRuntime(sucessJSON.getRuntime());
//                        item.setRated(sucessJSON.getRated());
//                        item.setReleased(sucessJSON.getReleased());
//                        item.setLanguage(sucessJSON.getLanguage());
//                        item.setCountry(sucessJSON.getCountry());
//                        item.setMetascore(sucessJSON.getMetascore());
//                        item.setWriter(sucessJSON.getWriter());
//                        item.setYear(sucessJSON.getYear());
//                        item.setPoster(sucessJSON.getPoster());
//                        item.setType(sucessJSON.getType());
//
//
//                        MovieBO.getInstance().addFilmes(item);
//
//
//
//                        Log.i("desafio", "desafio.onSuccess - " + String.valueOf(sucessJSON.getImdbID()));
//                    }else{
/////                        Toast.makeText(getContext(), "Filme "+filmes.getTitle()+" não encontrado.", Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Movie> call, Throwable t) {
//                //repositoryView.showProgressBar(View.GONE);
////                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//
//        });
        }




    }

