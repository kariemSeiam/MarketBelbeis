package com.erots.marketbelbeis.ui.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.databinding.HomeFragmentBinding;
import com.erots.marketbelbeis.ui.main.home.hot_ad.HotAdAdapter;
import com.erots.marketbelbeis.ui.main.home.hot_ad.HotAdModel;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {

    private final List<HotAdModel> modelList = new ArrayList<>();
    private HomeViewModel mViewModel;
    private HomeFragmentBinding binding;
    private NavController controller;
    private HotAdAdapter adapter;

    public static Home newInstance() {
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
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(view);

        adapterRun();

    }

    private void adapterRun() {
        adapter = new HotAdAdapter(modelList, getContext());

        modelList.clear();
        modelList.add(new HotAdModel("1ج", "سله العاب العاب العاب", "توب جي", "Top G", 1));
        modelList.add(new HotAdModel("25ج", "سله العاب", "سي", "سوبر ماركت قنديل", 2));
        modelList.add(new HotAdModel("500ج", "سله ", "يسي", "العتيق", 3));
        modelList.add(new HotAdModel("40ج", "سله العاب", "يسؤ", "البصيلي", 4));
        modelList.add(new HotAdModel("1234ج", "سله العاب", "يسؤ", "الزعيم", 5));
        modelList.add(new HotAdModel("25ج", "سله العاب", "يس", "العمده", 6));
        modelList.add(new HotAdModel("1000ج", "سله العاب", "يسس", "ال صيام", 7));


        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.recyclerHotAds.setLayoutManager(layoutManager);
        binding.recyclerHotAds.setHasFixedSize(true);
        binding.recyclerHotAds.setAdapter(adapter);
        binding.adapterTest.setLayoutManager(layoutManager1);
        binding.adapterTest.setHasFixedSize(true);
        binding.adapterTest.setAdapter(adapter);
        binding.layoutLogo.setOnClickListener(v -> adapter.notifyDataSetChanged());

    }

}