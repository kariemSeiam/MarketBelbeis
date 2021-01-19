package com.erots.marketbelbeis.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.databinding.FragmentTestBinding;
import com.iceteck.silicompressorr.SiliCompressor;

import org.jetbrains.annotations.NotNull;

import java.io.File;

import static android.app.Activity.RESULT_OK;


public class test extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 100;
    FragmentTestBinding binding;
    Uri profilePath;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_test, container, false);
        return binding.getRoot();
    }

    void pickImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnTestImage.setOnClickListener(v -> {
            pickImage();
        });
        binding.imageTest.setOnClickListener(v -> makeImage());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            profilePath = data.getData();

            Glide.with(this)
                    .load(profilePath)
                    .into(binding.imageTest);
            Toast.makeText(getContext(), String.valueOf(profilePath), Toast.LENGTH_SHORT).show();
            Log.e("PhotoTest", String.valueOf(profilePath));

        }
    }

//    E/TestData: content://com.android.providers.media.documents/document/image%3A116
//    E/TestData1: file:/content:/media/external_primary/images/media/116


    void makeImage() {
        File file = new File(SiliCompressor.with(getContext()).compress(String.valueOf(profilePath), new File(getContext().getCacheDir(),
                "temp")));
        String[] strings = file.toURI().toString().split("/");
        String main = "content://com.android.providers.media.documents/document/image%3A";
        Uri uri = Uri.parse(main + strings[strings.length - 1]);
        Glide.with(this)
                .load(Uri.fromFile(file))
                .into(binding.imageTest);
        Toast.makeText(getContext(), String.valueOf(uri), Toast.LENGTH_SHORT).show();
        Log.e("PhotoTsst", String.valueOf(uri));
    }


}