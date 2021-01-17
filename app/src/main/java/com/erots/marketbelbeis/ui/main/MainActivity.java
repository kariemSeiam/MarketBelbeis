package com.erots.marketbelbeis.ui.main;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.erots.marketbelbeis.R;

public class MainActivity extends AppCompatActivity {

    NetworkConnection networkConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkConnection = new NetworkConnection(getApplicationContext());
        networkConnection.observe(this, aBoolean -> {
            if (aBoolean) {
                Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Not Connected", Toast.LENGTH_SHORT).show();
            }

        });

    }


}