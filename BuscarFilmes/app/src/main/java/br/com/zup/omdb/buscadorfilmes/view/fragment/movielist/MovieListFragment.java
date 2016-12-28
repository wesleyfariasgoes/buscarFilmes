package br.com.zup.omdb.buscadorfilmes.view.fragment.movielist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.zup.omdb.buscadorfilmes.R;
import br.com.zup.omdb.buscadorfilmes.application.rest.RestClient;
import br.com.zup.omdb.buscadorfilmes.application.utils.WrapperLog;
import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;
import br.com.zup.omdb.buscadorfilmes.model.facade.MovieBO;
import br.com.zup.omdb.buscadorfilmes.presenter.business.movielist.MovieListPresenter;
import br.com.zup.omdb.buscadorfilmes.presenter.business.movielist.OnListMoviePresenter;
import br.com.zup.omdb.buscadorfilmes.view.activity.main.MainActivity;
import br.com.zup.omdb.buscadorfilmes.view.fragment.AbstractFragment;
import br.com.zup.omdb.buscadorfilmes.view.fragment.moviedetail.MovieDetailActivity;
import cn.refactor.lib.colordialog.PromptDialog;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wesleygoes on 23/12/16.
 */

public class MovieListFragment extends AbstractFragment implements OnMovieListFragment {

    private RecyclerView            recyclerView;
    private TextView                mTxtEmpty;
    private OnListMoviePresenter    presenter;
    private RestClient              mRestClient;
    RecyclerView.LayoutManager      layoutManager;
    RecyclerView.Adapter            adapter;
    private List<Movie>             moviesList;
    private Movie                   moviess;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView             = inflater.inflate(R.layout.fragment_movie_list, (ViewGroup) null);
        moviess              = MovieBO.getInstance().getMovieSelection();
        mRestClient          = new RestClient();
        moviesList           = MovieBO.getInstance().getMovies();
        onBackPress(null);
        binds(rootView);
        return rootView;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void binds(View view) {

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_list);
        layoutManager = new LinearLayoutManager(getActivity());
        mTxtEmpty = (TextView) view.findViewById(R.id.txt_empty);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnItemTouchListener(new MovieListPresenter(getActivity(), recyclerView, this));
        presenter = new MovieListPresenter(getActivity(), recyclerView, this);
        mTxtEmpty.setVisibility(View.GONE);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void replaceFragment(int position) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void setItems(final List<Movie> movies) {
        if (movies.isEmpty() || movies == null) {
            mTxtEmpty.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setAdapter(new ListMovieAdapter(getActivity(), movies, getActivity(), this));
            mTxtEmpty.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClickListener(View view, int position) {

    }

    @Override
    public void upDateList(final Movie movie, final String title) {

            final ProgressDialog dialog = ProgressDialog.show(getActivity(), "", "carregando...");
            Call<Movie> call = mRestClient.getApi().getMovie(movie.getTitle().toString().trim(), "sort", "json");
            call.enqueue(new Callback<Movie>() {
                @Override
                public void onResponse(Call<Movie> call, Response<Movie> response) {
                    Movie inputMovie = response.body();
                    dialog.dismiss();
                    if (inputMovie == null) {

                        ResponseBody responseBody = response.errorBody();
                        if (responseBody != null) {
                            WrapperLog.info("RESPONSE 1" + responseBody);
                        } else {
                            WrapperLog.info("RESPONSE 2" + responseBody);
                        }
                    } else {
                        if (inputMovie.getResponse() != null && inputMovie.getResponse().equalsIgnoreCase("True")) {
                            Movie item = new Movie();
                            item.setId(movie.getId());
                            item.setTitle(movie.getTitle());
                            item.setActors(inputMovie.getActors());
                            item.setDirector(inputMovie.getDirector());
                            item.setGenre(inputMovie.getGenre());
                            item.setPlot(inputMovie.getPlot());
                            item.setAwards(inputMovie.getAwards());
                            item.setImdbID(inputMovie.getImdbID());
                            item.setRuntime(inputMovie.getRuntime());
                            item.setRated(inputMovie.getRated());
                            item.setReleased(inputMovie.getReleased());
                            item.setLanguage(inputMovie.getLanguage());
                            item.setCountry(inputMovie.getCountry());
                            item.setMetascore(inputMovie.getMetascore());
                            item.setWriter(inputMovie.getWriter());
                            item.setYear(inputMovie.getYear());
                            item.setPoster(inputMovie.getPoster());
                            item.setType(inputMovie.getType());

                            MovieBO.getInstance().addFilmes(item);

                        } else {
//                        Message.showAlertCrouton(getActivity(),"Filme "+movie.getTitle()+" não encontrado.");
                        }

                    }
                }

                @Override
                public void onFailure(Call<Movie> call, Throwable t) {
                    dialog.dismiss();
                }

            });

    }

    @Override
    public void onSetItemMovie(Movie itemMovie) {
        MovieBO.getInstance().setMovieSelection(itemMovie);
//        ((MainActivity)getActivity()).showMovieDetail();
        Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public void setTransfer() {
        Intent negativeActivity = new Intent(getActivity(), MainActivity.class);
        startActivity(negativeActivity);
    }

    @Override
    public void setDeleteButton(final Movie movie) {
        WrapperLog.info("DELETE " + movie.getTitle());
        new PromptDialog(getActivity())
                .setDialogType(PromptDialog.DIALOG_TYPE_WARNING)
                .setAnimationEnable(true)
                .setTitleText(getString(R.string.operation))
                .setContentText(getString(R.string.text))
                .setPositiveListener(getString(R.string.ok), new PromptDialog.OnPositiveListener() {
                    @Override
                    public void onClick(PromptDialog dialog) {
                        dialog.dismiss();
                        presenter.onDelete(movie);
                        setTransfer();
                    }
                }).show();


    }



}
