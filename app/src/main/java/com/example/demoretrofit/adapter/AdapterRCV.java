package com.example.demoretrofit.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.demoretrofit.MainActivityMain;
import com.example.demoretrofit.R;
import com.example.demoretrofit.model.Content;
import com.example.demoretrofit.model.Example;


import java.util.List;


public class AdapterRCV extends RecyclerView.Adapter<AdapterRCV.ViewHolder> {
    List<Example> exampleList;
    List<Content> ContentList;
    Context context;

    public AdapterRCV(List<Example> exampleList) {

        this.exampleList = exampleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rcv, viewGroup, false);
        context = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Example example = exampleList.get(i);


//
//        Document document = Jsoup.parse(example.getContent().getRendered());
//        Elements elemen = document.select("img");

//        Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
//        Matcher matcher = p.matcher(example.getEmbedded().getWpFeaturedmedia().get(0).getMediaDetails().);
//        List<String> tokens = new ArrayList<>();
//        while (matcher.find()){
//            String token = matcher.group(1);
//            tokens.add(token);
//        }



        Glide.with(context).load(example.getEmbedded().getWpFeaturedmedia().get(0).getSourceUrl()).placeholder(R.drawable.ic_launcher_foreground).into(viewHolder.postImg);



        viewHolder.cardItemRCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivityMain.class);

//                intent.putExtra("link", example.getLink());
//                intent.putExtra("title", example.getTitle().getRendered());
//                intent.putExtra("status", example.getStatus());
//                intent.putExtra("date", example.getDate());
//                intent.putExtra("dateGmt", example.getDateGmt());
//                intent.putExtra("author", example.getAuthor()+"");
//                intent.putExtra("featured_media", example.getFeaturedMedia()+"");
//                intent.putExtra("sticky", example.getSticky()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId;
        private TextView tvTitle;
        private TextView tvType;
        private TextView tvStatus;
        private CardView cardItemRCV;
        private ImageView postImg;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            postImg = (ImageView) itemView.findViewById(R.id.postImg);

            cardItemRCV = (CardView) itemView.findViewById(R.id.cardItemRCV);
        }
    }

    public void updateData(List<Example> exampleList) {
        this.exampleList.addAll(exampleList);
        notifyDataSetChanged();
    }

//    public void clearList() {
//        if (!this.exampleList.isEmpty())
//            this.exampleList.clear();
//    }
}
