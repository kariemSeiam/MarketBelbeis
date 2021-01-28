package com.erots.marketbelbeis.ui.main.marketplace;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.ui.main.ItemSelectedNavBottom;

public class Marketplace extends Fragment {

    ItemSelectedNavBottom selectedNavBottom;
    private MarketplaceViewModel mViewModel;

    public static Marketplace newInstance() {
        return new Marketplace();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.marketplace_fragment, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getContext(), "onDetach", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Toast.makeText(getContext(), "onAttach", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MarketplaceViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectedNavBottom.currentItemSelected(R.id.item_marketplace);
    }

    @Override
    public void onStart() {
        super.onStart();
        selectedNavBottom.currentItemSelected(R.id.item_marketplace);
    }


    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            selectedNavBottom = (ItemSelectedNavBottom) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }


}