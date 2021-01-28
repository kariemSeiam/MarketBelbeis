package com.erots.marketbelbeis.ui.main.categories.grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.erots.marketbelbeis.R;

import java.util.List;

public class CatGridAdapter extends RecyclerView.Adapter<CatGridAdapter.CatGridViewHolder> {

    List<CatGridModel> mValues;
    Context mContext;

    public CatGridAdapter(List<CatGridModel> mValues, Context mContext) {
        this.mValues = mValues;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CatGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_category, parent, false);
        return new CatGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatGridViewHolder holder, int position) {
        CatGridModel model = mValues.get(position);
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(mContext, model.catName, Toast.LENGTH_SHORT).show();
        });
        holder.tvCatName.setText(model.catName);
        Glide.with(mContext)
                .load(model.catDrawable)
                .into(holder.catImage);
        holder.layout.setBackgroundResource(model.backGround);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class CatGridViewHolder extends RecyclerView.ViewHolder {
        TextView tvCatName;
        ImageView catImage;
        ConstraintLayout layout;

        public CatGridViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCatName = itemView.findViewById(R.id.categoryName);
            catImage = itemView.findViewById(R.id.categoryImage);
            layout = itemView.findViewById(R.id.layoutCat);

        }


    }


}
