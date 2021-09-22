package com.erots.marketbelbeis.ui.main.home.test_frag;

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

public class HotAdAdapter extends RecyclerView.Adapter<HotAdAdapter.HotAdViewHolder> {
    List<HotAdModel> models;
    Context context;



    public HotAdAdapter(List<HotAdModel> models, Context context) {
        this.models = models;
        this.context = context;
    }


    @NonNull
    @Override
    public HotAdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_hot_ads, parent, false);
        return new HotAdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotAdViewHolder holder, int position) {
        HotAdModel model = models.get(position);
        holder.tvTitle.setText(model.getHot_ad_title());
        holder.tvPrice.setText(model.getHot_ad_price());
        holder.tvMarket.setText(model.getHot_ad_market_name());
        Glide.with(context)
                .load(model.getTest_image())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class HotAdViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvPrice, tvMarket;
        ImageView imageView;

        public HotAdViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPrice = itemView.findViewById(R.id.tvHotAdItemPrice);
            tvTitle = itemView.findViewById(R.id.tvHotAdIteName);
            tvMarket = itemView.findViewById(R.id.tvHotAdItemMarketName);
            imageView = itemView.findViewById(R.id.imageViewHotAdItemImage);

        }
    }
}
