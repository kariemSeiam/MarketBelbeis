package com.erots.marketbelbeis.ui.auth.signup;

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
import com.erots.marketbelbeis.databinding.SignUpFragmentBinding;

public class SignUp extends Fragment {

    private SignUpViewModel mViewModel;
    private NavController controller;
    private SignUpFragmentBinding binding;
    private NavOptions options;

    public static SignUp newInstance() {
        return new SignUp();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.sign_up_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
        binding.setLifecycleOwner(this);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(view);
        options = new NavOptions.Builder().setPopUpTo(R.id.login, true).build();
        binding.textSignUpTest.setOnClickListener(v -> {
            controller.navigate(R.id.action_signUp_to_login, null, options);
        });


    }

}