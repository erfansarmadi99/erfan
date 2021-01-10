package com.example.aparat.Adapters.VideoAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.aparat.Activitis.VideoPlayerActivity;
import com.example.aparat.Models.Video;
import com.example.aparat.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoAdapters extends RecyclerView.Adapter<VideoAdaptersViewHolder> {
    Context context;
    List<Video> videoList;
    public VideoAdapters( Context context,List<Video> videoList){
        this.context = context;
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public VideoAdaptersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_rows,null);
        return new VideoAdaptersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdaptersViewHolder holder, int position) {
        Video video = videoList.get(position);
        holder.txt_title.setText(video.getTitle());
        Picasso.get().load(video.getIcon()).into(holder.img_icon);

        holder.card_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VideoPlayerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("video",video);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}
