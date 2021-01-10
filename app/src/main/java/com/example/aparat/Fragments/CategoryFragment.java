package com.example.aparat.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.aparat.Adapters.CategoryAdapter;
import com.example.aparat.Models.Category;
import com.example.aparat.Models.IMessageListener;
import com.example.aparat.R;
import com.example.aparat.databinding.FragmentCategoryBinding;
import com.example.aparat.webservise.WebServiseCaller;

import java.util.List;


public class CategoryFragment extends Fragment {

    WebServiseCaller webServiseCaller;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    FragmentCategoryBinding binding;
    public CategoryFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        progressBar = view.findViewById(R.id.porogress);

        recyclerView = view.findViewById(R.id.recycler_categories);
        progressBar.setVisibility(View.VISIBLE);
        webServiseCaller = new WebServiseCaller();
        webServiseCaller.getcategory(new IMessageListener() {
            @Override
            public void OnSuccess(Object responseMessage) {
                progressBar.setVisibility(View.GONE);
                List<Category> categoryList =  (List<Category>) responseMessage;

                CategoryAdapter adapter=new CategoryAdapter(getActivity(), categoryList);

                recyclerView.setAdapter(adapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()
                        ,RecyclerView.VERTICAL,false));
            }

            @Override
            public void OnFailer(String errorResponse) {

            }
        });




        return view;
    }
}