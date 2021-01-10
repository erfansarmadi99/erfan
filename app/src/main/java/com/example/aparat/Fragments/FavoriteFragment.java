package com.example.aparat.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.aparat.Adapters.VideoAdapter.VideoAdapters;
import com.example.aparat.Models.Video;
import com.example.aparat.R;
import com.example.aparat.dao.AppDatabase;
import com.example.aparat.databinding.FragmentFavoriteBinding;
import com.example.aparat.databinding.FragmentHomeBinding;

import java.util.List;

public class FavoriteFragment extends Fragment {

FragmentFavoriteBinding binding;
AppDatabase appDatabase;

    public FavoriteFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(getLayoutInflater());

        appDatabase = AppDatabase.getInstance(getActivity());


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Video> videoList = appDatabase.dao().getVideoList();
        VideoAdapters adapters =new VideoAdapters(getActivity(),videoList);

        binding.recyclerFavorite.setAdapter(adapters);

        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);

        binding.recyclerFavorite.setLayoutManager(manager);
    }
}