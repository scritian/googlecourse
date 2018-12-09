package com.scritian.googlecourse;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MovieActivity extends AppCompatActivity {

    private TextView tvLinkIMDB;
    private TextView tvMovieName,tvDescription, tvmovieGenre;
    private RatingBar rbMovieRating;
    private ImageView ivMovieIcon;
    String movieName;
    String movieDescription;
    String movieGenre;
    float movieRating;
    String moviePhotoBase64;
    String movieIMDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        tvLinkIMDB=findViewById(R.id.tvLinkIMDB);

        Bundle bundle=getIntent().getExtras();

        try{
            movieName=bundle.getString(Constants.Movie_Name);
            movieGenre=bundle.getString(Constants.Movie_Genre);
            moviePhotoBase64=bundle.getString(Constants.Movie_PhotoBase64);
            movieRating=bundle.getFloat(Constants.Movie_Rating);
            movieDescription=bundle.getString(Constants.Movie_Description);
            movieIMDB=bundle.getString(Constants.Movie_IMDB);
        } catch(Exception ex) {
            ex.printStackTrace();
            Toast.makeText(MovieActivity.this, "Error!", Toast.LENGTH_LONG).show();
        }

        tvDescription=findViewById(R.id.tvMovieDescription);
        tvMovieName=findViewById(R.id.tvMovieName);
        tvmovieGenre=findViewById(R.id.tvGenre);
        rbMovieRating=findViewById(R.id.rbMovieRating);
        ivMovieIcon=findViewById(R.id.ivMoviePoster);

        tvMovieName.setText(movieName);
        tvDescription.setText(movieDescription);
        tvmovieGenre.setText(movieGenre);
        rbMovieRating.setRating(movieRating);
        ivMovieIcon.setImageBitmap(decodeImageFromString(moviePhotoBase64));
        Constants.Movie_IMDB = movieIMDB;

        tvLinkIMDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MovieActivity.this, WebViewActivity.class));
            }
        });
    }
    private Bitmap decodeImageFromString(String base64) {
        byte[] decodedString = Base64.decode(base64, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
}
