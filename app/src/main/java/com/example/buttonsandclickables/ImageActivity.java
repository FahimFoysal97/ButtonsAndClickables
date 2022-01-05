package com.example.buttonsandclickables;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.buttonsandclickables.databinding.ActivityImageBinding;

public class ImageActivity extends AppCompatActivity {
    ActivityImageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUI();
    }

    private void initUI() {
        binding.imageActivityExampleImageview1.setOnClickListener(v -> Glide.with(getApplicationContext())
                .load("https://cdn.pixabay.com/photo/2015/06/19/21/24/avenue-815297_640.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imageActivityExampleImageview3));
    }
}