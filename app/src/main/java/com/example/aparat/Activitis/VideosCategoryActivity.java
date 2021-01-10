package com.example.aparat.Activitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.aparat.Adapters.VideoAdapter.VideoAdapters;
import com.example.aparat.Models.Category;
import com.example.aparat.Models.IMessageListener;
import com.example.aparat.Models.Video;
import com.example.aparat.R;
import com.example.aparat.databinding.ActivityVideosCategoryBinding;
import com.example.aparat.webservise.WebServiseCaller;

import java.util.List;

public class VideosCategoryActivity extends AppCompatActivity {
    ActivityVideosCategoryBinding binding;
    Bundle bundle;
    Category category;
    WebServiseCaller webServiseCaller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideosCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        webServiseCaller = new WebServiseCaller();

        bundle = getIntent().getExtras();

        category = bundle.getParcelable("category");


        binding.txtTitleCat.setText(category.getTitle());

        webServiseCaller.getvideocategory(new IMessageListener() {
            @Override
            public void OnSuccess(Object responseMessage) {
                List<Video> videoList = (List<Video>)responseMessage;
                VideoAdapters adapter = new VideoAdapters(getApplicationContext(), videoList);
                binding.recyclerVideoCat.setAdapter(adapter);
                binding.recyclerVideoCat.setLayoutManager(new GridLayoutManager
                        (getApplicationContext(),2));
            }

            @Override
            public void OnFailer(String errorResponse) {

            }
        }, category.getId());



    }
}