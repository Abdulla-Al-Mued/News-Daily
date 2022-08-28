package com.example.newsdaily.View.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsdaily.R;
import com.example.newsdaily.Service.Model.Article;
import com.example.newsdaily.View.Ui.NewsDetails;

import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context ctx;
    private List<Article> articleList;

    public NewsAdapter(Context ctx, List<Article> articleList) {
        this.ctx = ctx;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.news_single_row, null, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {

        /*holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, NewsDetails.class);
                intent.putExtra("url", articleList.get(position).getUrl());
                ctx.startActivity(intent);

            }
        });*/

        holder.time.setText("Published At: "+articleList.get(position).getPublishedAt());
        holder.author.setText(articleList.get(position).getAuthor());
        holder.heading.setText(articleList.get(position).getTitle());
        holder.content.setText(articleList.get(position).getContent());
        Glide.with(ctx).load(articleList.get(position).getUrlToImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView heading, content, author, time;
        CardView cardView;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            heading = itemView.findViewById(R.id.heading);
            content = itemView.findViewById(R.id.content);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.publish_date);
            cardView = itemView.findViewById(R.id.cardView);
            image = itemView.findViewById(R.id.news_image);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            Article news = articleList.get(getAdapterPosition());
            Intent intent = new Intent(ctx, NewsDetails.class);
            intent.putExtra("News", news);
            ctx.startActivity(intent);

        }
    }
}
