package com.example.demoretrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demoretrofit.R;
import com.example.demoretrofit.model.Content;
import com.example.demoretrofit.model.Example;
import com.example.demoretrofit.model.GetPost;

import java.util.List;

public class AdapterRCVvolleyMain extends RecyclerView.Adapter<AdapterRCVvolleyMain.ViewHolder> {
    List<GetPost> getpostList;
    List<Content> ContentList;
    Context context;

    public AdapterRCVvolleyMain(List<GetPost> getpostList) {

        this.getpostList = getpostList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rcv_detail, viewGroup, false);
        context = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final GetPost getPost = getpostList.get(i);
//        viewHolder.tvId.setText(getPost.getId() + "");
//
//        viewHolder.tvStatus.setText(getPost.getStatus() + "");
//        viewHolder.tvType.setText(getPost.getId() + "");
//        viewHolder.tvTitle.setText(getPost.getTitle().getRendered() + "");


//        Document document = Jsoup.parse(getPost.getGuid().getRendered());
//        Elements elemen = document.select("img");
//
////        Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
////        Matcher matcher = p.matcher(example.getContent().getRendered());
////        List<String> tokens = new ArrayList<>();
////        while (matcher.find()){
////            String token = matcher.group(1);
////            tokens.add(token);
////        }
//
//



    Glide.with(context).load(getPost.getSourceUrl()).placeholder(R.drawable.ic_launcher_foreground).into(viewHolder.postImg);

//

//        viewHolder.cardItemRCV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, VolleyActivityMain.class);
//                intent.putExtra("link", getPost.getLink());
//                intent.putExtra("title", getPost.getTitle().getRendered());
//                intent.putExtra("status", getPost.getStatus());
//                intent.putExtra("date", getPost.getDate());
//                intent.putExtra("dateGmt", getPost.getDateGmt());
//                intent.putExtra("author", getPost.getAuthor()+"");
//
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return getpostList.size();
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
//            tvTitle = itemView.findViewById(R.id.tvTitle);
//            tvType = itemView.findViewById(R.id.tvTyle);
            cardItemRCV = (CardView) itemView.findViewById(R.id.cardItemRCV);
        }
    }

    public void updateData(List<GetPost> getpostList) {
        this.getpostList.addAll(getpostList);
        notifyDataSetChanged();
    }

//    public void clearList() {
//        if (!this.exampleList.isEmpty())
//            this.exampleList.clear();
//    }
}
