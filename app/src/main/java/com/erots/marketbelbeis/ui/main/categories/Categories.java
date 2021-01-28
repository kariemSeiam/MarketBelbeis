package com.erots.marketbelbeis.ui.main.categories;

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

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.databinding.CategoriesFragmentBinding;
import com.erots.marketbelbeis.ui.main.ItemSelectedNavBottom;
import com.erots.marketbelbeis.ui.main.categories.grid.AutoFitGLayout;
import com.erots.marketbelbeis.ui.main.categories.grid.CatGridAdapter;

public class Categories extends Fragment {

    ItemSelectedNavBottom selectedNavBottom;
    CategoriesFragmentBinding binding;
    CatGridAdapter adapter;
    AutoFitGLayout layoutManager = new AutoFitGLayout(getContext(), 250);

    public static Categories newInstance() {
        return new Categories();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.categories_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CategoriesViewModel mViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        binding.setLifecycleOwner(this);
        mViewModel.addCategoriesToMutableLiveData();
        mViewModel.listMutableLiveData.observe(binding.getLifecycleOwner(), catGridModels -> {
            adapter = new CatGridAdapter(catGridModels, getContext());
            binding.recyclerCategories.setAdapter(adapter);
            binding.recyclerCategories.setLayoutManager(layoutManager);
        });
        // TODO: Use the ViewModel
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