package com.example.aparat.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aparat.Adapters.VideoAdapter.VideoAdapters;
import com.example.aparat.Models.IMessageListener;
import com.example.aparat.Models.Video;
import com.example.aparat.databinding.FragmentHomeBinding;
import com.example.aparat.webservise.WebServiseCaller;

import java.util.List;


public class HomeFragment extends Fragment {

    WebServiseCaller webServiseCaller;
    FragmentHomeBinding binding;


    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        binding.progressbarNew.setVisibility(View.VISIBLE);
        binding.progressbarSpesial.setVisibility(View.VISIBLE);
        webServiseCaller = new WebServiseCaller();
        webServiseCaller.getnewvideo(new IMessageListener() {
            @Override
            public void OnSuccess(Object responseMessage) {
                binding.progressbarNew.setVisibility(View.GONE);
                binding.recyclerNew.setAdapter(new VideoAdapters(getActivity(),(List<Video>) responseMessage));
                binding.recyclerNew.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
            }

            @Override
            public void OnFailer(String errorResponse) {
                binding.progressbarNew.setVisibility(View.GONE);
            }
        });
        webServiseCaller.getSpecial(new IMessageListener() {
            @Override
            public void OnSuccess(Object responseMessage) {
                binding.progressbarSpesial.setVisibility(View.GONE);
                binding.recyclerSpecial.setAdapter(new VideoAdapters(getActivity(),(List<Video>) responseMessage));
                binding.recyclerSpecial.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));

            }

            @Override
            public void OnFailer(String errorResponse) {
                binding.progressbarSpesial.setVisibility(View.GONE);
            }
        });

        return binding.getRoot();
    }
}