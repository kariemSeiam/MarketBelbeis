package com.erots.marketbelbeis.ui.main.cart;

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
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.databinding.CartFragmentBinding;
import com.erots.marketbelbeis.ui.main.ItemSelectedNavBottom;

public class Cart extends Fragment {

    private CartViewModel mViewModel;
    private NavOptions options;
    private NavController controller;
    private CartFragmentBinding binding;
    ItemSelectedNavBottom selectedNavBottom;

    public static Cart newInstance() {
        return new Cart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.cart_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        binding.setLifecycleOwner(this);
        // TODO: Use the ViewModel
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(view);
        options = new NavOptions.Builder().setPopUpTo(R.id.login, true).build();

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