package com.erots.marketbelbeis.ui.main.marketplace;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.databinding.MarketplaceFragmentBinding;
import com.erots.marketbelbeis.ui.main.ItemSelectedNavBottom;
import com.erots.marketbelbeis.viewmodels.MarketplaceViewModel;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Marketplace extends Fragment {

    ItemSelectedNavBottom selectedNavBottom;
    MarketplaceFragmentBinding binding;
    PostAdapter adapter;
    private MarketplaceViewModel mViewModel;

    public static Marketplace newInstance() {
        return new Marketplace();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.marketplace_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MarketplaceViewModel.class);
        binding.setLifecycleOwner(this);


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectedNavBottom.currentItemSelected(R.id.item_marketplace);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



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