package com.gookkis.realmtutorial.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gookkis.realmtutorial.R;
import com.gookkis.realmtutorial.model.ArticleModel;

import java.util.ArrayList;

public class AdapterArticle extends RecyclerView.Adapter<AdapterArticle.ViewHolder> {


    private final OnItemClickListener listener;
    private ArrayList<ArticleModel> article;


    public AdapterArticle(ArrayList<ArticleModel> article, OnItemClickListener listener) {
        this.article = article;
        this.listener = listener;
    }


    @Override
    public AdapterArticle.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(AdapterArticle.ViewHolder holder, int position) {
        holder.click(article.get(position), listener);
        holder.tvId.setText(String.valueOf(article.get(position).getId()));
        holder.title.setText(article.get(position).getTitle());
        holder.description.setText(article.get(position).getDescription());
    }


    @Override
    public int getItemCount() {
        return article.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, title, description;


        public ViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            description = (TextView) itemView.findViewById(R.id.tvDescription);
        }


        public void click(final ArticleModel articleModel, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(articleModel);
                }
            });
        }
    }


    public interface OnItemClickListener {
        void onClick(ArticleModel item);
    }


} 
