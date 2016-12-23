package br.com.zup.omdb.buscadorfilmes.view.fragment.movielist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.zup.omdb.buscadorfilmes.R;


public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ViewHolder> {
    //
//    private final List<DummyItem> mValues;
//    private final OnListFragmentInteractionListener mListener;

    public OnMovieListFragment fragment;
    private String[] titles = {
            "Dell",
            "Facebook",
            "Hewlett Packard"

    };

    private String[] details = {
            "Detalhe Item um",
            "Detalhe Item dois",
            "Detalhe Item três",

    };

    private int[] images = {
            R.drawable.dell,
            R.drawable.facebook,
            R.drawable.hewlett_packard

    };

    public ListMovieAdapter(OnMovieListFragment listContatoFragment) {
        this.fragment = listContatoFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        holder.mItemTitle.setText(mValues.get(position).id);
//        holder.mContentView.setText(mValues.get(position).content);
        holder.mItemTitle.setText(titles[position]);
        holder.mItemDetail.setText(details[position]);
        holder.itemImage.setImageResource(images[position]);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }

            }

        });
    }


    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mItemTitle;
        public final TextView mItemDetail;
        public final ImageView itemImage;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mItemTitle = (TextView) view.findViewById(R.id.item_title);
            mItemDetail = (TextView) view.findViewById(R.id.item_detail);
            itemImage = (ImageView) view.findViewById(R.id.item_image);

            itemImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
//                    Snackbar.make(view,"Posição: "+position,Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                    fragment.replaceFragment(position);

                }
            });

        }


    }
}
