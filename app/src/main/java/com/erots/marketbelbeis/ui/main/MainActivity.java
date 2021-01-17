package com.erots.marketbelbeis.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.databinding.ActivityMainBinding;
import com.erots.marketbelbeis.utils.NetworkConnection;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    NetworkConnection networkConnection = new NetworkConnection(getApplicationContext());
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        checkInternet();

    }

    private void checkInternet() {
        networkConnection.observe(this, aBoolean -> {
            if (!aBoolean) {
                Snackbar.make(getCurrentFocus(), R.string.internetConnection, Snackbar.LENGTH_SHORT)
                        .show();
            }

        });
    }


}