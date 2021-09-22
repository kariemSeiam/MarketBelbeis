package com.erots.marketbelbeis.ui.main.marketplace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erots.marketbelbeis.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    Context context;
    List<PostModel> models;

    public PostAdapter(List<PostModel> models, Context context , PostAdapter adapter) {
        this.models = models;
        this.context = context;
        adapter.notifyDataSetChanged();

    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowrow, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostModel model = models.get(position);
        holder.tvName.setText(model.getTitle());
        holder.tvMarket.setText(model.getMarket_name());
        holder.tvPrice.setText(model.getPrice() + "ج");
    }


    @Override
    public int getItemCount() {
        return models.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvMarket, tvPrice;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvMaPlIteName);
            tvMarket = itemView.findViewById(R.id.tvMaPlItemMarketName);
            tvPrice = itemView.findViewById(R.id.tvMaPlItemPrice);
        }
    }
}
