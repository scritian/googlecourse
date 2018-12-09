package com.scritian.googlecourse;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private ArrayList<Movie> mDataset;
    private AdapterIemClickListener onItemClickListener;

    public MoviesAdapter(ArrayList<Movie> mDataset, AdapterIemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
        this.mDataset=mDataset;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class MovieViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvMovieName;
        public TextView tvMovieGenre;
        public RatingBar rbMovieRating;
        public ImageView ivMovieIcon;

        public MovieViewHolder(View view){
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view, getAdapterPosition());
                }
            });
            tvMovieName = view.findViewById(R.id.tv_movieName);
            tvMovieGenre = view.findViewById(R.id.tv_movieGenre);
            rbMovieRating = view.findViewById(R.id.rb_movieRating);
            ivMovieIcon = view.findViewById(R.id.iv_movieIcon);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MoviesAdapter(ArrayList<Movie> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        RelativeLayout rlMovieItemContainer = (RelativeLayout) LayoutInflater.
                from(parent.getContext())
                .inflate(R.layout.list_item_movie, parent, false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(rlMovieItemContainer);
        return movieViewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Movie movie = mDataset.get(position);
        holder.tvMovieName.setText(movie.getName());
        holder.tvMovieGenre.setText(movie.getGenre());
        holder.rbMovieRating.setRating(movie.getRating());

        switch (movie.getPhotoBase64()) {
            case "AVENGERS_INFINITE":
                holder.ivMovieIcon.setImageResource(R.drawable.avengers_infinite);
                break;
            case "SPIRITED_AWAY":
                holder.ivMovieIcon.setImageResource(R.drawable.spirited_away);
                break;
            case "DEPARTED":
                holder.ivMovieIcon.setImageResource(R.drawable.the_departed);
                break;
            case "INTERSTELLAR":
                holder.ivMovieIcon.setImageResource(R.drawable.interstellar);
                break;
            case "INCEPTION":
                holder.ivMovieIcon.setImageResource(R.drawable.inception);
                break;
            default:
                holder.ivMovieIcon.setImageBitmap(decodeImageFromString(movie.getPhotoBase64()));
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    private Bitmap decodeImageFromString(String base64) {
        byte[] decodedString = Base64.decode(base64, Base64.DEFAULT);
        Bitmap decodedByte =
                BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }
}