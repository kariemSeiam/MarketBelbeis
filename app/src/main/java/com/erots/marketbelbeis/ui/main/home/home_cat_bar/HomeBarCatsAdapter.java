package com.erots.marketbelbeis.ui.main.home.home_cat_bar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.erots.marketbelbeis.R;

import java.util.List;

public class HomeBarCatsAdapter extends RecyclerView.Adapter<HomeBarCatsAdapter.HomeBarCatsViewHolder> {

    private final List<HomeBarCatsModel> models;
    Context context;
    private HomeBarCatsInterfaceOnClick homeBarCatsInterfaceOnClick;

    public HomeBarCatsAdapter(List<HomeBarCatsModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeBarCatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_home_category, parent, false);
        return new HomeBarCatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeBarCatsViewHolder holder, int position) {
        HomeBarCatsModel model = models.get(position);
        holder.tvTitle.setText(model.getTitle());
        Glide.with(context)
                .load(model.getAdImage())
                .into(holder.imageVieww);
        holder.itemView.setOnClickListener(view -> {
            homeBarCatsInterfaceOnClick.onClick(model);
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public interface HomeBarCatsInterfaceOnClick {
        void onClick(HomeBarCatsModel model);
    }

    public static class HomeBarCatsViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imageVieww;

        public HomeBarCatsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.rowHomeCats_Name);
            imageVieww = itemView.findViewById(R.id.rowHomeCats_Image);


        }
    }
}
