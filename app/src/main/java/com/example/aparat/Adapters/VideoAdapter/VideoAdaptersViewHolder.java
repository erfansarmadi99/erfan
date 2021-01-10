package com.example.aparat.Adapters.VideoAdapter;

import android.view.View;

import com.example.aparat.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class VideoAdaptersViewHolder extends RecyclerView.ViewHolder {

    AppCompatTextView txt_title;
    AppCompatImageView img_icon;
    CardView card_video;
    public VideoAdaptersViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_title = itemView.findViewById(R.id.txt_title);
        img_icon = itemView.findViewById(R.id.img_icon);
        card_video = itemView.findViewById(R.id.card_video);
    }
}
