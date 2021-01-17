package com.erots.marketbelbeis.ui.auth;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.utils.NetworkConnection;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        NetworkConnection networkConnection = new NetworkConnection(getApplicationContext());

        networkConnection.observe(this, aBoolean -> {
            if (aBoolean) {
                Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Not Connected", Toast.LENGTH_SHORT).show();
            }

        });
    }

}