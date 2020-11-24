package com.example.firebasedatabaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    ScaleAnimation shrinkAnim;
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager layoutManager;
    private FirebaseRecyclerAdapter<Movie,MovieViewHolder> adapter;
    private TextView tvNoMovies;

    private DatabaseReference movieReference;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private static final String userId = "53";
    public static String idMovies = "idMovies";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        tvNoMovies = (TextView)findViewById(R.id.tv_no_movie);

        shrinkAnim = new ScaleAnimation(1.15f,0f,1.15f,0f, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        if(recyclerView != null)
        {
            recyclerView.setHasFixedSize(true);
        }

        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        movieReference = FirebaseDatabase.getInstance().getReference().child("users").child(userId).child("movies");
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        FirebaseRecyclerOptions<Movie> options = new FirebaseRecyclerOptions.Builder<Movie>().setQuery(movieReference,Movie.class).build();

        FirebaseRecyclerAdapter<Movie,MovieViewHolder> adapter = new FirebaseRecyclerAdapter<Movie, MovieViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MovieViewHolder holder, int psotion, @NonNull)
        }

    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView tvMovieName;
        RatingBar ratingBar;
        ImageView ivMoviePoster;
        ImageButton eliminar;
        ImageButton modificar;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMovieName = (TextView)itemView.findViewById(R.id.tv_name);
            ratingBar = (RatingBar)itemView.findViewById(R.id.rating_bar);
            ivMoviePoster = (ImageView)itemView.findViewById(R.id.movie_poster)}
    }
}