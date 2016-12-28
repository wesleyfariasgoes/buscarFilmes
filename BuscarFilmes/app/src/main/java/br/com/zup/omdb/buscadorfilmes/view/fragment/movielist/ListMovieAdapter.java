package br.com.zup.omdb.buscadorfilmes.view.fragment.movielist;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import br.com.zup.omdb.buscadorfilmes.R;
import br.com.zup.omdb.buscadorfilmes.model.domain.Movie;


public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ViewHolder> {

    private List<Movie> mMovies;
    private OnMovieListFragment fragment;
    private Context context;
    private Activity activity;


    public ListMovieAdapter(Context context, List<Movie> movies, Activity activity,MovieListFragment movieListFragment) {
        this.mMovies = movies;
        this.context = context;
        this.fragment = movieListFragment;
        this.activity = activity;
    }

    public ListMovieAdapter(FragmentActivity activity, FragmentActivity activity1, MovieListFragment movieListFragment) {
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Movie movie = mMovies.get(position);
        holder.mItemTitle.setText(movie.getTitle());
        holder.mItemDetail.setText(movie.getDirector());

        if(movie.getDirector()==null || movie.getDirector().isEmpty()){
            fragment.upDateList(movie,movie.getTitle());
        }

        holder.itemImageTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.setDeleteButton(mMovies.get(position));
            }
        });

//        if (mMovies.get(position).getPoster() == null) {
//            holder.mImgTouch.setVisibility(View.VISIBLE);
//            WrapperLog.info("VISIBLE");
//        } else {
//            holder.mImgTouch.setVisibility(View.GONE);
//            WrapperLog.info("GONE");
//        }
        Glide.with(activity).load(mMovies.get(position).getPoster())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.itemImage);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mMovies) {
                    fragment.onSetItemMovie(mMovies.get(position));
                }

            }

        });
    }


    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mItemTitle;
        public final TextView mItemDetail;
        public final ImageView itemImage,itemImageTrash;

        public ViewHolder(View view) {
            super(view);
            mView           = view;
            mItemTitle      = (TextView) view.findViewById(R.id.item_title);
            mItemDetail     = (TextView) view.findViewById(R.id.item_detail);
            itemImage       = (ImageView) view.findViewById(R.id.img_poster);
            itemImageTrash  = (ImageView) view.findViewById(R.id.imageButton);

            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
//                    Snackbar.make(view,"Posição: "+position,Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                }
            });

        }


    }
}
