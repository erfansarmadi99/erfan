package com.example.aparat.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aparat.Activitis.VideosCategoryActivity;
import com.example.aparat.R;
import com.example.aparat.Models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryVH> {

    Context context ;
    List<Category> categoryList;

    public CategoryAdapter(Context context , List<Category> categoryList) {
        this.context =context;
        this.categoryList =categoryList;

    }

    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.cat_row,null);

        return new CategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {

        Category category = categoryList.get(position);

        holder.txt_title.setText(category.getTitle());

        Picasso.get().load(category.getIcon()).into(holder.img_category);


        holder.card_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context , VideosCategoryActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("category" , category);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class CategoryVH extends  RecyclerView.ViewHolder {

        AppCompatImageView img_category;
        AppCompatTextView txt_title;
        CardView card_category;


        public CategoryVH(@NonNull View itemView) {
            super(itemView);
            img_category= itemView.findViewById(R.id.img_category);
            txt_title= itemView.findViewById(R.id.txt_title);
            card_category= itemView.findViewById(R.id.card_category);
        }
    }
}
