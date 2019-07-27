package com.example.demoretrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demoretrofit.R;
import com.example.demoretrofit.model.Categories;
import com.example.demoretrofit.model.Example;
import com.example.demoretrofit.model.GetPost;

import java.util.ArrayList;
import java.util.List;

public class AdapterRCVcate extends RecyclerView.Adapter<AdapterRCVcate.ViewHolder> {


    List<Categories> categories;
    private Context context;



    public AdapterRCVcate(List<Categories> categories) {

        this.categories = categories;
    }
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rcv_cate,viewGroup,false);
        context = viewGroup.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

         final Categories categories = new Categories();

         viewHolder.tvTitle.setText(categories.getName()+"");
         viewHolder.tVCount.setText(categories.getCount() +"");

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle,tVCount;
        public ViewHolder(@NonNull View itemView) {


            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tVCount = itemView.findViewById(R.id.tvCount);

        }
    }
    public void updateData(List<Categories> categories) {
        this.categories.addAll(categories);
        notifyDataSetChanged();
    }
}
