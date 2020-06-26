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
    //private ItemClickListener mClickListener;

    // data is passed into the constructor
    MovieRecyclerViewAdapter(Context context, List<MovieModel> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.movie_item_view, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemBind(position);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private ImageView image;
        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movieItemViewTextView);
            image = itemView.findViewById(R.id.movieItemViewImageView);
        }

        public void itemBind(int position){
            title.setText(mData.get(position).getTitle());
            Picasso.get().load("https://image.tmdb.org/t/p/w500"+mData.get(position).getImage()).into(image);
        }
        @Override
        public void onClick(View view) {
           // if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
//    String getItem(int id) {
//        return mData.get(id);
//    }

    // allows clicks events to be caught
//    void setClickListener(ItemClickListener itemClickListener) {
//        this.mClickListener = itemClickListener;
//    }

    // parent activity will implement this method to respond to click events
//    public interface ItemClickListener {
//        void onItemClick(View view, int position);
//    }
}
