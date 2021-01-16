package com.erots.marketbelbeis.ui.auth.login;

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

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.databinding.LoginFragmentBinding;

public class Login extends Fragment {

    private LoginViewModel mViewModel;
    private LoginFragmentBinding binding;
    private NavController controller;

    public static Login newInstance() {
        return new Login();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.login_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setLifecycleOwner(this);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(view);

        binding.tvRestPassLogin.setOnClickListener(v -> {
            controller.navigate(R.id.action_login_to_restPassword);
        });
        binding.tvSignUpLogin.setOnClickListener(v -> {
            controller.navigate(R.id.action_login_to_signUp);
        });
        binding.btnLogin.setOnClickListener(v -> {

        });

    }
}