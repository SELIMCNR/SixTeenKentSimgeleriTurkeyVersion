package com.cinar.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cinar.myapplication.databinding.ActivityActvityDetailsBinding;

public class ActvityDetails extends AppCompatActivity {

    private ActivityActvityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActvityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();

        //Veri alma ve casting
        Landmark selectedLandmark = (Landmark) intent.getSerializableExtra("landmark");

        //Verileri view'e aktarma
        binding.nameText.setText(selectedLandmark.name);
        binding.countryText.setText(selectedLandmark.country);
        binding.imageView.setImageResource(selectedLandmark.image);

    }
}