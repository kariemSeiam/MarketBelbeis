package com.erots.marketbelbeis.ui.main.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.databinding.HomeFragmentBinding;
import com.erots.marketbelbeis.ui.auth.Registration;
import com.erots.marketbelbeis.ui.main.ItemSelectedNavBottom;
import com.erots.marketbelbeis.ui.main.home.test_frag.HotAdAdapter;

public class Home extends Fragment {

    ItemSelectedNavBottom selectedNavBottom;
    private HomeViewModel mViewModel;
    private HomeFragmentBinding binding;
    private NavController controller;
    private HotAdAdapter adapter;
    private NavOptions navOptions;


    public Home newInstance() {
        return new Home();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.home_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding.setLifecycleOwner(this);
        adapterRun(this);

        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(view);
        navOptions = new NavOptions.Builder().setPopUpTo(R.id.navHome, false).build();

        binding.adPanel.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), Registration.class));
        });

    }

    private void adapterRun(LifecycleOwner owner) {

        binding.recyclerMostPopular.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerCloses.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerAccessories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        mViewModel.addItems();
        mViewModel.modelLiveData.observe(owner, hotAdModels -> {
            adapter = new HotAdAdapter(hotAdModels, getContext());
            binding.recyclerAccessories.setAdapter(adapter);
            binding.recyclerMostPopular.setAdapter(adapter);
            binding.recyclerCloses.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        });


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