package com.erots.marketbelbeis.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.databinding.ActivityMainBinding;
import com.erots.marketbelbeis.utils.NetworkConnection;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    NetworkConnection networkConnection;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);


    }

    private void checkInternet() {
        networkConnection = new NetworkConnection(getApplicationContext());
        networkConnection.observe(this, aBoolean -> {
            if (!aBoolean) {
                Snackbar.make(getCurrentFocus(), R.string.internetConnection, Snackbar.LENGTH_SHORT)
                        .show();
            }
        });


    }


}