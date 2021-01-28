package com.erots.marketbelbeis.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.databinding.ActivityMainBinding;
import com.erots.marketbelbeis.ui.main.cart.Cart;
import com.erots.marketbelbeis.ui.main.categories.Categories;
import com.erots.marketbelbeis.ui.main.favorite.Favorite;
import com.erots.marketbelbeis.ui.main.home.Home;
import com.erots.marketbelbeis.ui.main.marketplace.Marketplace;
import com.erots.marketbelbeis.utils.NetworkConnection;

public class MainActivity extends AppCompatActivity implements ItemSelectedNavBottom {

    final Fragment getFrag1 = new Marketplace();
    final Fragment getFrag2 = new Categories();
    final Fragment getFrag3 = new Home();
    final Fragment getFrag4 = new Favorite();
    final Fragment getFrag5 = new Cart();
    FragmentManager fm = getSupportFragmentManager();
    int a = 0;
    NavController controller;
    private Fragment active = getFrag3;
    private NetworkConnection networkConnection;
    private ActivityMainBinding binding;
    private NavOptions navOptions;

    @SuppressLint({"NonConstantResourceId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        checkInternet();
//        controller = Navigation.findNavController(this, R.id.fragmentContainerViewMain);
        navOptions = new NavOptions.Builder().setPopUpTo(R.id.navHome, false).build();


        binding.bottomNavViewHome.setSelectedItemId(R.id.item_home);

        binding.bottomNavViewHome.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.item_cart:
                    fm.beginTransaction().hide(active).show(getFrag5).commit();
                    active = getFrag5;
                    return true;
                case R.id.item_cat:
                    fm.beginTransaction().hide(active).show(getFrag2).commit();
                    active = getFrag2;
                    return true;
                case R.id.item_fav:
                    fm.beginTransaction().hide(active).show(getFrag4).commit();
                    active = getFrag4;
                    return true;
                case R.id.item_marketplace:
                    fm.beginTransaction().hide(active).show(getFrag1).commit();
                    active = getFrag1;
                    return true;
                case R.id.item_home:
                    fm.beginTransaction().hide(active).show(getFrag3).commit();
                    active = getFrag3;
//                    Navigation.findNavController(this, R.id.fragmentContainerViewMain).navigate(R.id.navHome);
                    return true;

            }
            return false;
        });


    }

    @Override
    protected void onStart() {
        fragmentTransaction();
        super.onStart();
    }

    private synchronized void fragmentTransaction() {
        fm.beginTransaction().add(R.id.fragmentContainerViewMain, getFrag1).hide(getFrag1).commit();
        fm.beginTransaction().add(R.id.fragmentContainerViewMain, getFrag2).hide(getFrag2).commit();
        fm.beginTransaction().add(R.id.fragmentContainerViewMain, getFrag3).commit();
        fm.beginTransaction().add(R.id.fragmentContainerViewMain, getFrag4).hide(getFrag4).commit();
        fm.beginTransaction().add(R.id.fragmentContainerViewMain, getFrag5).hide(getFrag5).commit();
    }

    private void checkInternet() {
        networkConnection = new NetworkConnection(getApplicationContext());
        networkConnection.observe(this, aBoolean -> {
            if (!aBoolean) {
                Toast.makeText(this, R.string.internetConnection, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void currentItemSelected(int i) {

    }

    @Override
    public void onBackPressed() {
        a += 1;
        if (a == 2) {
            finish();
        }
    }


}