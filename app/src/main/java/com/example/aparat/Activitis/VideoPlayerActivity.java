package com.example.aparat.Activitis;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.aparat.Models.Video;
import com.example.aparat.R;
import com.example.aparat.dao.AppDatabase;
import com.example.aparat.databinding.ActivityVideoPlayerBinding;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;

public class VideoPlayerActivity extends AppCompatActivity {

    Bundle bundle;
    Video video;
    ActivityVideoPlayerBinding binding;
    SimpleExoPlayer player;
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bundle = getIntent().getExtras();
        video = bundle.getParcelable("video");

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        binding.txtTitleVideo.setText(video.getTitle());

        player = new SimpleExoPlayer.Builder(this).build();

        binding.videosVideo.setPlayer(player);
        Uri uri = Uri.parse(video.getLink());
        MediaItem mediaItem = MediaItem.fromUri(uri);

        player.setMediaItem(mediaItem);
        player.setPlayWhenReady(true);
        player.prepare();



        appDatabase = AppDatabase.getInstance(getApplicationContext());

        binding.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long res = appDatabase.dao().insert(video);
                if(res>0){
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        if(player != null){
            player.pause();
            player.stop(true);
        }
    }
}