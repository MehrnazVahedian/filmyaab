package com.example.film_yab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieRecyclerViewAdapter extends  RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>{
    private List<MovieModel> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    MovieRecyclerViewAdapter(Context context, List<MovieModel> data, ItemClickListener itemClickListener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mClickListener = itemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.movie_item_view, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemBind(position);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView image;
        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movieItemViewTextView);
            image = itemView.findViewById(R.id.movieItemViewImageView);
        }

        void itemBind(final int position){
            //title.setText(mData.get(position).getTitle());
            Picasso.get().load("https://image.tmdb.org/t/p/w500"+mData.get(position).getImage()).fit().into(image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    mClickListener.onItemClick(mData.get(position));
                }
            });
        }
    }

    public interface ItemClickListener {
        void onItemClick(MovieModel model);
    }
}
