package com.erots.marketbelbeis.ui.auth;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.utils.NetworkConnection;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        checkInternet();
        String s = getCurrentDate();
    }

    private String getCurrentDate() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return dateFormat.format(date);
    }

    private void checkInternet() {
        NetworkConnection networkConnection = new NetworkConnection(getApplicationContext());
        networkConnection.observe(this, aBoolean -> {
            if (!aBoolean) {
                Toast.makeText(this, R.string.internetConnection, Toast.LENGTH_SHORT).show();
            }
        });
    }


}